package by.training.barbershop.bean;

import java.sql.Timestamp;
import java.util.Objects;

public class Review extends Entity {
    private String comment;
    private Timestamp commentData;
    private UserInfo userInfo;
    private Barber barber;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getCommentData() {
        return commentData;
    }

    public void setCommentData(Timestamp commentData) {
        this.commentData = commentData;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Barber getBarber() {
        return barber;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(comment, review.comment) && Objects.equals(commentData, review.commentData) && Objects.equals(userInfo, review.userInfo) && Objects.equals(barber, review.barber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment, commentData, userInfo, barber);
    }

    @Override
    public String toString() {
        return "Review{" +
                "comment='" + comment + '\'' +
                ", commentData=" + commentData +
                ", userInfo=" + userInfo +
                ", barber=" + barber +
                '}';
    }
}
