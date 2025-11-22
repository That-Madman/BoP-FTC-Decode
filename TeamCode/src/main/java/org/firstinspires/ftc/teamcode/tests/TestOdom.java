package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
@TeleOp(group = "Tests")
public class TestOdom extends OpMode {
    Drive drive;
    @Override
    public void init() {
        drive = new Drive(hardwareMap);

    }

    @Override
    public void loop() {
        drive.mecanumBasic(gamepad1);
        telemetry.addData("position", drive.odometry.getPosition());
    }
}
