package entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

public class Trailer {
    private int idTrailer;
    private String name;
    private Time duration;

    public Trailer() {
    }

    public Trailer(int idTrailer, String name, Time duration) {
        assert duration.after(Time.valueOf("00:00:09")) && duration.before(Time.valueOf("00:04:01"));
        this.idTrailer = idTrailer;
        this.name = name;
        this.duration = duration;
    }

    public int getIdTrailer() {
        return idTrailer;
    }

    public void setIdTrailer(int idTrailer) {
        this.idTrailer = idTrailer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trailer trailer = (Trailer) o;
        return idTrailer == trailer.idTrailer && name.equals(trailer.name) && duration.equals(trailer.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTrailer, name, duration);
    }

    @Override
    public String toString() {
        return "Trailer{" +
                "idTrailer=" + idTrailer +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
