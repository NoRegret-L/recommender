package nbu.lwf.recommenderbackend.entity;


import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "preferences")
public class Preference {
    public Preference(String uid, Long mid, Long hs) {
        this.uid = uid;
        this.mid = mid;
        this.hs = hs;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    @Column(name = "uid")
    private String uid;
    @Column(name = "mid")
    private Long mid;
    @Column(name = "hs")
    private Long hs;

    public Long getHs() {
        return hs;
    }

    public void setHs(Long hs) {
        this.hs = hs;
    }
}
