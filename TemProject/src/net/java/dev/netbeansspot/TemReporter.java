/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.java.dev.netbeansspot;

import com.sun.spot.resources.Resources;
import com.sun.spot.resources.transducers.Condition;
import com.sun.spot.resources.transducers.IConditionListener;
import com.sun.spot.resources.transducers.ITemperatureInput;
import com.sun.spot.resources.transducers.SensorEvent;
import com.sun.spot.resources.transducers.TemperatureInputEvent;

/**
 *
 * @author iotdev
 */
public class TemReporter {
    
    private ITemperatureInput temp = (ITemperatureInput)Resources.lookup(ITemperatureInput.class, "location=eDemoboard");
    Condition temReporter = null;
    private IConditionListener temListener = null;
    
    private double temSum =0;
    private int temCount = 0;
    private final int timeTick = 5000;
    
    public TemReporter(){
        
        initializeTemListener();
        temReporter = new Condition(temp, temListener, timeTick);
        
    }
    
    private void initializeTemListener(){
        
        temListener = new IConditionListener(){

            public void conditionMet(SensorEvent se, Condition cndtn) {
                double tem = ((TemperatureInputEvent)se).getCelsius();
                System.out.println("the temperature " + temCount + " is : " + to2double(tem));
                
                temCount++;
                temSum += tem;
                if(temCount >=12){
                    System.out.println("the average temperature is : " + to2double(temSum/12));
                    reset();
                }
            }
        
        };
    }
    
    private double to2double(double doubleData){
        double tem = doubleData * 100;
        tem = Math.floor(tem);
        return tem;
    }
    
    public void start(){
        temReporter.start();
    }
    
    public void stop(){
        temReporter.stop();
    }
    
    
    public void reset(){
        temCount = 0;
        temSum = 0;
    }
    
    
    
}
