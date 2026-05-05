package com.tw.step.rover.boundary;

import com.tw.step.rover.position.Coordinate;
import com.tw.step.rover.roversystem.RoverSystemScanner;

public class PlateauCreator {

  public static Plateau extractBoundaries(RoverSystemScanner scanner) {
    Coordinate bottomLeftCoord = new Coordinate(0, 0);
    Coordinate topRightCoord = scanner.scanBoundary();
    return new Plateau(bottomLeftCoord, topRightCoord);
  }
}
