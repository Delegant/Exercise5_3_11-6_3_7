import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class Exercise5_2_8Test {
    private static final Logger LOGGER = Logger.getLogger(Exercise5_2_8Test.class.getName());


    @Test
    public void main() {
        //       LOGGER.log(Level.INFO, "Start test");
        byte[][] testArrString = {
                {80, 70, -2, -1, 60},
                {65, 13, 10, 10, 13},
                {10, 23, 32, 13, 14},
        };
        byte[][] testTemplate = {
                {80, 70, -2, -1, 60},
                {65, 10, 10, 13},
                {10, 23, 32, 13, 14},
        };

        for (int i = 0; i<3; i++) {
            InputStream is = new ByteArrayInputStream(testArrString[i]);
            System.setIn(is);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream (os);
            System.setOut(ps);

            Exercise5_2_8.main(new String[] {null});
            byte[] result = os.toByteArray();
            StringBuffer strBuf = new StringBuffer();
            for (byte j:result) {
                strBuf.append(j).append(", ");
            }
            LOGGER.log(Level.INFO, "After main {0}", strBuf.toString());
            assertTrue(Arrays.equals(testTemplate[i],result));
        }
    }
}