package services;

import models.Rover;

public interface RoverState {
    void moveForward(Rover rover);
    void turnLeft(Rover rover);
    void turnRight(Rover rover);
}
