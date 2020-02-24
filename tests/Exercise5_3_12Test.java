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

class Exercise5_3_12Test {
    @Test
    void readAsString() throws IOException {
        String[] testTextForSum = {"1 2 3", "a1 b2 c3", "-1e3\n 18 ,111 11bbb"};
            for(String i:testTextForSum) {
                try (InputStream is = new ByteArrayInputStream(i.getBytes())) {
                    System.setIn(is);
                    Exercise5_3_12.sumFromString();
                }
            }

    }
}