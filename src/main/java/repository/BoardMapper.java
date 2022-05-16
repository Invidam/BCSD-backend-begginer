package repository;

import domain.Board;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardMapper {
    void createBoard(Board board);
    long findCategoryById(String category) ;
    long findHashTagById(String hashTag);
    Board getBoardById(Long id);
    void updateBoardTitle(Board board);
    void deleteBoardById(Long id);
    int isExistCategory(String category);
    int isExistHashTag(String hashTag);

    void createCategory(String category);

    void createHashTag(String hashTag);

    void createHashTagsRelationship(@Param("boardId") long boardId, @Param("hashTagId") long hashTagId);

    void deleteHashTagRelationShip(long id);

    void deleteCommentByBoardId(long id);

//    long getCategoryId(String category);
//    long getHashTagId(String hashTag);
}
