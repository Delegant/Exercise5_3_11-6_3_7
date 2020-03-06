import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.*;
import static java.util.Map.*;

public class Exercise6_5_12 {
    public static void main(String[] args) {
        Stream<String> stringStream = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8)).lines();
        Map<String, Integer> dublMap = new HashMap<>();
                stringStream.map(x-> x.split("[\\p{Punct}\\p{Blank}]+"))
                .flatMap(Arrays::stream)
                .forEach(x->dublMap.merge(x.toLowerCase(),1, Integer::sum));
        dublMap.entrySet()
                .stream()
                .sorted(Entry.<String,Integer>comparingByValue().reversed().thenComparing(Entry.comparingByKey()))
                .limit(10)
                .map(Entry::getKey)
                .forEach(System.out::println);
    }
}
