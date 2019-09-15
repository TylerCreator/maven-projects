package com.company;
import java.util.Formatter;
public class Bus {
    private int id;
    private int track;
    private int num;
    private String Name2;
    private String model;
    private int year;
    private int mileage;
    private static Formatter fmt=new Formatter();
    
    public Bus(int i, int t, int n, String f, String m, int y, int xm ){
        this.id=i;
        this.track=t;
        this.num=n;
        this.Name2=f;
        this.model=m;
        this.year=y;
        this.mileage=xm;
    }
    public int getID(){
        return this.id;
    }
    public int getTRACK(){
        return this.track;
    }
    public int getNUM(){
        return this.num;
    }
    public String getNAME2(){
        return this.Name2;
    }
    public String getMODEL(){
        return this.model;
    }
    public int getYEAR(){
        return this.year;
    }
    public int getMILEAGE(){
        return this.mileage;
    }
    public void setID(int value){
        this.id=value;
    }
    public void setTRACK(int value){
        this.track=value;
    }
    public void setNUM(int value){
        this.num=value;
    }
    public void setNAME2(String value){
        this.Name2=value;
    }
    public void setMODEL(String value){
        this.model=value;
    }
    public void setYEAR(int value){
        this.year=value;
    }
    public void setMILEAGE(int value){
        this.mileage=value;
    }
    public String toString(){
        fmt = new Formatter();
        //return (" "+id+" "+track+" "+num+" "+Name2+" "+model+" "+year+" "+mileage+" ");
        fmt.format
        ("+---+----+----+-----------------+---------------------+-----+-------+\n"
       + "|%3d|%3d |%3d |%17s|%21s|%4d |%6d|\n"
       + "+---+----+----+-----------------+---------------------+-----+-------+",
                id,track,num,Name2,model,year,mileage);
        return fmt.toString();
    }
}

