package services;

import models.Rover;

public class EastState implements RoverState {
    public void moveForward(Rover rover) {

        rover.incrementX();
    }

    public void turnLeft(Rover rover) {

        rover.setState(new NorthState());
    }

    public void turnRight(Rover rover) {

        rover.setState(new SouthState());
    }

}
