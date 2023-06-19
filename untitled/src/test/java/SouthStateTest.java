import models.Plateau;
import models.Rover;
import models.RoverFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SouthStateTest {

    private Rover rover;

    @BeforeEach
    void setUp() {
        Plateau plateau = new Plateau(5, 5);
        RoverFactory roverFactory = new RoverFactory(plateau);
        rover = roverFactory.createRover(1, 1, "S");
    }

    @Test
    void testMoveForward() {
        rover.moveForward();
        assertEquals("1 0 S", rover.getFinalPosition());
    }

    @Test
    void testTurnLeft() {
        rover.turnLeft();
        assertEquals("1 1 E", rover.getFinalPosition());
    }

    @Test
    void testTurnRight() {
        rover.turnRight();
        assertEquals("1 1 W", rover.getFinalPosition());
    }
}
