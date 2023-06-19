package services;

import models.Rover;

public class NorthState implements RoverState {
    public void moveForward(Rover rover) {

        rover.incrementY();
    }

    public void turnLeft(Rover rover) {

        rover.setState(new WestState());
    }

    public void turnRight(Rover rover) {

        rover.setState(new EastState());
    }
}
