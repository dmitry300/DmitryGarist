package by.training.barbershop.bean;

import java.sql.Timestamp;
import java.util.Objects;

public class Review extends Entity {
    private String comment;
    private Timestamp commentData;
    private User user;
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
    UserInfo userInfo = new UserInfo();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (!super.equals(o)) return false;
        Review review = (Review) o;
        return Objects.equals(comment, review.comment) && Objects.equals(commentData, review.commentData) && Objects.equals(user, review.user) && Objects.equals(barber, review.barber) && Objects.equals(userInfo, review.userInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), comment, commentData, user, barber, userInfo);
    }

    @Override
    public String toString() {
        return "Review{" +
                "comment='" + comment + '\'' +
                ", commentData=" + commentData +
                ", user=" + user +
                ", barber=" + barber +
                ", userInfo=" + userInfo +
                '}';
    }
}
