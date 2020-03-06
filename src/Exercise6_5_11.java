import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Exercise6_5_11 {
    public static void main(String[] args) {
        String[] testString = {
                "world!",
                "Hello",
                "Hello world!",
        };
//        String[] testString = {null};
        Stream<String> testStringStream = Arrays.stream(testString);
        Comparator<String> stringComparator = Comparator.comparing(String::length);
        findMinMax(testStringStream, stringComparator, ((x,y)->System.out.println(x+y)));

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        final T [] minMaxArray = (T []) new Object[2];
        stream.forEach(x ->{
            if (minMaxArray[0] == null||order.compare(minMaxArray[0], x)<0){
                minMaxArray[0] = x;
            }
            if (minMaxArray[1] == null||order.compare(x, minMaxArray[1])<0) {
                minMaxArray[1] =x;
            }
            }
        );
        minMaxConsumer.accept(minMaxArray[0], minMaxArray[1]);



//        List<? extends T> listStream = stream.sorted(order).reduce(order::compare);//collect(Collectors.toList());
//        List<T> listStream = new ArrayList<>();
//        Consumer<T> findConsumer = x -> {
//            if (listStream.isEmpty()) {
//                listStream.add(0, x);
//                listStream.add(1, x);
//            }
//            if (order.compare(listStream.get(0), x) < 0) {
//                listStream.remove(0);
//                listStream.add(0, x);
//            }
//            if (order.compare(listStream.get(1), x) > 0) {
//                listStream.remove(1);
//                listStream.add(1, x);
//            }
//        };
//
//        stream.peek(findConsumer).forEach(System.out::println);

//        List<T> listStream = stream.peek(System.out::println).collect(ArrayList::new,(x,y) -> {
//            if (x.isEmpty()) {
//                x.add(0,y);
//                x.add(1,y);
//            }
//            if (order.compare(x.get(0), y) < 0){
//                x.remove(0);
//                x.add(0,y);
//            }
//            if (order.compare(x.get(1), y) > 0){
//                x.remove(1);
//                x.add(1,y);
//            }
//        } , ArrayList::addAll);
//        System.out.println(listStream.get(0).toString()+" "+ listStream.get(1).toString());
       // if (listStream.isEmpty()) minMaxConsumer.accept(null, null);
       // else minMaxConsumer.accept(listStream.get(0), listStream.get(listStream.size() - 1));
    }

    public static <T> T compareStream (){
        return null;
    }
}
