package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Odometry;

@TeleOp(group = "Tests")
public class ResetTest extends OpMode {
    Odometry odo;

    @Override
    public void init() {
        odo = new Odometry(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("Position", odo.getPosition());

        if (gamepad1.b) odo.setPosition(0, 0, 0, DistanceUnit.INCH, AngleUnit.RADIANS);
    }
}
