package web.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id",
    updatable = false)
    private Long id;
    @Column(name = "name",
    nullable = false,
    unique = true,
    columnDefinition = "TEXT")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "danger")
    private Boolean danger;

    public User() {
    }

    public User(String name, Integer age, Boolean danger) {
        this.name = name;
        this.age = age;
        this.danger = danger;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(age, user.age) &&
                Objects.equals(danger, user.danger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
