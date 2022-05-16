package controller;


import domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {


    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value="create", method = RequestMethod.GET)
    public String createComment() {
        Comment comment = new Comment();
        comment.setContent("commented by mybatis! ");
        comment.setBoardId(1L);
        comment.setUserId(1L);
        comment.setIsValid(true);

        commentService.createComment(comment);
        return "createComment";
    }

    //    @RequestMapping(value="create", method = RequestMethod.POST)
//    public String createCommentProcess() {
//        return "comment created";
//    }
    @GetMapping(value="read")
    public Comment getCommentInfo(){
        return commentService.getCommentById(1L);
    }
    @RequestMapping(value="update", method = RequestMethod.GET)
    public String updateCommentNickname() {
        Comment comment = new Comment();
        comment.setId(1L);
        comment.setContent("updated by mybatis! ");
        comment.setBoardId(1L);
        comment.setUserId(1L);
        comment.setIsValid(true);

        commentService.updateComment(comment);
        return "update comment";
    }
    @RequestMapping(value="delete", method = RequestMethod.GET)
    public String deleteComment() {
        commentService.deleteComment(5L);
        return "delete comment";
    }
}

