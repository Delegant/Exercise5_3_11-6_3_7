import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.rmi.UnexpectedException;

import static org.junit.jupiter.api.Assertions.*;

class Exercise5_3_11Test {
    @Test
    void readAsString() throws IOException {
        for(int j =0; j<3; j++) {
            for (int i = 0; i < 3; i++) {
                Charset[] ch = {StandardCharsets.US_ASCII, StandardCharsets.ISO_8859_1, StandardCharsets.UTF_8};
                byte[][] arrByte = {
                        {48, 49, 50, 48},
                        {80, 49, 80, 80},
                        {80, 49, 80, 80},
                };
                try (InputStream is = new ByteArrayInputStream(arrByte[i])) {
                    System.out.print(Exercise5_3_11.readAsString(is, ch[j]));
                }
            }
        }
    }
}