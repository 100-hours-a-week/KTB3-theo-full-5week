package com.example.KTB_4WEEK.util.table;

import com.example.KTB_4WEEK.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CommentTable implements Table {
    private ConcurrentHashMap<Long, Comment> comments = new ConcurrentHashMap<>();
    private long sequence = 1L;

    public CommentTable() {
//        comments.put(++sequence, new Comment(sequence, 1, 1, "댓글 1"));
//        comments.put(++sequence, new Comment(sequence, 1, 1, "댓글 2"));
//        comments.put(++sequence, new Comment(sequence, 1, 1, "댓글 3"));
//        comments.put(++sequence, new Comment(sequence, 1, 1, "댓글 4"));
//
//        comments.put(++sequence, new Comment(sequence, 2, 2, "댓글 1"));
//        comments.put(++sequence, new Comment(sequence, 2, 2, "댓글 2"));
//        comments.put(++sequence, new Comment(sequence, 2, 2, "댓글 3"));
//        comments.put(++sequence, new Comment(sequence, 2, 2, "댓글 4"));
    }

    @Override
    public ConcurrentHashMap<Long, Comment> getTable() {
        return this.comments;
    }

    public long increaseSequence() {
        return sequence++;
    }
}
