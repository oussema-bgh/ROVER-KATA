import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Plateau;
import models.Rover;
import services.NorthState;

class NorthStateTest {

    private Rover rover;

    @BeforeEach
     void setUp() {
        Plateau plateau = new Plateau(5, 5);
        rover = new Rover(1, 2, new NorthState(), plateau);
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
