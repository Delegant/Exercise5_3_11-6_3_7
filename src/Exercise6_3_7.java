import java.util.Objects;
import java.util.function.*;

public class Exercise6_3_7 {
    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        String str = null;
        System.out.println(safeStringLength.apply(str));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse){
            return a -> (condition.test(a)?ifTrue.apply(a):ifFalse.apply(a));
    }

}