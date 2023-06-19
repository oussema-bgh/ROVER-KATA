import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import models.Plateau;
import models.Rover;
import models.RoverFactory;

 class RoverTest {


     public Rover rover;

     @BeforeEach
    public void setUp() {
        Plateau plateau = new Plateau(5, 5);
         RoverFactory roverFactory = new RoverFactory(plateau);
        rover = roverFactory.createRover(0, 0, "N");
        }

    @Test
    void testValidPosition(){
        Assertions.assertTrue(rover.isValidPosition());
    }

    @Test
    void testNotValidPosition(){
    rover.setX(7);
    rover.setY(7);
    rover.isValidPosition();
    Assertions.assertFalse(rover.isValidPosition());
    }

    @Test
    void testNotValidPositionNegValue(){
        rover.setX(-1);
        rover.setY(-2);
        rover.isValidPosition();
        Assertions.assertFalse(rover.isValidPosition());
    }


    @Test
    void testMoveForward() {
        rover.moveForward();
        Assertions.assertEquals("0 1 N", rover.getFinalPosition());
    }

    @Test
    void testTurnLeft() {
        rover.turnLeft();
        Assertions.assertEquals("0 0 W", rover.getFinalPosition());
    }

    @Test
    void testTurnRight() {
        rover.turnRight();
        Assertions.assertEquals("0 0 E", rover.getFinalPosition());
    }

    @Test
    void testExecuteCommandsWithValidCommands() throws IllegalArgumentException {
        String finalPosition = rover.executeCommands("LMR");

        Assertions.assertEquals("5 0 N", finalPosition);
    }

    @Test
    void testExecuteCommandsWithInvalidCommand() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> rover.executeCommands("LXM"));
    }


    @ParameterizedTest
    @CsvSource({ "R, 0 0 E", "RR, 0 0 S", "RRR, 0 0 W", "RRRR, 0 0 N" })
    void turn_right(String command, String position) throws IllegalArgumentException {
        assertEquals(position, rover.executeCommands(command));
    }


    @ParameterizedTest
    @CsvSource({ "M, 0 1 N", "MMM, 0 3 N", })
    void move_up(String command, String position) throws IllegalArgumentException {
        assertEquals(position,rover.executeCommands(command));
    }

    @ParameterizedTest
    @CsvSource({ "MRRM, 0 0 S", "MMMMMRRMMM, 0 2 S" })
    void move_down(String command, String position) throws IllegalArgumentException {
        assertEquals(position,rover.executeCommands(command));
    }

    @ParameterizedTest
    @CsvSource({ "RM, 1 0 E", "RMMMMM, 5 0 E" })
    void move_right(String command, String position) throws IllegalArgumentException {
        assertEquals(position,rover.executeCommands(command));
    }

    @ParameterizedTest
    @CsvSource({ "RMRRM, 0 0 W", "RMMMMRR, 4 0 W" })
    void move_left(String command, String position) throws IllegalArgumentException {
        assertEquals(position,rover.executeCommands(command));
    }

    @ParameterizedTest
    @CsvSource({ "MMMMMMMMMM, 0 5 N", "MMMMMMMMMMMMMMM, 0 5 N" })
    void wrap_from_top_to_bottom(String command, String position) throws IllegalArgumentException {
        assertEquals(position,rover.executeCommands(command));
    }

    @ParameterizedTest
    @CsvSource({ "RRM, 0 5 S", "RRMMMMM, 0 1 S" })
    void wrap_from_bottom_to_top(String command, String position) throws IllegalArgumentException {
        assertEquals(position,rover.executeCommands(command));
    }

    @ParameterizedTest
    @CsvSource({ "RMMMMMMMMMM, 5 0 E", "RMMMMMMMMMMMMMMM, 5 0 E" })
    void wrap_from_right_to_left(String command, String position) throws IllegalArgumentException {
        assertEquals(position,rover.executeCommands(command));
    }

    @ParameterizedTest
    @CsvSource({ "LM, 5 0 W", "LMMMMM, 1 0 W" })
    void wrap_from_left_to_right(String command, String position) throws IllegalArgumentException {
        assertEquals(position,rover.executeCommands(command));
    }
}
