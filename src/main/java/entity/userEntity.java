package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "USER")
public class userEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "NATIONAL_CODE")
    private String nationalCode;

    @Column(name = "BIRTHDAY")
    private LocalDate birthday;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROLL_USER")
    private String rollUser;


    public userEntity() {
    }

    public userEntity(String userName,
                      String firstName,
                      String lastName,
                      String nationalCode,
                      LocalDate birthday,
                      String password,
                      String rollUser) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.birthday = birthday;
        this.password = password;
        this.rollUser = rollUser;
    }

    @Override
    public String toString() {
        return "userEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", birthday=" + birthday +
                ", password='" + password + '\'' +
                ", rollUser='" + rollUser + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRollUser() {
        return rollUser;
    }

    public void setRollUser(String rollUser) {
        this.rollUser = rollUser;
    }
}
