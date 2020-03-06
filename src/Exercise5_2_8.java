import java.io.*;
import java.util.Arrays;

    public class Exercise5_2_8 {
        public static void main(String[] args) {
            try (InputStream is = System.in; OutputStream os = System.out) {
                int[] buf = {is.read(), 0};
                int[] template = {10, 13};
                while (buf[0] != -1) {
                    buf[1] = buf[0];
                    buf[0] = is.read();

                    if (Arrays.equals(buf, template)) {
                        os.write(buf[0]);
                        buf[0] = is.read();
                    }
                    else os.write(buf[1]);
                    os.flush();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
