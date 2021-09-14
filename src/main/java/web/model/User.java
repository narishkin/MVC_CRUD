package web.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity(name = "Http_users")
@Transactional
public class User {

    @Id
    @SequenceGenerator(
            name = "user_seq",
            sequenceName = "user_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_seq"
    )
    @Column(name = "user_id",
    updatable = false)
    long userId;
    @Column(name = "user_name",
    nullable = false,
    unique = true,
    columnDefinition = "TEXT")
    String userName;
    @Column(name = "user_age")
    int userAge;
    @Column(name = "user_danger")
    boolean danger;

    public User() {
    }

    public User(String userName, int userAge, boolean danger) {
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
        this.danger = danger;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("userId=").append(userId);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", userAge=").append(userAge);
        sb.append(", danger=").append(danger);
        sb.append('}');
        return sb.toString();
    }
}
