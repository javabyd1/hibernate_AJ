package com.sda.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity  //encja
@Table(name = "customers", schema = "ksiegarnia") //może być ale nie musi
public class CustomersEntity {
    @Column
    private String imie;
    @Column
    private String nazwisko;
    @Column
    private Date urodzin;

    @Id
    //@GeneratedValue //autoinkrementacja
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public CustomersEntity() {
    }

    public CustomersEntity(String imie, String nazwisko, Date urodzin, int id) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.urodzin = urodzin;
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Date getUrodzin() {
        return urodzin;
    }

    public void setUrodzin(Date urodzin) {
        this.urodzin = urodzin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
