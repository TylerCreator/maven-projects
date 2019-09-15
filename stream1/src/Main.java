import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static List transformedList(List<String> ls, Function<String, String> p) {
        List<String> answer= new ArrayList<>();
        ls.stream().forEach(e->answer.add(p.apply(e)));
        return answer;
    }

    public static List transformedL(List<String> ls, Function<String, String> p) {

        List<String> answer = ls.stream().map(e->p.apply(e)).collect(Collectors.toList());
        return answer;
    }

    public static List allMatches(List<String> ls, Predicate<String> p) {
        List<String> answer= new ArrayList<>();
        ls.stream().filter(e->p.test(e)).forEach(e->answer.add(e));
        return answer;
    }

//    public static <T> List mapViaR(List<T> ls, Function<T, T> p) {
//        List<T> answer= new ArrayList<>();
//        ls.stream().reduce(e -> answer.add(p.apply(e)));
//        return answer;
//    }

    public static void main(String[] args) {
        Function<String, String> p = s -> {
            System.out.println(s);
            return s.toUpperCase();
        };
        List<String> words = Arrays.asList("app", "nice", "shweps","chuits","dash");
        // 1
        words.stream().map(s->"  "+s).forEach(System.out::println);
        // 2
        words.stream().forEach(System.out::println);
        // 3
//        List<String> excitingWords = transformedList(words, s -> s + "!");
//        System.out.println(excitingWords);
//        List<String> eyeWords = transformedList(words, s -> s.replace("i", "eye"));
//        System.out.println(eyeWords);
//        List<String> upperCaseWords = transformedList(words, String::toUpperCase);
//        System.out.println(upperCaseWords);
        words.stream().map(s -> s + "!").forEach(e -> System.out.print(e+" "));
        System.out.println();
        words.stream().map(s -> s.replace("i", "eye")).forEach(e -> System.out.print(e+" "));
        System.out.println();
        words.stream().map(String::toUpperCase).forEach(e -> System.out.print(e+" "));
        System.out.println();
        // 4
        List<String> shortWords = allMatches(words, s -> s.length() < 4);
        System.out.println(shortWords);
        List<String> wordsWithB = allMatches(words, s -> s.contains("b"));
        System.out.println(wordsWithB);
        List<String> evenLengthWords = allMatches(words, s -> (s.length() % 2) == 0);
        System.out.println(evenLengthWords);
        // 5
        System.out.println(words.stream().filter(s->s.length()<4).map(s -> s.toUpperCase()).filter(s->s.contains("A")).findFirst().orElse("null"));
        System.out.println(words.stream().filter(s->s.length()<4).map(s -> s.toUpperCase()).filter(s->s.contains("E")).findFirst().orElse("null"));
        System.out.println(words.stream().filter(s->s.length()<4).map(s -> s.toUpperCase()).filter(s->s.contains("Q")).findFirst().orElse("null"));
        // 6
        words.stream().map(p).filter(s->s.length()<4).filter(s->s.contains("A"));
        System.out.println(" ");
        words.stream().map(p).filter(s->s.length()<4).filter(s->s.contains("A")).forEach(System.out::println);
        words.stream().map(p).filter(s->s.length()<4).filter(s->s.contains("E"));
        words.stream().map(p).filter(s->s.length()<4).filter(s->s.contains("E")).forEach(System.out::println);
        words.stream().map(p).filter(s->s.length()<4).filter(s->s.contains("Q"));
        words.stream().map(p).filter(s->s.length()<4).filter(s->s.contains("Q")).forEach(System.out::println);
        //7
        String[] strings = words.stream().map(s->("  "+s+"  ")).toArray(String[]::new);
        System.out.println(Arrays.asList(strings));
        // 8
    }
}
