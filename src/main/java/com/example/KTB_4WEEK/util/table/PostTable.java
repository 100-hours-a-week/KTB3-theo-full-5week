package com.example.KTB_4WEEK.util.table;

import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.example.KTB_4WEEK.entity.Post;
import com.example.KTB_4WEEK.entity.PostCategory;
import org.springframework.stereotype.Component;

@Component
public class PostTable implements Table {
    private ConcurrentHashMap<Long, Post> posts = new ConcurrentHashMap<>();
    private AtomicLong sequence = new AtomicLong(1);

    public PostTable() {
    }

    @Override
    public ConcurrentHashMap<Long, Post> getTable() {
        return posts;
    }

    public long increaseSequence() {
        return sequence.getAndIncrement();
    }

}
