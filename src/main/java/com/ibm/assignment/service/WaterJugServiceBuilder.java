package com.ibm.assignment.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.ibm.assignment.base.WaterJugBaseSolutionBuilder;
import com.ibm.assignment.common.WaterJugInputs;
import com.ibm.assignment.util.WaterJugConstants;
import com.ibm.assignment.util.WaterJugUtil;

public class WaterJugServiceBuilder implements WaterJugBaseSolutionBuilder {
 private static final Logger LOGGER = Logger.getLogger(WaterJugServiceBuilder.class.getName());

 WaterJugUtil waterJugUtil = new WaterJugUtil();
 private int smallJugCurrentCapacity;
 private int bigJugCurrentCapacity;
 private int bufferJugForTransfer;
 private int biggerJugCapacity;
 private int smallerJugCapacity;
 private int measuringCapacity;
 private List<String> bigToSmallJarPouringSteps;
 private List<String> smallToBigJarPouringSteps;

 @Override
 public List<String> bigToSmallJugSolutionApproach(WaterJugInputs waterJugInputs) {
  LOGGER.debug("Start of bigToSmallJugSolutionApproach method");
  initializeTheJarCapacities(waterJugInputs);
  bigToSmallJarPouringSteps = new ArrayList<String>();
  if (waterJugInputs.getBigJugCapacity() == waterJugInputs.getMeasuringQuantity()) {
   bigToSmallJarPouringSteps.add("(" + smallJugCurrentCapacity + "," + biggerJugCapacity + ")");
  } else {
   while (bufferJugForTransfer != measuringCapacity) {
    startTheBigToSmallJugSolutionApproach();
    checkAndassignBufferJugWithMeasuringCapacity();
   }
  }
  LOGGER.debug("End of bigToSmallJugSolutionApproach method");
  return Collections.unmodifiableList(bigToSmallJarPouringSteps);
 }

 @Override
 public List<String> smallToBigJugSolutionApproach(WaterJugInputs waterJugInputs) {
  LOGGER.debug("Start of smallToBigJugSolutionApproach method");
  initializeTheJarCapacities(waterJugInputs);
  smallToBigJarPouringSteps = new ArrayList<String>();
  if (waterJugInputs.getSmallJugCapacity() == waterJugInputs.getMeasuringQuantity()) {
   smallToBigJarPouringSteps.add("(" + smallerJugCapacity + "," + bigJugCurrentCapacity + ")");
  } else {
   while (bufferJugForTransfer != measuringCapacity) {
    startTheSmallToBigJugSolutionApproach();
    checkAndassignBufferJugWithMeasuringCapacity();
   }
   LOGGER.debug("End of smallToBigJugSolutionApproach method");

  }
  return Collections.unmodifiableList(smallToBigJarPouringSteps);
 }

 private void startTheBigToSmallJugSolutionApproach() {
  if (bigJugCurrentCapacity == WaterJugConstants.ZERO_CAPACITY) {
   fillBigJug(biggerJugCapacity);
  } else if ((bigJugCurrentCapacity > WaterJugConstants.ZERO_CAPACITY)
    && (smallJugCurrentCapacity != smallerJugCapacity)) {
   transferBiggerJugToSmallerJug(smallerJugCapacity);
  } else if ((bigJugCurrentCapacity > WaterJugConstants.ZERO_CAPACITY)
    && (smallJugCurrentCapacity == smallerJugCapacity)) {
   emptySmallJug();
  }

 }

 private void startTheSmallToBigJugSolutionApproach() {
  if (smallJugCurrentCapacity == WaterJugConstants.ZERO_CAPACITY) {
   fillSmallJug(smallerJugCapacity);
  } else if ((smallJugCurrentCapacity > WaterJugConstants.ZERO_CAPACITY)
    && (bigJugCurrentCapacity != biggerJugCapacity)) {
   transferSmallJugToBigJug(biggerJugCapacity);
  } else if ((smallJugCurrentCapacity > WaterJugConstants.ZERO_CAPACITY)
    && (bigJugCurrentCapacity == biggerJugCapacity)) {
   emptyBigJug();
  }

 }

 private void checkAndassignBufferJugWithMeasuringCapacity() {
  if ((smallJugCurrentCapacity == measuringCapacity) || (bigJugCurrentCapacity == measuringCapacity)) {
   bufferJugForTransfer = measuringCapacity;
  }

 }

 private void fillBigJug(int biggerJugCapacity) {
  bigJugCurrentCapacity = biggerJugCapacity;
  bigToSmallJarPouringSteps.add("(" + smallJugCurrentCapacity + "," + bigJugCurrentCapacity + ")");
 }

 private void emptySmallJug() {
  smallJugCurrentCapacity = WaterJugConstants.ZERO_CAPACITY;
  bigToSmallJarPouringSteps.add("(" + smallJugCurrentCapacity + "," + bigJugCurrentCapacity + ")");
 }

 private void transferBiggerJugToSmallerJug(int smallerJugCapacity) {
  int locbufferJugForTransfer = WaterJugConstants.ZERO_CAPACITY;
  while (locbufferJugForTransfer != WaterJugConstants.ONE_UNIT_CAPACITY) {
   smallJugCurrentCapacity += WaterJugConstants.ONE_UNIT_CAPACITY;
   bigJugCurrentCapacity -= WaterJugConstants.ONE_UNIT_CAPACITY;
   if ((smallJugCurrentCapacity == smallerJugCapacity) || (bigJugCurrentCapacity == WaterJugConstants.ZERO_CAPACITY)) {
    locbufferJugForTransfer = WaterJugConstants.ONE_UNIT_CAPACITY;
   }
  }
  bigToSmallJarPouringSteps.add("(" + smallJugCurrentCapacity + "," + bigJugCurrentCapacity + ")");
 }

 private void fillSmallJug(int smallerJugCapacity) {
  smallJugCurrentCapacity = smallerJugCapacity;
  smallToBigJarPouringSteps.add("(" + smallJugCurrentCapacity + "," + bigJugCurrentCapacity + ")");
 }

 private void transferSmallJugToBigJug(int biggerJugCapacity) {
  int locbufferJugForTransfer = WaterJugConstants.ZERO_CAPACITY;
  while (locbufferJugForTransfer != WaterJugConstants.ONE_UNIT_CAPACITY) {
   bigJugCurrentCapacity += WaterJugConstants.ONE_UNIT_CAPACITY;
   smallJugCurrentCapacity -= WaterJugConstants.ONE_UNIT_CAPACITY;
   if ((bigJugCurrentCapacity == biggerJugCapacity) || (smallJugCurrentCapacity == WaterJugConstants.ZERO_CAPACITY)) {
    locbufferJugForTransfer = WaterJugConstants.ONE_UNIT_CAPACITY;
   }
  }
  smallToBigJarPouringSteps.add("(" + smallJugCurrentCapacity + "," + bigJugCurrentCapacity + ")");
 }

 private void emptyBigJug() {
  bigJugCurrentCapacity = WaterJugConstants.ZERO_CAPACITY;
  smallToBigJarPouringSteps.add("(" + smallJugCurrentCapacity + "," + bigJugCurrentCapacity + ")");
 }

 private void initializeTheJarCapacities(WaterJugInputs waterJugInputs) {
  biggerJugCapacity = waterJugInputs.getBigJugCapacity();
  smallerJugCapacity = waterJugInputs.getSmallJugCapacity();
  measuringCapacity = waterJugInputs.getMeasuringQuantity();
  bufferJugForTransfer = WaterJugConstants.ZERO_CAPACITY;
  smallJugCurrentCapacity = WaterJugConstants.ZERO_CAPACITY;
  bigJugCurrentCapacity = WaterJugConstants.ZERO_CAPACITY;
 }

}
