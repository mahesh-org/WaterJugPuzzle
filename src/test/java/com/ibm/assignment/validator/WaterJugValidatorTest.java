package com.ibm.assignment.validator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.assignment.common.WaterJugInputs;
import com.ibm.assignment.common.WaterJugOutputs;
public class WaterJugValidatorTest {

 private WaterJugInputs waterJugInputs;
 private WaterJugValidator waterJugValidator;
 private WaterJugOutputs waterJugOutputs;

 @Before
 public void init() {
  waterJugInputs = WaterJugInputs.createWaterJugInstance(3, 5, 4);
  waterJugValidator = new WaterJugValidator();
  waterJugOutputs = new WaterJugOutputs();
 }

 @After
 public void tearDown() {
  waterJugInputs = null;
  waterJugValidator = null;
  waterJugOutputs = null;
 }

 @Test
 public void testDoValidate() {

  boolean actualValidationSuccessfull = false;
  waterJugOutputs = waterJugValidator.validateInputs(waterJugInputs);
  actualValidationSuccessfull = waterJugOutputs.isValidationSuccessful();
  boolean expectedValidationSuccessfull = true;

  assertEquals(expectedValidationSuccessfull, actualValidationSuccessfull);

 }

}
