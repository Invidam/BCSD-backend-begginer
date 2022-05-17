package service;

import domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BoardMapper;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public void createBoardSelf(Board board) {
        boardMapper.createBoard(board);
    }


    @Override
    public long findCategoryId(String category) {
        return boardMapper.findCategoryById(category);
    }
    @Override
    public long findHashTagId(String hashTag) {
        return boardMapper.findHashTagById(hashTag);
    }

    @Override
    public void createCategory(String category) {
        boardMapper.createCategory(category);
    }

    @Override
    public void createHashTag(String hashTag) {
        boardMapper.createHashTag(hashTag);
    }
    @Override
    public void createHashTagRelationShip(long boardId, String hashTag) {
        long hashTagId = findHashTagId(hashTag);
        boardMapper.createHashTagsRelationship(boardId,hashTagId);

    }
    @Override
    public void deleteHashTagRelationShip(long id) {
        boardMapper.deleteHashTagRelationShip(id);
    }
    @Override
    public void deleteComment(long id) {
        boardMapper.deleteCommentByBoardId(id);
    }
    @Override
    public boolean isExistCategory(String category) {
        return boardMapper.isExistCategory(category) > 0;
    }

    @Override
    public boolean isExistHashTag(String hashTag) {
        return boardMapper.isExistHashTag(hashTag) > 0;
    }

    @Override
    public void createBoard(Board board) {
        if(!isExistCategory(board.getCategory())) createCategory(board.getCategory());
        List<String> hashTags = board.getHashTags();
        for (String hashTag: hashTags) {
            if(!isExistHashTag(hashTag)) createHashTag(hashTag);
        }
        createBoardSelf(board);

        for (String hashTag: hashTags) {
            createHashTagRelationShip(board.getId(),hashTag);
        }
    }

    @Override
    public Board getBoardById(long id) {
        return boardMapper.getBoardById(id);
        //보드 id를 어떻게 얻을 것이냐.
    }
//
    @Override
    public void updateBoardTitle(Board board) {
        boardMapper.updateBoardTitle(board);
    }

    @Override
    public void deleteBoard(long id) {
        //해시태그 관계 삭제
        //댓글 관계 삭제


        // 카테고리 id가져오는 방법
        // 댓글 목록 어떻게?
        deleteHashTagRelationShip(id);
        deleteComment(id);
        boardMapper.deleteBoardById(id);
    }
}