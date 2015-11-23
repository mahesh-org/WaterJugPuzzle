package com.ibm.assignment.validator;

import org.apache.log4j.Logger;

import com.ibm.assignment.common.WaterJugInputs;
import com.ibm.assignment.common.WaterJugOutputs;
import com.ibm.assignment.util.WaterJugUtil;

public class WaterJugValidator {

 private static final Logger LOGGER = Logger.getLogger(WaterJugValidator.class.getName());
 private WaterJugUtil waterJugUtil = new WaterJugUtil();
 WaterJugOutputs waterJugOutputs = new WaterJugOutputs();
 int greatestCommonDivisor = 0;
 boolean validMeasuringCapacity = false;

 public WaterJugOutputs validateInputs(WaterJugInputs waterJugInputs) {
  LOGGER.debug("Start of validateInputs method");
  boolean jugCapacityZero = false;
  boolean isBothJugCapacityEqual = false;
  if (null != waterJugInputs) {
   jugCapacityZero = waterJugUtil.checkForZeroCapacity(waterJugInputs);
   if (!jugCapacityZero) {
    isBothJugCapacityEqual = waterJugUtil.checkJugCapacitySame(waterJugInputs);
    if (!isBothJugCapacityEqual) {
     validateMeasuringCapacity(waterJugInputs);
    } else {
     waterJugOutputs.setBothJugsAreEqualCapacity(true);
    }
   } else {
    waterJugOutputs.setZeroCapacity(true);
   }

  }
  LOGGER.debug("End of validateInputs method");
  return waterJugOutputs;
 }

 private void validateMeasuringCapacity(WaterJugInputs waterJugInputs) {
  validMeasuringCapacity = waterJugUtil.checkMeasuringCapacityInLimit(waterJugInputs);
  if (validMeasuringCapacity) {
   greatestCommonDivisor = waterJugUtil.findGCD(waterJugInputs.getBigJugCapacity(),
     waterJugInputs.getSmallJugCapacity());
   if (0 == (waterJugInputs.getMeasuringQuantity() % greatestCommonDivisor)) {
    waterJugOutputs.setGcdDividesMeasuringCapacity(true);
    waterJugOutputs.setValidationSuccessful(true);
   } else {
    waterJugOutputs.setGcdDividesMeasuringCapacity(false);
   }
  } else {
   waterJugOutputs.setMeasuringCapacityIsGreater(true);
  }

 }
}