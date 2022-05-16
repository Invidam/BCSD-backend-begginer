package domain;

import tools.DateTime;

public class User {
    private Long id;
    private String account;
    private String password;
    private String nickname;
    private boolean isValid;
//    public DateTime createdAt;
//    public DateTime suspendAt;
//    public DateTime releaseAt;
//    public String suspendCode;

    public Long getId() {return this.id;}
    public String getAccount() {return this.account;}
    public String getPassword() {return this.password;}
    public String getNickname() {return this.nickname;}
    public boolean getIsValid() {return this.isValid;}
//    public DateTime getCreatedAt() {return this.createdAt;}
//    public DateTime getSuspendAt() {return this.suspendAt;}
//    public DateTime getReleaseAt() {return this.releaseAt;}
//    public String getSuspendCode() {return this.suspendCode;}


    public void setId(Long id) {this.id = id;}
    public void setAccount(String account) {this.account = account;}
    public void setPassword(String password) {this.password = password;}
    public void setNickname(String nickname) {this.nickname = nickname;}
    public void setIsValid(boolean isValid) {this.isValid = isValid;}
//    public void setCreatedAt(DateTime createdAt) {this.createdAt = createdAt;}
//    public void setSuspendAt(DateTime suspendAt) {this.suspendAt = suspendAt;}
//    public void setReleaseAt(DateTime releaseAt) {this.releaseAt = releaseAt;}
//    public void setSuspendCode(String suspendCode) {this.suspendCode = suspendCode;}


}