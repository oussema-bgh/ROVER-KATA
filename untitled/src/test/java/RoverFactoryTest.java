import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Plateau;
import models.Rover;
import models.RoverFactory;
import services.*;

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
    void testCreateState() {

        RoverState northState = roverFactory.createState("N");
        Assertions.assertTrue(northState instanceof NorthState);

        RoverState southState = roverFactory.createState("S");
        Assertions.assertTrue(southState instanceof SouthState);

        RoverState eastState = roverFactory.createState("E");
        Assertions.assertTrue(eastState instanceof EastState);

        RoverState westState = roverFactory.createState("W");
        Assertions.assertTrue(westState instanceof WestState);

        Assertions.assertThrows(IllegalArgumentException.class, () -> roverFactory.createState("InvalidDirection"));    }


}
