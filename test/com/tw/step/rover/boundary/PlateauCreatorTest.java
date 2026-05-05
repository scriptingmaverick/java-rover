package com.tw.step.rover.boundary;

import com.tw.step.rover.position.Coordinate;
import com.tw.step.rover.roversystem.RoverSystemScanner;
import org.junit.jupiter.api.Test;

class PlateauCreatorTest {
  String text = """
          5 5
          1 5 N
          LFFRFLFFFR
          """;

  @Test
  void shouldCreateABoundariedPlateau() {
    RoverSystemScanner scanner = RoverSystemScanner.from(text);
    Plateau plateau = PlateauCreator.extractBoundaries(scanner);

    assert (plateau.isWithin(new Coordinate(1, 2)));
    assert (plateau.isWithin(new Coordinate(5, 2)));
    assert (plateau.isWithin(new Coordinate(1, 5)));
    assert (!plateau.isWithin(new Coordinate(1, 6)));
  }
}