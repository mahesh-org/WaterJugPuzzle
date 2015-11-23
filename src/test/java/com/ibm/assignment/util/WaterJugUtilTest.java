package com.ibm.assignment.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.ibm.assignment.common.WaterJugInputs;

public class WaterJugUtilTest {

 private WaterJugInputs waterJugInputs;
 private WaterJugUtil waterJugUtil;

 @Before
 public void init() {
  waterJugInputs = WaterJugInputs.createWaterJugInstance(3, 5, 4);
  waterJugUtil = new WaterJugUtil();

 }

 @After
 public void tearDown() {
  waterJugInputs = null;
  waterJugUtil = null;
 }

 @Test
 public void testCheckForZeroCapacity() {

  boolean actualIsNotZero = waterJugUtil.checkForZeroCapacity(waterJugInputs);
  boolean expectedIsNotZero = false;

  assertEquals(expectedIsNotZero, actualIsNotZero);

 }

 @Test
 public void testCheckMeasuringCapacityInLimit() {

  boolean actualMeasuringCapacityInLimit = waterJugUtil.checkMeasuringCapacityInLimit(waterJugInputs);
  boolean expectedMeasuringCapacityInLimit = true;

  assertEquals(expectedMeasuringCapacityInLimit, actualMeasuringCapacityInLimit);
 }

 @Test
 public void testIsMeasuringQuantitySameAsJugCapacity() {
  boolean actualValue = waterJugUtil.isMeasuringQuantitySameAsJugCapacity(waterJugInputs);
  boolean expectedValue = false;

  assertEquals(actualValue, expectedValue);

 }

 @Test
 public void testCheckJugCapacitySame() {
  boolean actualValue = waterJugUtil.checkJugCapacitySame(waterJugInputs);
  boolean expectedValue = false;

  assertEquals(actualValue, expectedValue);
 }

}
