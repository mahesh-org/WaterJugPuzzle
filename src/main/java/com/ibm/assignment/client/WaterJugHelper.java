package com.ibm.assignment.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.ibm.assignment.business.WaterJugSolutionDirector;
import com.ibm.assignment.common.WaterJugInputs;
import com.ibm.assignment.common.WaterJugOutputs;
import com.ibm.assignment.util.WaterJugConstants;
import com.ibm.assignment.util.WaterJugUtil;
import com.ibm.assignment.validator.WaterJugValidator;

public class WaterJugHelper {
 private static final Logger LOGGER = Logger.getLogger(WaterJugHelper.class.getName());
// private static Scanner scanInputs;
 private static WaterJugInputs waterJugInputs;
 private static WaterJugOutputs waterJugOutputs;
 private static boolean validInputs = true;
 
 private WaterJugHelper(){
  
 }

 public static WaterJugInputs init() {
  LOGGER.debug("Start of init method");
  int reRunTheProgram = WaterJugConstants.ONE_STEP;
  while (WaterJugConstants.ONE_STEP == reRunTheProgram) {
   if (readInputs()) {
    reRunTheProgram = WaterJugConstants.ZERO_CAPACITY;
    break;
   }
  }
  LOGGER.debug("End of init method");
  return waterJugInputs;
 }

 public static WaterJugOutputs validateWaterJugInputs(WaterJugInputs waterJugInputs) {
  LOGGER.debug("Start of validateWaterJugInputs method");
  WaterJugValidator waterJugInputValidator = new WaterJugValidator();
  waterJugOutputs = waterJugInputValidator.validateInputs(waterJugInputs);
  LOGGER.debug("End of validateWaterJugInputs method");
  return waterJugOutputs;

 }

 public static WaterJugOutputs startWaterJugSolutionProcess(WaterJugInputs waterJugInputs) {
  LOGGER.debug("Start of startWaterJugSolutionProcess method");
  WaterJugSolutionDirector waterJugSolutionDirector = new WaterJugSolutionDirector();
  waterJugOutputs = waterJugSolutionDirector.getWaterJugPuzzleSolution(waterJugInputs);
  LOGGER.debug("End of startWaterJugSolutionProcess method");
  return waterJugOutputs;
 }

 public static void showResults(WaterJugOutputs waterJugOutputs) {
  new WaterJugUtil().showResults(waterJugOutputs);
 }

 private static boolean readInputs() {
  LOGGER.debug("Start of readInputs method");
  Scanner scanInputs = new Scanner(System.in);
  int firstJugCapacity, secondJugCapacity, measuringQuantity;
  if (!validInputs) {
   validInputs = true;
   LOGGER.info("Invalid Input values...,");
   LOGGER.info("Would like to Continue?(1-Continue; 2-Exit)");
   int reRunTheProgram = scanInputs.nextInt();
   if (1 != reRunTheProgram) {
    scanInputs.close();
    return false;
   }
  }

  try {
   LOGGER.info("Please enter the capacity of the first jug:");
   firstJugCapacity = scanInputs.nextInt();

   LOGGER.info("Please enter the capacity of the second jug:");
   secondJugCapacity = scanInputs.nextInt();

   LOGGER.info("Please enter the measuring capacity:");
   measuringQuantity = scanInputs.nextInt();

   waterJugInputs = WaterJugInputs.createWaterJugInstance(firstJugCapacity, secondJugCapacity, measuringQuantity);

  } catch (InputMismatchException inValidInputException) {
   LOGGER.debug(inValidInputException);
   validInputs = false;
   readInputs();
  }
  scanInputs.close();
  LOGGER.debug("End of readInputs method");
  return true;
 }

}
