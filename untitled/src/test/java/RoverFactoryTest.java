import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Plateau;
import models.Rover;
import models.RoverFactory;
import services.NorthState;

class RoverFactoryTest {

     private RoverFactory roverFactory;

    @BeforeEach
    public void setup() {
        Plateau plateau = new Plateau(5, 5);
        roverFactory = new RoverFactory(plateau);
    }

    @Test
    void testCreateRoverWithValidDirection() {
        Rover rover = roverFactory.createRover(1, 2, "N");

        Assertions.assertEquals(1, rover.getX());
        Assertions.assertEquals(2, rover.getY());
        Assertions.assertTrue(rover.getState() instanceof NorthState);
    }

    @Test
    void testCreateRoverWithInvalidDirection() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> roverFactory.createRover(1, 2, "X"));
    }
}
