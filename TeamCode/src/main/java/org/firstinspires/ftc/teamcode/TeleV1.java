package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TeleV1 extends OpMode {
    DriveBase drive;
    FlywheelSystem shoot;
    DrumServo drum;
    SquirrelCage sCage;

    @Override
    public void init() {
        drive = new DriveBase(hardwareMap);
        shoot = new FlywheelSystem(hardwareMap);
        drum = new DrumServo(hardwareMap);
        sCage = new SquirrelCage(hardwareMap);
    }

    @Override
    public void loop() {
        drive.driveMecanum(gamepad1);
        shoot.flyShoot(gamepad1, telemetry);
        drum.drumSpin(gamepad1);
        sCage.squirrelCage(gamepad1, telemetry);
    }
}



