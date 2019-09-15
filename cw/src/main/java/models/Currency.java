package models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Currency implements Serializable {
    private long id;
    private String name;
    private String full;
    private long nominal;
    Set<Dates> dates = new HashSet<Dates>(0);

    public Set<Dates> getDates() {
        return dates;
    }

    public void setDates(Set<Dates> dates) {
        this.dates = dates;
    }

    public long getNominal() {
        return nominal;
    }

    public void setNominal(long nominal) {
        this.nominal = nominal;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }






}
