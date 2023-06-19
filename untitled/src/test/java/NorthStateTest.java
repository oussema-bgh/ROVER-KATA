import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Plateau;
import models.Rover;
import services.NorthState;

public class NorthStateTest {

    private Plateau plateau;
    private Rover rover;

    @BeforeEach
    public void setUp() {
        plateau = new Plateau(5, 5);
        rover = new Rover(1, 2, new NorthState(), plateau);
    }

    @Test
    public void testMoveForward() {
        rover.moveForward();
        assertEquals("1 3 N", rover.getFinalPosition());
    }

    @Test
    public void testTurnLeft() {
        rover.turnLeft();
        assertEquals("1 2 W", rover.getFinalPosition());
    }

    @Test
    public void testTurnRight() {
        rover.turnRight();
        assertEquals("1 2 E", rover.getFinalPosition());
    }


}
