package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.resources.Barrel;
import org.firstinspires.ftc.teamcode.resources.FlywheelSystem;
import org.firstinspires.ftc.teamcode.resources.SwyftWheels;
import org.firstinspires.ftc.teamcode.resources.VertAim;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;

@TeleOp(name = "DRIVE TEAM, CHOOSE THIS ONE")
public class Tele extends OpMode {
    Barrel b;
    Drive d;
    FlywheelSystem f;
    SwyftWheels s;
    VertAim v;

    @Override
    public void init() {
        b = new Barrel(hardwareMap);
        d = new Drive(hardwareMap);
        f = new FlywheelSystem(this);
        s = new SwyftWheels(hardwareMap);
        v = new VertAim(hardwareMap);
    }

    @Override
    public void loop() {
        b.update(gamepad2);
        d.mecanumDrive(gamepad1);
        f.update(gamepad1, telemetry);
        s.update(gamepad2);
        v.update(gamepad2, telemetry);
        telemetry.addData("Ball", s.ballSense());

    }
}
