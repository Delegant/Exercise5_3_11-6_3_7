import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise5_2_7Test {

        private static final byte[][] testSets = new byte[][]{
                {10, 20, 30, 50, 1, 125},
                {111, -45, 0, -2, 58, -1},
                {0, 0, 0, 0, 0, 0},
                {-1, -1, -1, -1, -1, -1},
                {0x33, 0x45, 0x01},
                {},
                {-1}
        };
        private static final int[] testResults = new int[]{71, 931, 0, 5397, 71, 0, 255};


        @Test
        public void checkSumOfStreamSample1() throws IOException {
            for (int i = 0; i < testSets.length; i++) {
                int checkSum = Exercise5_2_7.checkSumOfStream(new ByteArrayInputStream(testSets[i]));
                assertEquals(testResults[i], checkSum);
            }
        }
    }