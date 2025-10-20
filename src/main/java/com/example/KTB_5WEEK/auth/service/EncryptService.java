package com.example.KTB_5WEEK.auth.service;

import com.example.KTB_5WEEK.auth.service.encryption.Encrypt;
import org.springframework.stereotype.Component;

@Component
public class EncryptService {
    private Encrypt encrypt;

    public EncryptService(Encrypt encrypt) {
        this.encrypt = encrypt;
    }

    public String encryptPayload(String target, String secretKey) {
        return encrypt.encrypt(target, secretKey);
    }

    public String getEncryptAlgorithm() {
        return encrypt.getAlgorithm();
    }
}
