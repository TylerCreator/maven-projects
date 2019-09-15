import java.math.BigInteger;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class Main {
    static final UnaryOperator<Integer> factorial = x -> x == 0
            ? 1
            : x * Main.factorial.apply(x - 1);

//    public static int Factorial(int n, UnaryOperator function){
//        return (int) function.apply(n);
//    }
//
//    public static BigInteger factorial(int n)
//    {
//        if (n == 0) return BigInteger.ONE;
//        return BigInteger.valueOf(n).multiply(factorial(n-1));
//    }
//
//    public static BigInteger streamed(int n) {
//        if(n < 2) return BigInteger.valueOf(1);
//        return IntStream.rangeClosed(2, n).mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
//    }
//
//    public static Integer multyply(Integer n,  UnaryOperator<Integer> function)
//    {
//        return function.apply(n-1);
//    }

    public static void main(String[] args) {

        System.out.println(factorial.apply(5));
    }
}
