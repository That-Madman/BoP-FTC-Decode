package org.firstinspires.ftc.teamcode.trailblazer.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;


@TeleOp(group = "Trailblazer_OpModes")
public class TestOdom extends OpMode {
    Drive drive;

    @Override
    public void init() {
        drive = new Drive(hardwareMap);

        telemetry.addLine("Done calibrating");
        telemetry.update();
    }

    @Override
    public void loop() {
        drive.mecanumBasic(gamepad1);
        telemetry.addData("position", drive.odometry.getPosition());

        telemetry.addData("Loop Time (in milliseconds)", drive.odometry.getLoopTime());
        telemetry.addData("Loop Frequency (In Hertz)", drive.odometry.getFrequency());
    }
}
