package com.demo.johndeere;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainTest {

    @Test
    public void calculateWeightedAverageByName() {
        //Test including -ve wighted measure
        List<MeasureObject> measurements = new ArrayList<>();
        measurements.add( new MeasureObject("speed", 1,2));
        measurements.add( new MeasureObject("speed", 3,4));
        measurements.add(new MeasureObject("fuel", 5,6));
        measurements.add(new MeasureObject("fuel", 7,8));
        measurements.add( new MeasureObject("time", 20,-1));
       Map<String,Double> result = Main.calculateWeightedAverageByName(measurements);
       //Time should be excluded as -ve weight
       Assert.assertNull(result.get("time"));
        Assert.assertNotNull(result.get("speed"));
        Assert.assertNotNull(result.get("fuel"));
        //Assert.assertTrue(Double.valueOf(2.33).compareTo(result.get("speed"))==0);//Not able to figure out comparing with precision
        //Assert.assertTrue(Double.valueOf(6.14).compareTo(result.get("fuel"))==0);
        //Assert.assertTrue(Math.abs(Double.valueOf(2.33)-result.get("speed"))<=0.0);
        //Assert.assertTrue(Math.abs(Double.valueOf(6.14)-result.get("fuel"))<=0.0);
        Assert.assertEquals(Double.valueOf(2.3333333333333335),result.get("speed"));
        Assert.assertEquals(Double.valueOf(6.142857142857143),result.get("fuel"));

        //Test including 0 wighted measure
        measurements = new ArrayList<>();
        measurements.add( new MeasureObject("time", 20,0));
        result = Main.calculateWeightedAverageByName(measurements);
        Assert.assertNotNull(result.get("time"));
        Assert.assertEquals(Double.valueOf(0.0),result.get("time"));

        //Test including null name
        measurements = new ArrayList<>();
        measurements.add( new MeasureObject(null, 20,2));
        result = Main.calculateWeightedAverageByName(measurements);
        Assert.assertNotNull(result.get(null));
        Assert.assertEquals(Double.valueOf(20.0),result.get(null));
    }

}