package entity;

import java.sql.Timestamp;
import java.util.Objects;

public class Orders {
    private int refCustomer;
    private int refTelecast;
    private int refTrailer;
    private Timestamp releaseDate;

    public Orders() {
    }

    public Orders(int refCustomer, int refTelecast, int refTrailer, Timestamp releaseDate) {
        this.refCustomer = refCustomer;
        this.refTelecast = refTelecast;
        this.refTrailer = refTrailer;
        this.releaseDate = releaseDate;
    }

    public int getRefCustomer() {
        return refCustomer;
    }

    public void setRefCustomer(int refCustomer) {
        this.refCustomer = refCustomer;
    }

    public int getRefTelecast() {
        return refTelecast;
    }

    public void setRefTelecast(int refTelecast) {
        this.refTelecast = refTelecast;
    }

    public int getRefTrailer() {
        return refTrailer;
    }

    public void setRefTrailer(int refTrailer) {
        this.refTrailer = refTrailer;
    }

    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return refCustomer == orders.refCustomer && refTelecast == orders.refTelecast && refTrailer == orders.refTrailer && releaseDate.equals(orders.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refCustomer, refTelecast, refTrailer, releaseDate);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "refCustomer=" + refCustomer +
                ", refTelecast=" + refTelecast +
                ", refTrailer=" + refTrailer +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
