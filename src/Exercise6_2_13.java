import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exercise6_2_13 {
    public static void main(String[] args) {
        Integer[] intArr1 = {1,2,3};
        Integer[] intArr2 = {2,3,4};
        Set<Integer> set1 = new HashSet<>(Arrays.asList(intArr1));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(intArr2));
        Set<Integer> newSet = symmetricDifference(set1,set2);
        System.out.println(newSet);
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> answer = new HashSet<>(set1);
        Set<T> help = new HashSet<>(set2);
        answer.removeIf(help::remove);
        answer.addAll(help);
        return answer;
    }
}