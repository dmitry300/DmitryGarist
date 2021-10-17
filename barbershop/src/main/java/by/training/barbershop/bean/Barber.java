package by.training.barbershop.bean;

import java.sql.Date;
import java.util.Objects;

public class Barber extends Entity {
    private String name;
    private String surname;
    private String patronymic;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Barber barber = (Barber) o;
        return id == barber.id && age == barber.age && phone == barber.phone && Objects.equals(name, barber.name) && Objects.equals(surname, barber.surname) && Objects.equals(patronymic, barber.patronymic) && Objects.equals(photo, barber.photo) && Objects.equals(startJob, barber.startJob) && Objects.equals(endJob, barber.endJob) && Objects.equals(tiktokLink, barber.tiktokLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, age, photo, phone, startJob, endJob, tiktokLink);
    }

    @Override
    public String toString() {
        return "Barber{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", photo='" + photo + '\'' +
                ", phone=" + phone +
                ", start_job=" + startJob +
                ", end_job=" + endJob +
                ", tiktok_link='" + tiktokLink + '\'' +
                '}';
    }
}
