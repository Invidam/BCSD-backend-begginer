package service;

import domain.Board;

public interface BoardService {
    void createBoardSelf(Board board);
    long findCategoryId(String category);
    long findHashTagId(String hashTag);
    void createCategory(String category);
    void createHashTag(String hashTag);

    void createCategoryRelationShip(long boardId, String category);

    void createHashTagRelationShip(long boardId, String hashTag);

    //hash -> id 필요.
    void deleteHashTagRelationShip(long id);
    void deleteComment(long id);
    boolean isExistCategory(String category);
    boolean isExistHashTag(String hashTag);

    void createBoard(Board board);

    Board getBoardById(long id);

    void updateBoardTitle(Board board);

    void deleteBoard(long id);
}
