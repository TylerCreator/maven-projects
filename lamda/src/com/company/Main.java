package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.function.BiPredicate;

public class Main {
    public static String theBestString(String a, String b, StringPredicate function){
       if(function.theBestString(a,b)){
           return a;
       }
       else return b;
    }

    public static <T> T theBestEntry(T a, T b, EntryPredicate<T> function){
        if(function.theBestEntry(a,b)){
            return a;
        }
        else return b;
    }

    public static <T> T compare(T i1, T i2,BiPredicate<T, T> bi) {
        if (bi.test(i1, i2)){
            return i1;
        } else {
            return i2;
        }
    }


    public static void main(String[] args) {
	// write your code here
        String[] arr = {"app","nice","shweps"};
        String string1 = "app";
        String string2 = "nice";

        BigInteger n1 = new BigInteger("100000000000000000");
        BigInteger n2 = new BigInteger("100000000000000007");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(arr));
        Calendar c1 = new GregorianCalendar(2016,20,2);
        Calendar c2 = new GregorianCalendar(2018,20,2);

        System.out.println(theBestString(string1, string2, (s1, s2) -> s1.length() > s2.length()));
        System.out.println(theBestString(string1, string2, (s1, s2) -> true));
        System.out.println(theBestEntry(string1, string2, (String s1, String s2) -> s1.length() > s2.length()));
        System.out.println(theBestEntry(string1, string2, (s1, s2) -> true));
        System.out.println(theBestEntry(n1, n2, (BigInteger s1, BigInteger s2) -> s2.bitLength() >s1.bitLength()));
        System.out.println(theBestEntry(list, list, (LinkedList s1, LinkedList s2) -> s2.size() != s1.size()));
        System.out.println(theBestEntry(c1, c2, (Calendar s1, Calendar s2) -> s2.after(s1)));
        System.out.println(compare(string1, string2, (String s1, String s2) -> s1.length() > s2.length()));


        // BUS TASK
        Formatter fmt = new Formatter();


        File file= new File("in");
        Scanner inf= null;
        try {
            inf = new Scanner(file);
            PrintWriter out = new PrintWriter("out.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        int N=inf.nextInt();

        LinkedList<Bus> bus = new LinkedList<>();
        for (int k=0;k<=N-1;k++){
            int id = inf.nextInt();
            int track = inf.nextInt();
            int num = inf.nextInt();
            inf.nextLine();
            String Name2 = inf.nextLine();
            String model = inf.nextLine();
            int year = inf.nextInt();
            int mileage = inf.nextInt();
            bus.add(new Bus(id,track,num,Name2,model,year,mileage));

        }
//        Scanner in= new Scanner(System.in);
//        System.out.println("маршрут");
//        int TrackCheck=in.nextInt();
//        System.out.println("год");
//        int YearCheck1=in.nextInt();
//        System.out.println("срок службы");
//        int YearCheck2=in.nextInt();
//        System.out.println("пробег");
//        int MileageCheck=in.nextInt();


        for (int k=0;k<=N-1;k++)
            System.out.println(bus.get(k));
            Collections.sort(bus,(Bus a, Bus b)-> {
            if (a.getYEAR()-b.getYEAR()==0)
                return a.getMILEAGE()-b.getMILEAGE();
            else
                return a.getYEAR()-b.getYEAR();
        });
        System.out.println("\n"+"\n");
        for (int k=0;k<=N-1;k++)
            System.out.println(bus.get(k));

    }
}
