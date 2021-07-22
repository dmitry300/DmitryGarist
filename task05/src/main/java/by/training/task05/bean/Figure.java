package by.training.task05.bean;

import java.util.Objects;

public abstract class Figure {
    private long id;

    protected Figure() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return id == figure.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Figure{" +
                "id=" + id +
                '}';
    }
}
