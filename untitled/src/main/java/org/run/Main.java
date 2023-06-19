package org.run;

import models.Plateau;
import models.Rover;
import models.RoverFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        try {
            if (args != null && args.length != 0) {

                String fileName = args[0];

                List<String> list = Files.readAllLines(Paths.get(fileName));
                if (!list.isEmpty()) {
                    Plateau plateau = new Plateau(Integer.parseInt(list.get(0).split(" ")[0]),
                            Integer.parseInt(list.get(0).split(" ")[1]));
                    RoverFactory roverFactory = new RoverFactory(plateau);


                    for (int i = 1; i < list.size() - 1; i += 2) {
                        String[] donnees = list.get(i).split(" ");

                        Rover rover = roverFactory.createRover(Integer.parseInt(donnees[0]), Integer.parseInt(donnees[1]), donnees[2]);

                        String instraction = list.get(i + 1);
                        rover.executeCommands(instraction);

                        out.println(rover.getFinalPosition());
                    }

                }
            }
        } catch (Exception e) {
            err.println("program failed with error: " + e.toString());
        }
    }
}