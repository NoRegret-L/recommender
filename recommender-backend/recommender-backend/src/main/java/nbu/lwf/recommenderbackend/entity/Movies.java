package nbu.lwf.recommenderbackend.entity;

import javax.persistence.Column;

public class Movies {

    public Movies(Long mid, String name, String tp) {
        this.mid = mid;
        this.name = name;
        this.tp = tp;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    @Column(name = "mid")
    private Long mid;
    @Column(name = "name")
    private String name;
    @Column(name = "tp")
    private String tp;
}
