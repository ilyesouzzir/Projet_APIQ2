package DesginPatterns.composite;

import java.math.BigDecimal;

public abstract class Element {
    private int id;
    private String nom;

    public Element() {

    }

    public Element(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public abstract BigDecimal totPrizeMoney();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return id == element.id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        return hash;
    }
}