package com.ibm.assignment.business;

import com.ibm.assignment.common.WaterJugInputs;
import org.apache.log4j.Logger;
import com.ibm.assignment.common.WaterJugOutputs;
import com.ibm.assignment.service.WaterJugServiceBuilder;
import com.ibm.assignment.util.WaterJugConstants;

public class WaterJugSolutionDirector {

 private static final Logger LOGGER = Logger.getLogger(WaterJugSolutionDirector.class.getName());

 private WaterJugServiceBuilder waterJugServiceBuilder;
 private WaterJugOutputs waterJugOutputs = new WaterJugOutputs();

 public WaterJugOutputs getWaterJugPuzzleSolution(WaterJugInputs waterJugInputs) {
  LOGGER.debug("Start of constructAndProvideWaterJugProblemSolution method");
  waterJugServiceBuilder = new WaterJugServiceBuilder();
  waterJugOutputs
    .setTransferBigToSmallJugStepsList(waterJugServiceBuilder.bigToSmallJugSolutionApproach(waterJugInputs));
  waterJugOutputs
    .setTransferSmallToBigJugStepsList(waterJugServiceBuilder.smallToBigJugSolutionApproach(waterJugInputs));
  formApproachMethodsOutput();
  LOGGER.debug("End of constructAndProvideWaterJugProblemSolution method");
  return waterJugOutputs;

 }

 private void formApproachMethodsOutput() {
  if (!waterJugOutputs.getTransferBigToSmallJugStepsList().isEmpty()) {
   waterJugOutputs.setBigToSmallPouringSteps(waterJugOutputs.getTransferBigToSmallJugStepsList().size());
  }
  if (!waterJugOutputs.getTransferSmallToBigJugStepsList().isEmpty()) {
   waterJugOutputs.setSmallToBigPouringSteps(waterJugOutputs.getTransferSmallToBigJugStepsList().size());
  }
  if (WaterJugConstants.ZERO_CAPACITY != waterJugOutputs.getBigToSmallPouringSteps()
    || WaterJugConstants.ZERO_CAPACITY != waterJugOutputs.getSmallToBigPouringSteps()) {
   waterJugOutputs.setTransferSuccessful(true);
  }
 }

}
