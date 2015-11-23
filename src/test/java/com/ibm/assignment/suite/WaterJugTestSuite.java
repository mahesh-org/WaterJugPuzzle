package com.ibm.assignment.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ibm.assignment.business.WaterJugSolutionDirectorTest;
import com.ibm.assignment.service.WaterJugServiceBuilderTest;
import com.ibm.assignment.util.WaterJugUtilTest;
import com.ibm.assignment.validator.WaterJugValidatorTest;

@RunWith(Suite.class)
@SuiteClasses({ WaterJugUtilTest.class, WaterJugValidatorTest.class, WaterJugServiceBuilderTest.class,
  WaterJugSolutionDirectorTest.class })
public class WaterJugTestSuite {

 private WaterJugTestSuite() {

 }

}
