import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise5_3_11 {
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        /*variant 1*/
        BufferedInputStream readBuf = new BufferedInputStream (inputStream);
        byte[] bytes = new byte[10];
        StringBuffer strBuf = new StringBuffer();
        while ((readBuf.read(bytes)) != -1){
            strBuf.append(new String(bytes, charset));
        }
        return strBuf.toString();
        /*variant 2 */
//          return (new BufferedReader (new InputStreamReader(inputStream, charset.name()))).readLine();
        /*variant 3 */
//            Scanner s = new Scanner(inputStream, charset.name()).useDelimiter("\\A");
//            return (s.hasNext() ? s.next() : "");
        /*variant 4*/
//        BufferedReader readBuf = new BufferedReader (new InputStreamReader(inputStream, charset));
//        int line;
//        StringBuffer strBuf = new StringBuffer();
//        while ((line = readBuf.read()) != -1){
//            strBuf.append((char)line);
//        }
//        return strBuf.toString();

    }

}
