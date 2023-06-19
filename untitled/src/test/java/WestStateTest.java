import models.Plateau;
import models.Rover;
import models.RoverFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WestStateTest {


    private Rover rover;

    @BeforeEach
    void setUp() {
        Plateau plateau = new Plateau(5, 5);
        RoverFactory roverFactory = new RoverFactory(plateau);
        rover = roverFactory.createRover(1, 1, "W");
    }

    @Test
    void testMoveForward() {
        rover.moveForward();
        assertEquals("0 1 W", rover.getFinalPosition());
    }

    @Test
    void testTurnLeft() {
        rover.turnLeft();
        assertEquals("1 1 S", rover.getFinalPosition());
    }

    @Test
    void testTurnRight() {
        rover.turnRight();
        assertEquals("1 1 N", rover.getFinalPosition());
    }
}
