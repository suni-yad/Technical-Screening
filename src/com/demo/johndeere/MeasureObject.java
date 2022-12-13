package com.demo.johndeere;

public class MeasureObject {
    private String name;
    private double valueMeasure;
    private double weightMeasure;

   public MeasureObject(){}

   public MeasureObject(String name, double valueMeasure, double weightMeasure){
       this.name = name;
       this.valueMeasure = valueMeasure;
       this.weightMeasure = weightMeasure;
   }

    public void setValueMeasure(double valueMeasure) {
        this.valueMeasure = valueMeasure;
    }

    public void setWeightMeasure(double weightMeasure) {
        this.weightMeasure = weightMeasure;
    }

    public double getValueMeasure() {
        return valueMeasure;
    }

    public double getWeightMeasure() {
        return weightMeasure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
