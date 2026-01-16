package org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode;


import android.graphics.Path;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.resources.Barrel;
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

    public Barrel bar;

    public BoPModeHWSuite (OpMode o){
        for (LynxModule mod : o.hardwareMap.getAll(LynxModule.class))
            mod.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);

        drive = new Drive(o.hardwareMap);
        flyWheel = new FlywheelSystem(o);
        sCage = new SwyftWheels(o.hardwareMap);
        bar = new Barrel(o.hardwareMap);
    }
}
