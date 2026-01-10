package org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode;

import com.ftcteams.behaviortrees.DebugTree;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.Timer;

/**
 * A parent OpMode for all of our behavior tree using OpModes. Provides
 * anything you should need to run.
 */
abstract public class BoPMode extends LinearOpMode {
    public BoPModeHWSuite hwSuite;
    public ElapsedTime timer;
    public DebugTree debugTree;

    @Override
    public void runOpMode() {
        hwSuite = new BoPModeHWSuite(hardwareMap);
        timer = new ElapsedTime();
        debugTree = new DebugTree();

        locInit();

        telemetry.addLine("OpMode is ready to start.");
        telemetry.update();

        waitForStart();

        main();

        while (opModeIsActive() && !isStopRequested());
    }

    public abstract void locInit();

    public abstract void main();
}
