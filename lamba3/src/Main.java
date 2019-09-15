import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

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

    public static <T> T compare(T i1, T i2, BiPredicate<T, T> bi) {
        if (bi.test(i1, i2)){
            return i1;
        } else {
            return i2;
        }
    }

    public static List allMatches(List<String> ls, Predicate<String> p) {
        List<String> answer= new ArrayList<>();
        for(String s : ls) {
            if (p.test(s)) {
                answer.add(s);
            }
        }
        return answer;
    }

    public static <T> List allMatchesEntity(List<T> ls, Predicate<T> p) {
        List<T> answer= new ArrayList<>();
        for(T s : ls) {
            if (p.test(s)) {
                answer.add(s);
            }
        }
        return answer;

    }

    public static List transformedList(List<String> ls, Function<String, String> p) {
        List<String> answer= new ArrayList<>();
        for(String s : ls) {
            answer.add(p.apply(s));
        }
        return answer;
    }

    public static <T,R> List<R> transformedListEntity(List<T> ls, Function<T, R> p) {
        List<R> answer= new ArrayList<>();
        for(T s : ls) {
            answer.add(p.apply(s));
        }
        return answer;
    }


    public static void main(String[] args) {
        // write your code here
        String[] arr = {"app","nice","shweps"};
        String string1 = "app";
        String string2 = "nice";
        List<String> words = Arrays.asList("app", "nice", "shweps","chuits","dash");

        BigInteger n1 = new BigInteger("100000000000000000");
        BigInteger n2 = new BigInteger("100000000000000007");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(arr));
        Calendar c1 = new GregorianCalendar(2016,20,2);
        Calendar c2 = new GregorianCalendar(2018,20,2);

//        System.out.println(theBestString(string1, string2, (s1, s2) -> s1.length() > s2.length()));
//        System.out.println(theBestString(string1, string2, (s1, s2) -> true));
//        System.out.println(theBestEntry(string1, string2, (String s1, String s2) -> s1.length() > s2.length()));
//        System.out.println(theBestEntry(string1, string2, (s1, s2) -> true));
//        System.out.println(theBestEntry(n1, n2, (BigInteger s1, BigInteger s2) -> s2.bitLength() >s1.bitLength()));
//        System.out.println(theBestEntry(list, list, (LinkedList s1, LinkedList s2) -> s2.size() != s1.size()));
//        System.out.println(theBestEntry(c1, c2, (Calendar s1, Calendar s2) -> s2.after(s1)));
//        System.out.println(compare(string1, string2, (String s1, String s2) -> s1.length() > s2.length()));

        // ПЕРВАЯ ЧАСТЬ
        List<String> list1 = allMatches(words, s -> s.length() <= 4);
        System.out.println(list1);
        // слова, содержащие букву d
        List<String> list2 = allMatches(words, s -> s.contains("d"));
        System.out.println(list2);
        // слова, длина которых является четным числом
        List<String> list3 = allMatches(words, s -> (s.length() % 2) == 0);
        System.out.println(list3);

        // ВТОРАЯ ЧАСТЬ
        list1 = allMatchesEntity(words, s -> s.length() <= 4);
        System.out.println(list1);
        // слова, содержащие букву d
        list2 = allMatchesEntity(words, s -> s.contains("d"));
        System.out.println(list2);
        // слова, длина которых является четным числом
        list3 = allMatchesEntity(words, s -> (s.length() % 2) == 0);
        System.out.println(list3);
        //BigInt
        List<BigInteger> num = Arrays.asList(n1,n2);
        List<BigInteger> list4 = allMatchesEntity(num, s -> s.equals(n1));
        System.out.println(list4);
        //Calendar
        List<Calendar> cal = Arrays.asList(c1,c2);
        List<Calendar> list5 = allMatchesEntity(cal, s -> s.equals(c1));
        System.out.println(list5);
        //int
        List<Integer> n = Arrays.asList(5,6,10,15,20);
        List<Integer> list6 = allMatchesEntity(n, s -> s <= 10);
        System.out.println(list6);

        // ТРЕТЬЯ ЧАСТЬ
        list1 = transformedList(words, s -> s + "!");
        System.out.println(list1);
        list2 = transformedList(words, s -> s.replace("i", "eye"));
        System.out.println(list2);
        list3 = transformedList(words, String::toUpperCase);
        System.out.println(list3);

        // ЧЕТВЕРТАЯ ЧАСТЬ
        list1 = transformedListEntity(words, s -> s + "!");
        System.out.println(list1);
        list2 = transformedListEntity(words, s -> s.replace("i", "eye"));
        System.out.println(list2);
        list3 = transformedListEntity(words, String::toUpperCase);
        System.out.println(list3);
        //BigInt
        list4 = transformedListEntity(num, s -> s.add(n1));
        System.out.println(list4);
        //Calendar

        list5 = transformedListEntity(cal, s -> {
            s.add(Calendar.DATE, 1);
            return s;
        });
        System.out.println(list5);
        //int

        list6 = transformedListEntity(n, s -> s + 10);
        System.out.println(list6);

    }
}
