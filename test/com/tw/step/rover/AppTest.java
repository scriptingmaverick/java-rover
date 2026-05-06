package com.tw.step.rover;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
  @Test
  void shouldPrintFinalRoverPosition() {
    PrintStream originalOut = System.out;
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));

    try {
      App.main();
    } finally {
      System.setOut(originalOut);
    }

    assertEquals("6 3 E\nstatus: active\n3 4 E\nstatus: active" + System.lineSeparator(), output.toString());
  }
}
