package com.ibm.assignment.common;

public final class WaterJugInputs {
 private final int measuringQuantity;
 private final int bigJugCapacity;
 private final int smallJugCapacity;
 
 private WaterJugInputs(){
  this.measuringQuantity = 0;
  this.bigJugCapacity = 0;
  this.smallJugCapacity = 0;
 } 

 private WaterJugInputs(int firstJugCapacity, int secondJugCapacity, int measuringQuantity) {
  this.measuringQuantity = measuringQuantity;

  if (firstJugCapacity > secondJugCapacity) {
   this.bigJugCapacity = firstJugCapacity;
   this.smallJugCapacity = secondJugCapacity;
  } else {
   this.bigJugCapacity = secondJugCapacity;
   this.smallJugCapacity = firstJugCapacity;
  }

 }

 public static WaterJugInputs createWaterJugInstance(int firstJugCapacity, int secondJugCapacity,
   int measuringCapacity) {
  return new WaterJugInputs(firstJugCapacity, secondJugCapacity, measuringCapacity);
 }

 public int getBigJugCapacity() {
  return bigJugCapacity;
 }

 public int getSmallJugCapacity() {
  return smallJugCapacity;
 }

 public int getMeasuringQuantity() {
  return measuringQuantity;
 }

 @Override
 public String toString() {
  return "WaterJugInputs [measuringQuantity=" + measuringQuantity + ", bigJugCapacity=" + bigJugCapacity
    + ", smallJugCapacity=" + smallJugCapacity + "]";
 }

}
