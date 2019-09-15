import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static<R,U> List<R> myMap(Stream<U> s, Function<U,R> fnctn) {
        return s.reduce(
                new ArrayList<R>(),
                (List<R> list, U elem) -> { list.add(fnctn.apply(elem)); return list; },
                (List<R> list1, List<R> list2) -> { list1.addAll(list2); return list1; }
        );
    }
    public static<R> List<R> myFilter(Stream<R> s, Predicate<R> fnctn) {
        return s.reduce(
                new ArrayList<R>(),
                (List<R> list, R elem) -> { if (fnctn.test(elem)) list.add(elem); return list; },
                (List<R> list1, List<R> list2) -> { list1.addAll(list2); return list1; }
        );
    }

    public static List<Integer> getIntList(int n, int max,int min) {
        return Stream.generate(()->(int)(Math.random()*(max - min) + min)).limit(n).collect(Collectors.toList());
    }

    public static List<Integer> getProg(int start, int step, int size) {
        return Stream.iterate(start, elem -> elem+step).limit(size).collect(Collectors.toList());
    }

//    public static <T> List<T> myMap(List<T> ls, Function<T, T> p) {
//        List<T> answer= new ArrayList<>();
//        return ls.stream().reduce( new ArrayList<>(),(b,f) -> p.apply(f));
//    }

    public static void main(String[] args){
        List<String> words = Arrays.asList("app", "nice", "shweps","chuits","dash");
        List<Integer> num = Arrays.asList(5,10,15);
        List<Double> flo = Arrays.asList(5.5, 10.1, 15.0, 11.0);
        // 1
        System.out.println(words.stream().reduce("",(s1,s2)->s1+s2.toUpperCase()));
        // 2
        System.out.println(words.stream().map(s->s.toUpperCase()).reduce("",(s1,s2)->s1+s2));
        // 3
        System.out.println(words.stream().collect(Collectors.joining(",")));
        // 4
        System.out.println(num.stream().reduce(0,(s1,s2)->s1+s2));
        System.out.println(num.stream().parallel().reduce(0,(s1,s2)->s1+s2));
        // 5
        System.out.println(flo.stream().parallel().reduce(1.0,(s1,s2)->{
            System.out.print(s2+ " ");
            return s1*s2;
        }));
        // 6
        System.out.println(getIntList(5,10,-5));
        // 7
        System.out.println(getProg(5,10,3));
        //words.stream().map(s->"  "+s).forEach(System.out::println);
        // 8
        List<String> word = Arrays.asList("word1", "word2", "word3");
        System.out.println(myMap(word.stream(), s->Integer.valueOf(s.substring(s.length()-1))));

        //9
        System.out.println(myFilter(word.stream(), s->s.contains("1")));

    }
}
