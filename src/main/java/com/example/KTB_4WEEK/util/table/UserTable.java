package com.example.KTB_4WEEK.util.table;

import java.util.LinkedHashMap;

import com.example.KTB_4WEEK.entity.User;
import org.springframework.stereotype.Component;


@Component
public class UserTable implements Table {
    private LinkedHashMap<Long, User> users = new LinkedHashMap<>();
    private long sequence = 0L;

    public UserTable() {
//        users.put(++sequence, new User(sequence,
//                "email", "password", "nickname", "profile_image"));
//        users.put(++sequence, new User(sequence,
//                "email1", "password1", "nickname1", "profile_image1"));
//        users.put(++sequence, new User(sequence,
//                "email2", "password2", "nickname2", "profile_image2"));
    }

    @Override // DB User Table 조회
    public LinkedHashMap<Long, User> getTable() {
        return users;
    }

    public long increaseSequence() {
        return sequence++;
    }

}
