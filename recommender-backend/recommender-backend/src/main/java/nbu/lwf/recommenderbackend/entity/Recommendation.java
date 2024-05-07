package nbu.lwf.recommenderbackend.entity;
import java.util.Objects;

public class Recommendation {
    long mid;
    String name;
    String link;

    public Recommendation(long mid, String name, String link) {
        this.mid = mid;
        this.name = name;
        this.link = link;
    }

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recommendation that = (Recommendation) o;
        return mid == that.mid &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mid, name);
    }
}
