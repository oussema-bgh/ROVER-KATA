package services;

import models.Rover;

public class WestState implements RoverState {
    public void moveForward(Rover rover) {

        rover.decrementX();
    }

    public void turnLeft(Rover rover) {

        rover.setState(new SouthState());
    }

    public void turnRight(Rover rover) {

        rover.setState(new NorthState());
    }
}
