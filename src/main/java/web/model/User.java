package web.model;

public class User {
    long userId;
    String userName;
    int userAge;
    boolean danger;

    public User() {
    }

    public User(long userId, String userName, int userAge, boolean danger) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.danger = danger;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public boolean getDanger() {
        return danger;
    }

    public void setDanger(boolean danger) {
         this.danger= danger;
    }
}
