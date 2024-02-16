package Championnat.automobile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Classement {
    protected int id_classement;
    protected int place;
    protected BigDecimal gain;
    protected List<Pilote> list_pilote=new ArrayList<Pilote>();

    public Classement() {
    }

    public Classement(int id_classement, int place, BigDecimal gain) {
        this.id_classement = id_classement;
        this.place = place;
        this.gain = gain;
    }

    public int getId_classement() {
        return id_classement;
    }

    public void setId_classement(int id_classement) {
        this.id_classement = id_classement;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public BigDecimal getGain() {
        return gain;
    }

    public void setGain(BigDecimal gain) {
        this.gain = gain;
    }

    public List<Pilote> getList_pilote() {
        return list_pilote;
    }

    public void setList_pilote(List<Pilote> list_pilote) {
        this.list_pilote = list_pilote;
    }

    @Override
    public String toString() {
        return "Classement{" +
                "id_classement=" + id_classement +
                ", place=" + place +
                ", gain=" + gain +
                '}';
    }
}
