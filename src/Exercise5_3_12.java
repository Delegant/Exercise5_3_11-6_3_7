
import java.util.Locale;
import java.util.Scanner;

public class Exercise5_3_12 {

    public static void sumFromString (){
        Scanner s = new Scanner(System.in);
        Double doubleArr = 0.0;
        while(s.hasNext()){
            if (s.hasNextDouble()){
                doubleArr += s.nextDouble();
            }
            else {
                s.next();
            }
        }
        System.out.format(Locale.US,"%.6f%n", doubleArr );

//        Scanner s = new Scanner(System.in);
//        Double doubleArr = 0.0;
//        while(s.hasNext()){
//            if (s.hasNextDouble()){
//                doubleArr += s.nextDouble();
//            }
//            else {
//                s.next();
//            }
//        }
//        System.out.println(doubleArr);
    }
}
