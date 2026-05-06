package com.tw.step.rover.roversystem;

import com.tw.step.rover.commands.RoverCommands;
import com.tw.step.rover.rover.Rover;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RoverSystem {
  private final Map<String, Rover> rovers = new HashMap<>();
  private final Map<String, RoverCommands> commandsMap = new HashMap<>();
  private Rover rover;
  private RoverCommands roverCommands;

  public void addRover(Rover rover) {
    this.rover = rover;
  }

  public void addRover(String roverId, Rover rover) {
    rovers.put(roverId, rover);
  }

  public void addCommands(RoverCommands roverCommands) {
    this.roverCommands = roverCommands;
  }

  public void addCommands(String roverId, RoverCommands roverCommands) {
    commandsMap.put(roverId, roverCommands);
  }

  public void execute(RoverCommands roverCommands, Rover rover) {
    roverCommands.execute(rover);
  }

  public void execute() {
    rovers.forEach((s, rover) -> {
      execute(commandsMap.get(s), rover);
    });
  }

  @Override
  public String toString() {
    return rovers.values().stream().map(Rover::toString).collect(Collectors.joining("\n"));
  }

}
