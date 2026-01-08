package org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode;


import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.resources.FlywheelSystem;
import org.firstinspires.ftc.teamcode.resources.SwyftWheels;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;

/**
 * A localized place to hold all of our hardware for Behvavior tree programs.
 * It should be updated whenever a new subsystem is added.
 */
public class BoPModeHWSuite { //TODO: KEEP UPDATED
    public Drive drive;
    public FlywheelSystem flyWheel;
    public SwyftWheels sCage;

    //TODO: RE-ENGAGE WHEN DONE
//    Barrel bar;

    public BoPModeHWSuite (HardwareMap hwMap){
        for (LynxModule mod : hwMap.getAll(LynxModule.class))
            mod.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);

        drive = new Drive(hwMap);
        flyWheel = new FlywheelSystem(hwMap);
        sCage = new SwyftWheels(hwMap);
//        bar = new Barrel(hwMap);
    }
}
