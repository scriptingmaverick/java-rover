package com.tw.step.rover.commands;

import com.tw.step.rover.boundary.InfinitePlateau;
import com.tw.step.rover.boundary.Plateau;
import com.tw.step.rover.position.Coordinate;
import com.tw.step.rover.position.Direction;
import com.tw.step.rover.position.Navigator;
import com.tw.step.rover.rover.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandExecutionTest {
  @Test
  void shouldExecuteSingleCommands() {
    Navigator navigator = Navigator.create();
    InfinitePlateau boundary = new InfinitePlateau();
    Rover rover = new Rover(new Coordinate(0, 0), Direction.N);

    new TurnLeftCommand(navigator, boundary).execute(rover);
    assertEquals("0 0 W\nstatus: active", rover.toString());

    new TurnRightCommand(navigator, boundary).execute(rover);
    assertEquals("0 0 N\nstatus: active", rover.toString());

    new MoveCommand(navigator, boundary).execute(rover);
    assertEquals("0 1 N\nstatus: active", rover.toString());
  }

  @Test
  void shouldExecuteSingleCommandsWithGivenPlateau() {
    Navigator navigator = Navigator.create();
    Plateau boundary = new Plateau(new Coordinate(0, 0), new Coordinate(1, 2));
    Rover rover = new Rover(new Coordinate(0, 0), Direction.N);

    new TurnLeftCommand(navigator, boundary).execute(rover);
    assertEquals("0 0 W\nstatus: active", rover.toString());

    new TurnRightCommand(navigator, boundary).execute(rover);
    assertEquals("0 0 N\nstatus: active", rover.toString());

    new MoveCommand(navigator, boundary).execute(rover);
    assertEquals("0 1 N\nstatus: active", rover.toString());
  }
}
