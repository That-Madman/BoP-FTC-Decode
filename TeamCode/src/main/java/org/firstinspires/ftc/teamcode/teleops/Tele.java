package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.resources.SwyftWheels;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;

@TeleOp(name = "DRIVE TEAM, CHOOSE THIS ONE")
public class Tele extends OpMode {

    Drive d;
    SwyftWheels s;
    public boolean b = false;


    @Override
    public void init() {
        d = new Drive(hardwareMap);
        s = new SwyftWheels(hardwareMap);

    }

    @Override
    public void loop() {
        d.mecanumDrive(gamepad1);
        s.update(gamepad2);
        telemetry.addData("Ball", s.ballSense());

    }
}
