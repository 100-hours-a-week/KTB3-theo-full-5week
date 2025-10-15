package com.example.KTB_4WEEK.repository.user.email;

import com.example.KTB_4WEEK.entity.User;
import com.example.KTB_4WEEK.util.table.EmailTable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class EmailRepository {
    private final EmailTable emailTable;

    public EmailRepository(EmailTable emailTable) {
        this.emailTable = emailTable;
    }

    // User find By email
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(emailTable.getTable().get(email));
    }

    // Insert User to Email Table
    public Optional<User> mapUserByEMail(User user) {
        ConcurrentHashMap<String, User> emails = emailTable.getTable();
        emails.put(user.getEmail(), user);
        return Optional.ofNullable(emails.get(user.getEmail()));
    }
}
