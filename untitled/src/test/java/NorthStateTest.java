import static org.junit.jupiter.api.Assertions.assertEquals;

import models.RoverFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Plateau;
import models.Rover;

class NorthStateTest {

    private Rover rover;

    @BeforeEach
    void setUp() {
        Plateau plateau = new Plateau(5, 5);
        RoverFactory roverFactory = new RoverFactory(plateau);
        rover = roverFactory.createRover(1, 2, "N");
    }

    @Test
     void testMoveForward() {
        rover.moveForward();
        assertEquals("1 3 N", rover.getFinalPosition());
    }

    @Test
     void testTurnLeft() {
        rover.turnLeft();
        assertEquals("1 2 W", rover.getFinalPosition());
    }

    @Test
     void testTurnRight() {
        rover.turnRight();
        assertEquals("1 2 E", rover.getFinalPosition());
    }


}
