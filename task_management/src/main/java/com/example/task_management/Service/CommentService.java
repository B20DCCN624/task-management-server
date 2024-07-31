package com.example.task_management.Service;

import com.example.task_management.model.Comment;
import com.example.task_management.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        List<Comment> comments = new ArrayList<Comment>();
        commentRepository.findAll().forEach(comments::add);
        return comments;
    }

    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteCommentById(int id) {
        commentRepository.deleteById(id);
    }
}
