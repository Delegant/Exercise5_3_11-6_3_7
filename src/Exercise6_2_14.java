import java.util.*;

public class Exercise6_2_14 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useDelimiter("(\\s|\\A)[+-]?\\d+(\\s|\\Z)");
        Deque<Integer> list = new LinkedList<>();
        while(scan.hasNextInt()){
            list.addFirst(scan.nextInt());
        }
        list.forEach((x) -> System.out.print(x + " "));
    }
}
