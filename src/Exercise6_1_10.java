import java.util.Objects;
import java.util.Optional;

public class Exercise6_1_10 {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(String.valueOf(mustBeTrue && mustAlsoBeTrue));

    }
}
class Pair<T, X>{
    private final T first;
    private final X second;
    private Pair(T first, X second){
    this.first = first;
    this.second = second;
    }
    public T getFirst(){
        return first;
    }
    public X getSecond(){
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<T, X> pair = (Pair<T, X>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }


    public static <T, X> Pair<T, X> of(T first, X second){
        return new Pair(first, second);
    }
}