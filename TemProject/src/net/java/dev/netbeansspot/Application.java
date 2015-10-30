package net.java.dev.netbeansspot;

import com.sun.spot.resources.Resources;
import com.sun.spot.resources.transducers.ITriColorLEDArray;
import com.sun.spot.resources.transducers.LEDColor;
import java.io.IOException;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;


public class Application extends MIDlet {
        
    TemReporter temReporter = new TemReporter();
    AnalgoData analogData = new AnalgoData();
    
    LEDLights ledLights = new LEDLights();
    
    protected void startApp() throws MIDletStateChangeException {
        
        temReporter.start();
        while(true){
            try {
                if(analogData.detectData())
                    ledLights.blink(3, LEDColor.RED);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        // TODO
    }
    
    

    protected void pauseApp() {
        // This is not currently called by the Squawk VM
    }

    /**
     * Called if the MIDlet is terminated by the system.
     * I.e. if startApp throws any exception other than MIDletStateChangeException,
     * if the isolate running the MIDlet is killed with Isolate.exit(), or
     * if VM.stopVM() is called.
     * 
     * It is not called if MIDlet.notifyDestroyed() was called.
     *
     * @param unconditional If true when this method is called, the MIDlet must
     *    cleanup and release all resources. If false the MIDlet may throw
     *    MIDletStateChangeException  to indicate it does not want to be destroyed
     *    at this time.
     */
    protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
        // TODO
    }
}
