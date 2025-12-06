package org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode;


import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.resources.DrumServo;
import org.firstinspires.ftc.teamcode.resources.FlywheelSystem;
import org.firstinspires.ftc.teamcode.resources.SquirrelCage;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;

/**
 * A localized place to hold all of our hardware for Behvavior tree programs.
 * It should be updated whenever a new subsystem is added.
 */
public class BoPModeHWSuite { //TODO: KEEP UPDATED
    Drive drive;
    DrumServo drum;
    FlywheelSystem flyWheel;
    SquirrelCage sCage;
    //TODO: figure out which Limelight to use

    public BoPModeHWSuite (HardwareMap hwMap){
        for (LynxModule mod : hwMap.getAll(LynxModule.class))
            mod.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);

        drive = new Drive(hwMap);
        drum = new DrumServo(hwMap);
        flyWheel = new FlywheelSystem(hwMap);
        sCage = new SquirrelCage(hwMap);
    }
}
