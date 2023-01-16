package entity;

import java.util.Objects;

public class Telecast {
    private int idTelecast;
    private String name;
    private int rate;
    private float costMinute;

    public Telecast() {
    }

    public Telecast(int idTelecast, String name, int rate, float costMinute) {
        assert rate > 0 && rate < 11 && costMinute > 9;
        this.idTelecast = idTelecast;
        this.name = name;
        this.rate = rate;
        this.costMinute = costMinute;
    }

    public int getIdTelecast() {
        return idTelecast;
    }

    public void setIdTelecast(int idTelecast) {
        this.idTelecast = idTelecast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public float getCostMinute() {
        return costMinute;
    }

    public void setCostMinute(float costMinute) {
        this.costMinute = costMinute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telecast telecast = (Telecast) o;
        return idTelecast == telecast.idTelecast && rate == telecast.rate && Float.compare(telecast.costMinute, costMinute) == 0 && name.equals(telecast.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTelecast, name, rate, costMinute);
    }

    @Override
    public String toString() {
        return "Telecast{" +
                "idTelecast=" + idTelecast +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", costMinute=" + costMinute +
                '}';
    }
}
