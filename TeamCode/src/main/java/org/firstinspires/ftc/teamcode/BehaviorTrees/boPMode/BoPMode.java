package org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * A parent OpMode for all of our behavior tree using OpModes. Provides
 * anything you should need to run.
 */
abstract public class BoPMode extends OpMode {
    BoPModeHWSuite hwSuite;

    @Override
    public void init() {
        hwSuite = new BoPModeHWSuite(hardwareMap);
        locInit();
    }

    public abstract void locInit();
}
