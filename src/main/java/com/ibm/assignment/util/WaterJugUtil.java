package com.ibm.assignment.util;

import org.apache.log4j.Logger;

import com.ibm.assignment.common.WaterJugInputs;
import com.ibm.assignment.common.WaterJugOutputs;

public class WaterJugUtil {

 private static final Logger LOGGER = Logger.getLogger(WaterJugUtil.class.getName());
 private static WaterJugOutputs waterJugOutputsLocal;

 public boolean checkForZeroCapacity(WaterJugInputs waterJugInputs) {
  if (waterJugInputs.getBigJugCapacity() <= WaterJugConstants.ZERO_CAPACITY
    || waterJugInputs.getSmallJugCapacity() <= WaterJugConstants.ZERO_CAPACITY
    || waterJugInputs.getMeasuringQuantity() <= WaterJugConstants.ZERO_CAPACITY) {
   return true;
  }
  return false;
 }

 public boolean checkMeasuringCapacityInLimit(WaterJugInputs waterJugInputs) {
  if (waterJugInputs.getMeasuringQuantity() <= waterJugInputs.getBigJugCapacity()) {
   return true;
  }
  return false;
 }

 public int findGCD(int biggerJugCapacity, int smallerJugCapacity) {
  if (smallerJugCapacity == 0) {
   return biggerJugCapacity;
  }
  return findGCD(smallerJugCapacity, biggerJugCapacity % smallerJugCapacity);
 }

 public boolean checkJugCapacitySame(WaterJugInputs waterJugInputs) {
  if (waterJugInputs.getBigJugCapacity() == waterJugInputs.getSmallJugCapacity()) {
   return true;
  }
  return false;
 }

 public boolean isMeasuringQuantitySameAsJugCapacity(WaterJugInputs waterJugInputs) {
  if (waterJugInputs.getBigJugCapacity() == waterJugInputs.getMeasuringQuantity()
    || waterJugInputs.getSmallJugCapacity() == waterJugInputs.getMeasuringQuantity()) {
   return true;
  }
  return false;
 }

 public void showResults(WaterJugOutputs waterJugOutputs) {
  LOGGER.debug("Start of showResults method");
  if (waterJugOutputs.isTransferSuccessful()) {
   waterJugOutputsLocal = waterJugOutputs;
   int startWithFillSmallJarApproachCount = waterJugOutputs.getSmallToBigPouringSteps();
   int startWithFillBigJarApproachCount = waterJugOutputs.getBigToSmallPouringSteps();

   LOGGER.info("*****WaterJug Puzzle Solution*****");
   LOGGER.info(
     "The First Approach : Start filling Big Jar first and total steps are : " + startWithFillBigJarApproachCount);
   LOGGER.info(
     "The Second Approach : Start filling Small Jar first and total steps are : " + startWithFillSmallJarApproachCount);

   if (startWithFillBigJarApproachCount < startWithFillSmallJarApproachCount) {
    displayStartBigApproach(startWithFillBigJarApproachCount);
   } else if (startWithFillBigJarApproachCount > startWithFillSmallJarApproachCount) {
    displayStartSmallApproach(startWithFillSmallJarApproachCount);
   } else {
    LOGGER.info("Both Approach are same");
   }

  } else {
   if (waterJugOutputs.isBothJugsAreEqualCapacity()) {
    LOGGER.info(WaterJugConstants.SOLUTION_NOT_POSSIBLE + " as both Jugs have Equal capacity ");
   } else if (waterJugOutputs.isMeasuringCapacityIsGreater()) {
    LOGGER
      .info(WaterJugConstants.SOLUTION_NOT_POSSIBLE + " as measuring quantity is greater than bigger Jug Capacity ");
   } else if (waterJugOutputs.isZeroCapacity()) {
    LOGGER.info(WaterJugConstants.SOLUTION_NOT_POSSIBLE + " as input is invalid ");
   } else if (!waterJugOutputs.isGcdDividesMeasuringCapacity()) {
    LOGGER.info(
      WaterJugConstants.SOLUTION_NOT_POSSIBLE + " as  GCD of two capacities should divide the measuring Quantity ");
   } else {
    LOGGER.info(WaterJugConstants.SOLUTION_NOT_POSSIBLE + " for the input quantities, please re run the program");
   }
  }
  LOGGER.debug("End of showResults method");
 }

 private void displayStartBigApproach(int startWithFillBigJarApproachCount) {
  LOGGER.debug("Start of displayStartBigApproach method");
  if (0 != startWithFillBigJarApproachCount) {
   LOGGER.info("First Approach is the Best Approach, with " + " following steps");
   int count = 0;
   for (String stepValue : waterJugOutputsLocal.getTransferBigToSmallJugStepsList()) {
    count++;
    LOGGER.info("Step " + count + ": " + stepValue);
   }
  } else {
   LOGGER.info("No Approach");
  }
  LOGGER.debug("End of displayStartBigApproach method");
 }

 private void displayStartSmallApproach(int startWithFillSmallJarApproachCount) {
  LOGGER.debug("End of displayStartSmallApproach method");
  if (0 != startWithFillSmallJarApproachCount) {
   LOGGER.info("Second Approach is the Best Approach, with " + " following steps");
   int count = 0;
   for (String stepValue : waterJugOutputsLocal.getTransferSmallToBigJugStepsList()) {
    count++;
    LOGGER.info("Step " + count + ": " + stepValue);
   }
  } else {
   LOGGER.info("No Approach");
  }
  LOGGER.debug("End of displayStartSmallApproach method");
 }

}
