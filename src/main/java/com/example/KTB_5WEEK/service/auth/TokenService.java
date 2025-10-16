package com.example.KTB_5WEEK.service.auth;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;
import java.util.Map;
import java.util.Optional;

@Component
public class TokenService {
    @Value("${application.auth.secret}")
    private String secret_key;

    private static final Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
    private static final Base64.Decoder decoder = Base64.getUrlDecoder();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // 토큰 발급
    public String issue(long userId, Duration ttl) {
        long now = System.currentTimeMillis();
        long exp = now + ttl.toMillis();
        Map<String, Object> header = Map.of(
                "alg", "HS256",
                "typ", "JWT"
        );

        Map<String, Object> payload = Map.of(
                "iss", "KTB-4WEEK", // 발급자
                "sub", userId, // 제목
                "exp", exp, // 만료 시간
                "iat", now // 발급 시간
        );

        String headerBase64 = base64UrlEncode(header);
        String payloadBase64 = base64UrlEncode(payload);
        String signature = encryptByHmacSHA256(headerBase64 + "." + payloadBase64);
        String token = headerBase64 + "." + payloadBase64 + "." + signature;

        return token;
    }

    // 토큰 검증
    public Optional<Long> verify(String token) {
        String[] parts = token.split("\\.");
        if (parts.length != 3) return Optional.ofNullable(null);

        Map<String, Object> header = base64UrlDecode(parts[0]);
        Map<String, Object> payload = base64UrlDecode(parts[1]);

        if (!header.get("alg").equals("HS256") || !header.get("typ").equals("JWT")) {
            return Optional.ofNullable(null);
        }

        if (!parts[2].equals(encryptByHmacSHA256(parts[0] + "." + parts[1]))) {
            return Optional.ofNullable(null);
        }

        long now = System.currentTimeMillis();
        long exp = ((Number) payload.get("exp")).longValue();
        if (exp < now) return Optional.ofNullable(null);

        long userId = ((Number) payload.get("sub")).longValue(); // userId
        return Optional.ofNullable(userId);
    }

    // Object -> byte[] -> Base64 Encode
    private String base64UrlEncode(Map<String, Object> toByte) {
        try {
            byte[] json = objectMapper.writeValueAsBytes(toByte);
            return encoder.encodeToString(json);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    // Base64 Decode -> byte[] -> Object
    private Map<String, Object> base64UrlDecode(String encrypted) {
        try {
            byte[] json = decoder.decode(encrypted);
            return objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    // Encrypt By Hmac SHA256
    private String encryptByHmacSHA256(String target) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret_key.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            return encoder.encodeToString(mac.doFinal(target.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
