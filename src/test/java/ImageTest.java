import static org.junit.Assert.assertNotNull;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Test;

public class ImageTest {

    @Test
    public void test() {
        try {
            BufferedImage image = ImageIO.read(new File("/images/bulletD.gif"));
            assertNotNull(image);

            BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            assertNotNull(image2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
