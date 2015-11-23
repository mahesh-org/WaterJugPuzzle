package com.ibm.assignment.common;

import java.util.List;

public class WaterJugOutputs {

 private boolean transferSuccessful;
 private boolean validationSuccessful;
 private boolean zeroCapacity;
 private boolean bothJugsAreEqualCapacity;
 private boolean measuringCapacityIsGreater;
 private boolean gcdDividesMeasuringCapacity;
 private List<String> transferBigToSmallJugStepsList;
 private List<String> transferSmallToBigJugStepsList;
 private int bigToSmallPouringSteps;
 private int smallToBigPouringSteps;

 public boolean isZeroCapacity() {
  return zeroCapacity;
 }

 public void setZeroCapacity(boolean zeroCapacity) {
  this.zeroCapacity = zeroCapacity;
 }

 public boolean isBothJugsAreEqualCapacity() {
  return bothJugsAreEqualCapacity;
 }

 public void setBothJugsAreEqualCapacity(boolean bothJugsAreEqualCapacity) {
  this.bothJugsAreEqualCapacity = bothJugsAreEqualCapacity;
 }

 public boolean isMeasuringCapacityIsGreater() {
  return measuringCapacityIsGreater;
 }

 public void setMeasuringCapacityIsGreater(boolean measuringCapacityIsGreater) {
  this.measuringCapacityIsGreater = measuringCapacityIsGreater;
 }

 public boolean isGcdDividesMeasuringCapacity() {
  return gcdDividesMeasuringCapacity;
 }

 public void setGcdDividesMeasuringCapacity(boolean gcdDividesMeasuringCapacity) {
  this.gcdDividesMeasuringCapacity = gcdDividesMeasuringCapacity;
 }

 public boolean isTransferSuccessful() {
  return transferSuccessful;
 }

 public void setTransferSuccessful(boolean transferSuccessful) {
  this.transferSuccessful = transferSuccessful;
 }

 public boolean isValidationSuccessful() {
  return validationSuccessful;
 }

 public void setValidationSuccessful(boolean validationSuccessful) {
  this.validationSuccessful = validationSuccessful;
 }

 public List<String> getTransferBigToSmallJugStepsList() {
  return transferBigToSmallJugStepsList;
 }

 public void setTransferBigToSmallJugStepsList(List<String> transferBigToSmallJugStepsList) {
  this.transferBigToSmallJugStepsList = transferBigToSmallJugStepsList;
 }

 public List<String> getTransferSmallToBigJugStepsList() {
  return transferSmallToBigJugStepsList;
 }

 public void setTransferSmallToBigJugStepsList(List<String> transferSmallToBigJugStepsList) {
  this.transferSmallToBigJugStepsList = transferSmallToBigJugStepsList;
 }

public int getBigToSmallPouringSteps() {
    return bigToSmallPouringSteps;
}

public void setBigToSmallPouringSteps(int bigToSmallPouringSteps) {
    this.bigToSmallPouringSteps = bigToSmallPouringSteps;
}

public int getSmallToBigPouringSteps() {
    return smallToBigPouringSteps;
}

public void setSmallToBigPouringSteps(int smallToBigPouringSteps) {
    this.smallToBigPouringSteps = smallToBigPouringSteps;
}

}
