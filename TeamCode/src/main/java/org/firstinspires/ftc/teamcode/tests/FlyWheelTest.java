package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.resources.FlywheelSystem;

@TeleOp(group = "Tests")
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
