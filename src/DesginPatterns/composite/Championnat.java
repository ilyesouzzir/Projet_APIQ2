package DesginPatterns.composite;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Championnat extends Element{
    private String nom;
    private BigDecimal priceMoney;
    private Set<Element> elt= new HashSet<Element>();

    public Championnat(int id, String nom, BigDecimal priceMoney) {
        super(id, nom);
        this.priceMoney = priceMoney;
    }

    public void addElement(Element element) {
        elt.add(element);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigDecimal getPriceMoney() {
        return priceMoney;
    }


    public void setPriceMoney(BigDecimal priceMoney) {
        this.priceMoney = priceMoney;
    }

    public BigDecimal totPrizeMoney() {
        BigDecimal totalPrizeMoney = priceMoney;
        for (Element element : elt) {
            totalPrizeMoney = totalPrizeMoney.add(element.totPrizeMoney());
        }
        return totalPrizeMoney;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return getId() == element.getId();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.getId();
        return hash;
    }

}