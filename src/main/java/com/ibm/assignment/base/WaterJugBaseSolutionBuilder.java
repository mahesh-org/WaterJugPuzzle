package com.ibm.assignment.base;

import java.util.List;
import com.ibm.assignment.common.WaterJugInputs;

public interface WaterJugBaseSolutionBuilder {
 List<String> bigToSmallJugSolutionApproach(WaterJugInputs waterJugInputs);

 List<String> smallToBigJugSolutionApproach(WaterJugInputs waterJugInputs);
}
