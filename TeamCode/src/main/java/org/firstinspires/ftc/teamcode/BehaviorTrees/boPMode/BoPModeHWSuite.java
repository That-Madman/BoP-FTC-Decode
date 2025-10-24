package org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode;


import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * A localized place to hold all of our hardware for Behvavior tree programs.
 * It should be updated whenever a new subsystem is added.
 */
public class BoPModeHWSuite {

    public BoPModeHWSuite (HardwareMap hwMap){
        for (LynxModule mod : hwMap.getAll(LynxModule.class))
            mod.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);

        //TODO: Add all the subsystems.
    }
}
