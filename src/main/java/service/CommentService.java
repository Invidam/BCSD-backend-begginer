package service;


import domain.Comment;

public interface CommentService {
    void createComment(Comment comment);
    Comment getCommentById(long id);
    void updateComment(Comment comment);
    void deleteComment(long id);
}
