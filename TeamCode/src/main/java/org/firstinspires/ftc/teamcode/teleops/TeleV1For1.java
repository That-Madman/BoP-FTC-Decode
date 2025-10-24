package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.resources.DriveBase;
import org.firstinspires.ftc.teamcode.resources.DrumMotor;
import org.firstinspires.ftc.teamcode.resources.FlywheelSystem;
import org.firstinspires.ftc.teamcode.resources.SquirrelCage;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;

@TeleOp
public class TeleV1For1 extends OpMode{
        Drive drive;
        DrumMotor drum;
        SquirrelCage sCage;
        FlywheelSystem shoot;
        @Override
        public void init() {
            drive = new Drive(hardwareMap);
            drum = new DrumMotor(hardwareMap);
            sCage = new SquirrelCage(hardwareMap);
            shoot = new FlywheelSystem(hardwareMap);
        }
        @Override
        public void loop() {
            drive.trueNorthDrive(gamepad1);
            drum.drumSpin(gamepad1);
            sCage.cageSpin(gamepad1, telemetry);
            shoot.flyShoot(gamepad1, telemetry);
        }
    }