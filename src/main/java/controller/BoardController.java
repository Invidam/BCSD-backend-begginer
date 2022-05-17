package controller;


import domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.BoardService;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(value="create", method = RequestMethod.GET)
    public String createBoard() {
        Board board = new Board();
        board.setTitle("Mybatis first title");
        board.setContent("Mybatis first content");
        board.setCategory("mybatis");
        board.setUserId(1L);
        board.setIsValid(true);
        List<String> list = new ArrayList<>();
        list.add("HELLO_DB");
        list.add("NEW_TAG");

        board.setHashTags(list);

        boardService.createBoard(board);
        return "createBoard";
    }

    @GetMapping(value="read")
    public Board getBoardInfo(){
        return boardService.getBoardById(1L);
    }
    @RequestMapping(value="update", method = RequestMethod.GET)
    public String updateBoardTitle() {
        Board board = new Board();
        board.setId(1L);
        board.setTitle("Updated by mybatis!!");

        boardService.updateBoardTitle(board);
        return "update board";
    }
    @RequestMapping(value="delete", method = RequestMethod.GET)
    public String deleteBoard() {
        boardService.deleteBoard(20L);
        return "delete board";
    }
}

