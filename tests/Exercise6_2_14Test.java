import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class Exercise6_2_14Test {

    @Test
    void main() throws IOException {
        String[] testTextForSum = {"1 2 3 455 5555 6 7 8 9 1", "1 2 3 4 5 6 7", "0 -1 1 -2 -5 -6 -7"};
        for(String i:testTextForSum) {
            try (InputStream is = new ByteArrayInputStream(i.getBytes())) {
                System.setIn(is);
                Exercise6_2_14.main(null);
            }
        }

    }
}
