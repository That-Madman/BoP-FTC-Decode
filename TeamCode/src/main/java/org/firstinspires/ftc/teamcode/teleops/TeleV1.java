package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TeleV1 extends OpMode{
        DriveBase drive;
        DrumMotor drum;
        SquirrelCage sCage;
        FlywheelSystem shoot;
        @Override
        public void init() {
            drive = new DriveBase(hardwareMap);
            drum = new DrumMotor(hardwareMap);
            sCage = new SquirrelCage(hardwareMap);
            shoot = new FlywheelSystem(hardwareMap);
        }
        @Override
        public void loop() {
            drive.driveMecanum(gamepad1);
            drum.drumSpin(gamepad2);
            sCage.cageSpin(gamepad2, telemetry);
            shoot.flyShoot(gamepad1, telemetry);
        }
    }