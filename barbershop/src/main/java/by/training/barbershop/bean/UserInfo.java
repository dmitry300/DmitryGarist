package by.training.barbershop.bean;

import java.sql.Date;
import java.util.Objects;

public class UserInfo extends Entity {
    private String name;
    private String surname;
    private String patronymic;
    private long phone;
    private Date birthday;
    private String email;

    public UserInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserInfo userInfo = (UserInfo) o;
        return phone == userInfo.phone && Objects.equals(name, userInfo.name) && Objects.equals(surname, userInfo.surname) && Objects.equals(patronymic, userInfo.patronymic) && Objects.equals(birthday, userInfo.birthday) && Objects.equals(email, userInfo.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname, patronymic, phone, birthday, email);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phone=" + phone +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                '}';
    }
}
