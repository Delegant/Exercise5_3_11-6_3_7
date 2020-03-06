import java.io.IOException;
import java.io.InputStream;

public class Exercise5_2_7 {
    public static void main(String[] args) {

    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        return checkHashOfStream(inputStream, 0);
    }

    public static int checkHashOfStream(InputStream inputStream, int rotateByte) throws IOException {
        int readByte = inputStream.read();
        if (readByte >= 0) {
            rotateByte = checkHashOfStream(inputStream, Integer.rotateLeft(rotateByte, 1) ^ readByte);
        }
        return rotateByte;
    }
}
