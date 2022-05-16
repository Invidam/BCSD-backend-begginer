package domain;

import java.util.List;

public class Board {
    private long id;
    private String title;
    private String content;
    private long userId;
    private String category;
    private boolean isValid;
    private List<String> hashTags;
    private List<Comment> comments;
//    private DateTime createdAt;
//    private DateTime suspendAt;
//    private String suspend_code;

    public long getId() {return this.id;}
    public String getTitle() {return this.title;}
    public String getContent() {return this.content;}
    public long getUserId() {return this.userId;}
    public String getCategory() {return this.category;}
    public boolean getIsValid() {return this.isValid;}
    public List<String> getHashTags() {return this.hashTags;}
    public List<Comment> getComments() {return this.comments;}


    public void setId(long id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setContent(String content) {this.content = content;}
    public void setUserId(long userId) {this.userId = userId;}
    public void setCategory(String category) {this.category = category;}
    public void setIsValid(boolean isValid) {this.isValid = isValid;}
    public void setHashTags(List<String> hashTags) {this.hashTags = hashTags;}
    public void setComments(List<Comment> comments) {this.comments = comments;}

}