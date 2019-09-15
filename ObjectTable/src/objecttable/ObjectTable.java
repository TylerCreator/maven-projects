package objecttable;
import java.util.*;
import java.io.*;
import java.util.Formatter;
public class ObjectTable {
    public static void main(String[] args) throws IOException {
        Formatter fmt = new Formatter();
        

        File file= new File("in");
        Scanner inf=new Scanner(file);
        PrintWriter out=new PrintWriter("out");
        
        int N=inf.nextInt();
        Bus[] bus = new Bus[N];       
        for (int k=0;k<=N-1;k++){
            int id = inf.nextInt();   
            int track = inf.nextInt();
            int num = inf.nextInt();
            inf.nextLine();
            String Name2 = inf.nextLine();
            String model = inf.nextLine();
            int year = inf.nextInt();
            int mileage = inf.nextInt();
            bus[k]= new Bus(id,track,num,Name2,model,year,mileage);
            
        }
        Scanner in= new Scanner(System.in);
        System.out.println("маршрут");
        int TrackCheck=in.nextInt();
        System.out.println("год");
        int YearCheck1=in.nextInt();
        System.out.println("срок службы");
        int YearCheck2=in.nextInt();
        System.out.println("пробег");
        int MileageCheck=in.nextInt();
        System.out.println("На нужном маршруте");
        for (int k=0;k<=N-1;k++)
            if (bus[k].getTRACK()==TrackCheck)
                System.out.println(bus[k]);
        System.out.println("Истёк срок эксплуатации");
        System.out.println(fmt);
        for (int k=0;k<=N-1;k++)
            if (bus[k].getYEAR()<YearCheck1-YearCheck2)
                System.out.println(bus[k]);
                  
        System.out.println("Пробег больше заданного");
        for (int k=0;k<=N-1;k++)
            if (bus[k].getMILEAGE()>MileageCheck)
                System.out.println(bus[k]);
    }
    
}
