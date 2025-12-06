package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.resources.DrumServo;
import org.firstinspires.ftc.teamcode.resources.Angler;
import org.firstinspires.ftc.teamcode.resources.FlywheelSystem;
import org.firstinspires.ftc.teamcode.resources.SquirrelCage;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;

@TeleOp
public class TeleFor1 extends OpMode{
        Drive drive;
    DrumServo drumServo;
    Angler angler;
    SquirrelCage sCage;
    FlywheelSystem fly;

    boolean tN = true;

    @Override
    public void init() {
        drumServo = new DrumServo(hardwareMap);
        drive = new Drive(hardwareMap);
        sCage = new SquirrelCage(hardwareMap);
        angler = new Angler(hardwareMap);
        fly = new FlywheelSystem(hardwareMap);
    }

    @Override
    public void loop() {
        drumServo.drumSpin(gamepad1);
        sCage.cageSpin(gamepad1, telemetry);
        angler.hood(gamepad1);
        fly.flyShoot(gamepad1, telemetry);

        if (tN) drive.trueNorthDrive(gamepad1);
        else    drive.mecanumDrive(gamepad1);

        if (gamepad1.dpadUpWasPressed()) tN ^= true;
    }
    }