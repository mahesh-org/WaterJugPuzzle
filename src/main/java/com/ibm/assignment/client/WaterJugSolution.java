package com.ibm.assignment.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.ibm.assignment.common.WaterJugInputs;
import com.ibm.assignment.common.WaterJugOutputs;

public class WaterJugSolution {

 private static final Logger LOGGER = Logger.getLogger(WaterJugSolution.class.getName());

 private WaterJugSolution() {

 }

 public static void main(String[] args) {
  LOGGER.debug("WaterJug Puzzle Main program started");
  int reRunTheProgram;
  Scanner scanInputs = null;
  do {
   WaterJugOutputs waterJugOutputs = null;

   WaterJugInputs waterJugInputs = WaterJugHelper.init();

   waterJugOutputs = WaterJugHelper.validateWaterJugInputs(waterJugInputs);

   if (null != waterJugOutputs && waterJugOutputs.isValidationSuccessful()) {
    waterJugOutputs = WaterJugHelper.startWaterJugSolutionProcess(waterJugInputs);
   }
   WaterJugHelper.showResults(waterJugOutputs);

   LOGGER.info("Would like to Continue?(1-Continue; 2-Exit)");
   scanInputs = new Scanner(System.in);
   reRunTheProgram = scanInputs.nextInt();

  } while (reRunTheProgram == 1);
  scanInputs.close();
  LOGGER.info("Thanks!!! Program Exited");
 }
}
