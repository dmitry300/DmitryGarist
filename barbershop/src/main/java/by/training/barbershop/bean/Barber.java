package by.training.barbershop.bean;

import java.sql.Date;
import java.util.Objects;

public class Barber extends Entity {
    private String name;
    private String surname;
    private String patronymic;
    private Date birthday;
    private int age;
    private String photo;
    private long phone;
    private Date startJob;
    private Date endJob;
    private String tiktokLink;

    public Barber() {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Date getStartJob() {
        return startJob;
    }

    public void setStartJob(Date startJob) {
        this.startJob = startJob;
    }

    public Date getEndJob() {
        return endJob;
    }

    public void setEndJob(Date endJob) {
        this.endJob = endJob;
    }

    public String getTiktokLink() {
        return tiktokLink;
    }

    public void setTiktokLink(String tiktokLink) {
        this.tiktokLink = tiktokLink;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Barber barber = (Barber) o;
        return age == barber.age && phone == barber.phone && Objects.equals(name, barber.name) && Objects.equals(surname, barber.surname) && Objects.equals(patronymic, barber.patronymic) && Objects.equals(birthday, barber.birthday) && Objects.equals(photo, barber.photo) && Objects.equals(startJob, barber.startJob) && Objects.equals(endJob, barber.endJob) && Objects.equals(tiktokLink, barber.tiktokLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname, patronymic, birthday, age, photo, phone, startJob, endJob, tiktokLink);
    }

    @Override
    public String toString() {
        return "Barber{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", photo='" + photo + '\'' +
                ", phone=" + phone +
                ", startJob=" + startJob +
                ", endJob=" + endJob +
                ", tiktokLink='" + tiktokLink + '\'' +
                '}';
    }
}
