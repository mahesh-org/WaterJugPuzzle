package com.ibm.assignment.business;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.ibm.assignment.common.WaterJugInputs;
import com.ibm.assignment.common.WaterJugOutputs;

public class WaterJugSolutionDirectorTest {

 private WaterJugSolutionDirector waterJugSolutionDirector;

 @Before
 public void init() {
  waterJugSolutionDirector = new WaterJugSolutionDirector();
 }

 @Test
 public void testConstructAndProvideWaterJugProblemSolution() {
  WaterJugInputs waterJugInputs = WaterJugInputs.createWaterJugInstance(3, 5, 4);
  WaterJugOutputs waterJugOutputs = waterJugSolutionDirector.getWaterJugPuzzleSolution(waterJugInputs);
  boolean actualTransactionSuccessfulValue = waterJugOutputs.isTransferSuccessful();
  boolean expectedTransactionSuccessfulValue = true;

  assertEquals(expectedTransactionSuccessfulValue, actualTransactionSuccessfulValue);
  assertNotNull("Success!!! Approach has steps to solve the puzzle", waterJugOutputs);

 }

}
