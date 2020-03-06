import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

class Exercise6_5_12Test {

    @Test
    void main() throws IOException {
        String[] testTextForSum = {
                "Hello Hello Hello Hello world World!",
                "Mama mila mila mila, ram 33 raza",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim."
        };
        for(String i:testTextForSum) {
            try (InputStream is = new ByteArrayInputStream(i.getBytes())) {
                System.setIn(is);
                Exercise6_5_12.main(null);
                System.out.println(" ");
            }
        }

    }
}
