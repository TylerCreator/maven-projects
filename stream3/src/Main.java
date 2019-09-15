import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Main {


    public static boolean isPalindrome(String s) {
        int length = s.length();
        String reverse="";
        for (int i = length - 1; i >= 0; i--)
            reverse = reverse + s.charAt(i);

        if (s.equals(reverse))
            return true;
        else
            return false;
    }

    public static List<String>  readWords(String path){
        //read file into stream, try-with-resources
        Supplier<Stream<String>> stream = () -> {
            try {
                return Files.lines(Paths.get(path));
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        };
        if (stream != null){
            //1
            System.out.println(stream.get().count());
            System.out.println();
            //2
            stream.get().limit(100).forEach(System.out::println);
            System.out.println();
            //3
            stream.get().filter(s->s.length()>=22).forEach(System.out::println);
            System.out.println();
            //4
            stream.get().filter(s->s.length()>=22).limit(1).forEach(System.out::println);
            System.out.println();
            //5
            long startTime1 = System.nanoTime();
            stream.get().filter(s->isPalindrome(s)).forEach(System.out::println);
            long endTime1 = System.nanoTime();
            System.out.println();
            //6
            long startTime2 = System.nanoTime();
            stream.get().parallel().filter(s->isPalindrome(s)).forEach(System.out::println);
            long endTime2 = System.nanoTime();
            System.out.println(endTime1-startTime1);
            System.out.println(endTime2-startTime2);
            System.out.println();
            //7
            Stream<Integer> lengths = stream.get().map(s->s.length());
            System.out.println(lengths.max(Integer::compare).get());
            Stream<Integer> lengths1 = stream.get().map(s->s.length());
            System.out.println(lengths1.min(Integer::compare).get());
            Stream<Integer> lengths2 = stream.get().map(s->s.length());
            System.out.println( lengths2.mapToInt(Integer::intValue).average());

            //8
//            Map<Integer,List<String>> groups = stream.get().collect(groupingBy(str -> str.length(),toList()));
//
//            Iterator<Map.Entry<Integer, List<String>>> i = groups.entrySet().iterator();
//            while(i.hasNext()){
//                Integer key = i.next().getKey();
//                System.out.println(key+": "+groups.get(key));
//            }
//            //System.out.println(Arrays.asList(groups));
//            return stream.get().collect(Collectors.toList());
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> words = readWords("src/words");
        //System.out.println(words.size());
    }
}
