import java.util.Objects;
import java.util.stream.IntStream;

public class Exercise6_4_10 {
    public static void main(String[] args) {
        int someInt = 13;
        IntStream someStream = pseudoRandomStream(someInt);
        someStream.limit(15).filter(Objects::nonNull).forEach(x->System.out.println("end "+x));

    }
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, x -> ((x*x)/10)%1000);
    }

//    public static int mid (int value){
//        StringBuilder helpStrBuilder = new StringBuilder();
//        StringBuilder originString = new StringBuilder(String.valueOf(value)).reverse();
//        originString.chars().skip(1).limit(3).forEach(helpStrBuilder::appendCodePoint);
//        return Integer.parseInt(helpStrBuilder.length()<=0?"0":helpStrBuilder.reverse().toString());
//    }
}
