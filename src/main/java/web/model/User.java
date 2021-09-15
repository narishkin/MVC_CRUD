package web.model;

import javax.persistence.*;

@Entity(name = "users")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_seq",
            sequenceName = "user_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "user_seq"
    )
    @Column(name = "id",
    updatable = false)
    Long id;
    @Column(name = "name",
    nullable = false,
    unique = true,
    columnDefinition = "TEXT")
    String name;
    @Column(name = "age")
    Integer age;
    @Column(name = "danger")
    Boolean danger;

    public User() {
    }

    public User(String userName, Integer userAge, Boolean danger) {
        this.name = userName;
        this.age = userAge;
        this.danger = danger;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long userId) {
        this.id = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String userName) {
        this.name = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer userAge) {
        this.age = userAge;
    }

    public Boolean getDanger() {
        return danger;
    }

    public void setDanger(Boolean danger) {
        this.danger = danger;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + id +
                ", userName='" + name + '\'' +
                ", userAge=" + age +
                ", danger=" + danger +
                '}';
    }
}
