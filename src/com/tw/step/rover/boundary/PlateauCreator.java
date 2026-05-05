package com.tw.step.rover.boundary;

import com.tw.step.rover.position.Coordinate;
import com.tw.step.rover.roversystem.RoverSystemScanner;

public class PlateauCreator {

  public static Plateau extractBoundaries(RoverSystemScanner scanner) {
    Coordinate topRightCoord = scanner.scanBoundary();
    Coordinate bottomLeftCoord = new Coordinate(0, 0);
    return new Plateau(bottomLeftCoord, topRightCoord);
  }
}
