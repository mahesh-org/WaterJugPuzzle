package com.ibm.assignment.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.assignment.common.WaterJugInputs;
import com.ibm.assignment.service.WaterJugServiceBuilder;

public class WaterJugServiceBuilderTest {

 private WaterJugInputs waterJugInputs;

 @Before
 public void init() {
  waterJugInputs = WaterJugInputs.createWaterJugInstance(7, 5, 4);
 }

 @After
 public void tearDown() {
  waterJugInputs = null;
 }

 @Test
 public void testPourBigToSmallJugSolutionApproach() {
  WaterJugServiceBuilder waterJugServiceBuilder = new WaterJugServiceBuilder();
  List<String> bigToSmallApproachSteps = waterJugServiceBuilder.bigToSmallJugSolutionApproach(waterJugInputs);
  boolean actualValue = bigToSmallApproachSteps.isEmpty() ? false : true;
  boolean expectedValue = true;
  assertEquals(expectedValue, actualValue);

 }

 @Test
 public void testPourSmallToBigJugSolutionApproach() {
  WaterJugServiceBuilder waterJugServiceBuilder = new WaterJugServiceBuilder();
  List<String> smallToBigApproachSteps = waterJugServiceBuilder.smallToBigJugSolutionApproach(waterJugInputs);
  boolean actualValue = smallToBigApproachSteps.isEmpty() ? false : true;
  boolean expectedValue = true;
  assertEquals(expectedValue, actualValue);
 }

}
