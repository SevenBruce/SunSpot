/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.java.dev.netbeansspot;

import com.sun.spot.resources.Resources;
import com.sun.spot.resources.transducers.ITriColorLEDArray;
import com.sun.spot.resources.transducers.LEDColor;
import com.sun.spot.util.Utils;

/**
 *
 * @author iotdev
 */
public class LEDLights {
    
    private ITriColorLEDArray leds = null;

    public LEDLights() {
        leds = (ITriColorLEDArray)Resources.lookup(ITriColorLEDArray.class);
    }
    
    public void blink(int position, LEDColor color)
    {
        leds.getLED(position).setColor(color);
        leds.getLED(position).setOn();
        Utils.sleep(200);
        leds.getLED(position).setOff();
    }
    
    
            
    
}
