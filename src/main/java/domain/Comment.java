package domain;

import java.util.List;

public class Comment {

    public long id;
    public String content;
    public long userId;
    public long boardId;
    public boolean isValid;
//    public DateTime createdAt;
//    public DateTime suspendAt;
//    public String suspend_code;

    public long getId() {return this.id;}
    public String getContent() {return this.content;}
    public long getUserId() {return this.userId;}
    public long getBoardId() {return this.boardId;}
    public boolean getIsValid() {return this.isValid;}


    public void setId(long id) {this.id = id;}
    public void setContent(String content) {this.content = content;}
    public void setUserId(long userId) {this.userId = userId;}
    public void setBoardId(long boardId) {this.boardId = boardId;}
    public void setIsValid(boolean isValid) {this.isValid = isValid;}

}