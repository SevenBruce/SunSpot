/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.java.dev.netbeansspot;

import com.sun.spot.resources.Resources;
import com.sun.spot.resources.transducers.IAnalogInput;
import java.io.IOException;

/**
 *
 * @author iotdev
 */
public class AnalgoData {
    
    
    private IAnalogInput[] analogInput = new IAnalogInput[6];

    public AnalgoData() {
        
        initializeAnalogInput();
    }
    
    private void initializeAnalogInput(){
        for(int i = 0; i < 6; i++){
            analogInput[i] = (IAnalogInput)Resources.lookup(IAnalogInput.class, "A" + i + "");
        }
    }
    
    public boolean detectData() throws IOException{
        for(int i = 0; i < 6; i++){
            if(analogInput[i].getVoltage() != 0)
                return true;
        }
        return false;
    }
    
    
    
}
