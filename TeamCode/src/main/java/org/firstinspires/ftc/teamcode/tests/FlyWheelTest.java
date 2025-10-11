package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.resources.FlywheelSystem;

public class FlyWheelTest extends OpMode {
    FlywheelSystem f;

    @Override
    public void init() {
        f = new FlywheelSystem(hardwareMap);
    }

    @Override
    public void loop() {
        f.flyShoot(gamepad1, telemetry);
    }
}
