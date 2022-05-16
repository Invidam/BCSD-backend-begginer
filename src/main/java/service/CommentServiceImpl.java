package service;

import domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void createComment(Comment comment) {
        commentMapper.createComment(comment);
    }

    @Override
    public Comment getCommentById(long id) {
        return commentMapper.getCommentById(id);
    }

    @Override
    public void updateComment(Comment comment) {
        commentMapper.updateComment(comment);
    }

    @Override
    public void deleteComment(long id) {
        commentMapper.deleteCommentById(id);
    }
}