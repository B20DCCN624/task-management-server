package com.example.task_management.controller;

import com.example.task_management.Service.CommentService;
import com.example.task_management.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comment")
    private List<Comment> getComments() {
        return commentService.getAllComments();
    }

    @PostMapping("/addComment")
    private Comment addComment(@RequestBody Comment comment) {
        commentService.addComment(comment);
        return comment;
    }

    @DeleteMapping("/deleteComment/{id}")
    private void deleteComment(@PathVariable("id") int id) {
        commentService.deleteCommentById(id);
    }
}
