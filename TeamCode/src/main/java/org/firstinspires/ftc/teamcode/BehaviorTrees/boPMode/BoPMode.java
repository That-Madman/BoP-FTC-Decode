package org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.Timer;

/**
 * A parent OpMode for all of our behavior tree using OpModes. Provides
 * anything you should need to run.
 */
abstract public class BoPMode extends OpMode {
    BoPModeHWSuite hwSuite;
    ElapsedTime timer;

    @Override
    public void init() {
        hwSuite = new BoPModeHWSuite(hardwareMap);
        timer = new ElapsedTime();

        locInit();
    }

    public abstract void locInit();
}
