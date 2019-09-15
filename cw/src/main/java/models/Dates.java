package models;

import models.Currency;

import java.io.Serializable;
import java.util.Calendar;

public class Dates implements Serializable {
    private long id;
    private Currency currency;
    private Double value;
    private java.util.Date date;

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Dates() {
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Dates(java.util.Date date) {
        this.value = Double.valueOf(0);
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }





}