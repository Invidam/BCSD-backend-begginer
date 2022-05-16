package repository;

import domain.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper {
    void createComment(Comment comment);
    Comment getCommentById(Long id);
    void updateComment(Comment comment);
    void deleteCommentById(Long id);
}
