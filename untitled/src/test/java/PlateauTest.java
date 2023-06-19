import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Plateau;

class PlateauTest {

    private Plateau plateau;

    @BeforeEach
    void setup() {
        plateau = new Plateau(5, 5);
    }

    @Test
    void testGetMaxX() {
        int maxX = plateau.getMaxX();

        Assertions.assertEquals(5, maxX);
    }

    @Test
    void testGetMaxY() {
        int maxY = plateau.getMaxY();

        Assertions.assertEquals(5, maxY);
    }
}
