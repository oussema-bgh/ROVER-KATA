package models;


import services.*;

public class RoverFactory {

    private final Plateau plateau;

    public RoverFactory(Plateau plateau) {
        this.plateau = plateau;
    }

    public Rover createRover(int x, int y, String direction) {
        RoverState state = createState(direction);
        return new Rover(x, y, state, plateau);
    }

    private RoverState createState(String direction) {
        switch (direction) {
            case "N":
                return new NorthState();
            case "S":
                return new SouthState();
            case "E":
                return new EastState();
            case "W":
                return new WestState();
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }
}
