package com.tw.step.rover.roversystem;

import com.tw.step.rover.boundary.Boundary;
import com.tw.step.rover.commands.CommandCreator;
import com.tw.step.rover.commands.RoverCommand;
import com.tw.step.rover.commands.RoverCommands;
import com.tw.step.rover.position.Coordinate;
import com.tw.step.rover.position.Direction;
import com.tw.step.rover.position.Navigator;
import com.tw.step.rover.rover.Rover;

public class RoverSystemParser {
  private final RoverSystemScanner scanner;
  private final Navigator navigator;
  private final Boundary boundary;
  private final CommandCreator commandCreator;

  public RoverSystemParser(RoverSystemScanner scanner, Navigator navigator, Boundary boundary, CommandCreator commandCreator) {
    this.scanner = scanner;
    this.navigator = navigator;
    this.boundary = boundary;
    this.commandCreator = commandCreator;
  }

  private Rover parseRover() {
    Coordinate coordinate = scanner.scanCoordinate();
    Direction heading = scanner.scanDirection();
    return new Rover(coordinate, heading);
  }

  public RoverSystem parse() {
    RoverSystem roverSystem = new RoverSystem();
    while (scanner.peek() != null && !scanner.peek().endsWith(":")) {
      String roverId = scanner.consume();
      Rover rover = parseRover();
      roverSystem.addRover(roverId, rover);
    }

    while (scanner.peek() != null) {
      String roverId = scanner.consume().replace(":", "");
      RoverCommands roverCommands = parseRoverCommands();
      roverSystem.addCommands(roverId, roverCommands);
    }

    return roverSystem;
  }

  private RoverCommands parseRoverCommands() {
    RoverCommands roverCommands = new RoverCommands();
    String instructions = scanner.consume();
    for (int i = 0; i < instructions.length(); i++) {
      RoverCommand roverCommand = commandCreator.create(instructions.charAt(i), navigator, boundary);
      roverCommands.add(roverCommand);
    }

    return roverCommands;
  }
}
