package com.demo.johndeere;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<MeasureObject> measurements = new ArrayList<>();
        measurements.add( new MeasureObject("speed", 1,2));
        measurements.add( new MeasureObject("speed", 3,4));
        measurements.add(new MeasureObject("fuel", 5,6));
        measurements.add(new MeasureObject("fuel", 7,8));

        Map<String,Double> result = calculateWeightedAverageByName(measurements);
        System.out.println("Weighted avg:: "+result);

    }

    public static Map<String,Double> calculateWeightedAverageByName(List<MeasureObject> ob1){
        //Get lists by measure names
        String name;
        Map<String,List<MeasureObject>> measuresByName = new HashMap<>();
        for(int i=0; i<ob1.size() ; i++){
            if(ob1.get(i).getWeightMeasure()<0){
                System.out.println("Excluding negative weighted measure "+ ob1.get(i).getName());
                continue;
            }
            name = ob1.get(i).getName();
            if(null==measuresByName.get(name)){
                measuresByName.put(name,new ArrayList<>());
            }
            measuresByName.get(name).add(ob1.get(i));
        }
        Map<String,Double> weightedAvgByName = new HashMap<>();
        for(Map.Entry<String,List<MeasureObject>> entry:measuresByName.entrySet()){
            weightedAvgByName.put(entry.getKey(),calculateWeightedAverage(entry.getValue()));
        }

        return weightedAvgByName;
    }
    public static double calculateWeightedAverage(List<MeasureObject> ob1){
        double sumOfWeightedValues = 0;
        double sumOfWeights = 0;
        double weightedValue;
        double value;
        double weight;
        String name;
         for(int i=0; i<ob1.size() ; i++){
            value = ob1.get(i).getValueMeasure();
            weight = ob1.get(i).getWeightMeasure();
            name = ob1.get(i).getName();
            if(weight<0){
                System.out.println("Excluding negative weight "+weight + "for measure "+ name);
                continue;
            }
            weightedValue = value* weight;
            sumOfWeightedValues = sumOfWeightedValues+ weightedValue;
            sumOfWeights += weight;
        }
         //to avoid divide by zero
        if(sumOfWeights==0){
            return 0;
        }else{
            return (sumOfWeightedValues/sumOfWeights);
        }
    }
}
