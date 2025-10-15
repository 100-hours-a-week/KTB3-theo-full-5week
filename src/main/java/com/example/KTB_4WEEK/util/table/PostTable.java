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
//        posts.put(++sequence,
//                new Post(sequence, 1, "title", "article",
//                        PostCategory.COMMUNITY, "image"));
//        posts.put(++sequence,
//                new Post(sequence, 1, "title1", "article1",
//                        PostCategory.COMMUNITY, "image1"));
//        posts.put(++sequence,
//                new Post(sequence, 2, "title2", "article2",
//                        PostCategory.COMMUNITY, "image2"));
//        posts.put(++sequence,
//                new Post(sequence, 2, "title3", "article2",
//                        PostCategory.COMMUNITY, "image3"));
    }

    @Override
    public ConcurrentHashMap<Long, Post> getTable() {
        return posts;
    }

    public long increaseSequence() {
        return sequence.getAndIncrement();
    }

}
