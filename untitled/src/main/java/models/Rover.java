package models;


import services.*;

public class Rover {

    private int x;
    private int y;
    private RoverState state;

    private Plateau plateau;

    public Rover(){}

    public Rover(int x, int y, RoverState state, Plateau plateau) {
        this.x = x;
        this.y = y;
        this.state = state;
        this.plateau= plateau;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setState(RoverState orientation) {
        this.state = orientation;
    }

    public RoverState getState() {
        return this.state  ;
    }

    public boolean isValidPosition() {
        return x >= 0 && x <= plateau.getMaxX() && y >= 0 && y <= plateau.getMaxY();
    }
    public void moveForward() {
        state.moveForward(this);
    }

    public void turnLeft() {
        state.turnLeft(this);
    }

    public void turnRight() {
        state.turnRight(this);
    }

    public void     incrementX() {
        x = ((x + 1) - plateau.getMaxX() > 0) ? ((x + 1) % plateau.getMaxX()) : x + 1;
    }

    public void decrementX() {
        x = (x == 0) ? plateau.getMaxX() : x - 1;
    }

    public void incrementY() {
        y = ((y + 1) - plateau.getMaxY() > 0) ? ((y + 1) % plateau.getMaxY()) : y + 1;
    }

    public void decrementY() {
        y = (y == 0) ? plateau.getMaxY() : y - 1;
    }


    public String getFinalPosition() {
        return x + " " + y + " " + getOrientation();
    }

    public char getOrientation() {
        if (state instanceof NorthState) {
            return 'N';
        } else if (state instanceof SouthState) {
            return 'S';
        } else if (state instanceof EastState) {
            return 'E';
        } else if (state instanceof WestState) {
            return 'W';
        } else {
            throw new IllegalStateException("Invalid rover state.");
        }
    }

    public String executeCommands(String commands) throws IllegalArgumentException {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L':
                    state.turnLeft(this);
                    break;
                case 'R':
                    state.turnRight(this);
                    break;
                case 'M':
                    state.moveForward(this);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return getFinalPosition() ;
    }



}