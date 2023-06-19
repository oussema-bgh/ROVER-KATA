package org.example;

import models.Plateau;
import models.Rover;
import models.RoverFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            if (args != null && args.length != 0) {

                String fileName = args[0];

                List<String> list = Files.readAllLines(Paths.get(fileName));
                if (null != list && !list.isEmpty()) {
                    Plateau plateau = new Plateau(Integer.valueOf(list.get(0).split(" ")[0]),
                            Integer.valueOf(list.get(0).split(" ")[1]));
                    RoverFactory roverFactory = new RoverFactory(plateau);


                    for (int i = 1; i < list.size() - 1; i += 2) {
                        String[] donnees = list.get(i).split(" ");

                        Rover rover = roverFactory.createRover(Integer.parseInt(donnees[0]), Integer.valueOf(donnees[1]), donnees[2]);

                        String instraction = list.get(i + 1);
                        rover.executeCommands(instraction);

                        System.out.println(rover.getFinalPosition());
                    }

                }
            }
        } catch (Exception e) {
            System.err.println("program failed with error: " + e.toString());
        }
    }
}