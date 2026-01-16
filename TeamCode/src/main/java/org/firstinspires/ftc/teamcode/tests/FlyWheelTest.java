package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.resources.FlywheelSystem;

@TeleOp(group = "Tests")
public class FlyWheelTest extends OpMode {
    FlywheelSystem f;

    @Override
    public void init() {
        f = new FlywheelSystem(this);
    }

    @Override
    public void loop() {
        f.update(gamepad1, telemetry);
    }
}
