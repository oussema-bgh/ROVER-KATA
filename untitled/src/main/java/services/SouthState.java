package services;

import models.Rover;

public class SouthState implements RoverState {
    public void moveForward(Rover rover) {

        rover.decrementY();
    }

    public void turnLeft(Rover rover) {

        rover.setState(new EastState());
    }

    public void turnRight(Rover rover) {

        rover.setState(new WestState());
    }
}
