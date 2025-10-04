package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp
public class TeleV1 extends OpMode{
        DriveBase drive;
        FlywheelSystem shoot;
        DrumMotor drum;
        SquirrelCage sCage;
        LoadOrder load;
        @Override
        public void init() {
            drive = new DriveBase(hardwareMap);
            shoot = new FlywheelSystem(hardwareMap);
            drum = new DrumMotor(hardwareMap);
            sCage = new SquirrelCage(hardwareMap);
            load = new LoadOrder(hardwareMap);
        }
        @Override
        public void loop() {
            drive.driveMecanum(gamepad1);
            shoot.flyShoot(gamepad1, telemetry);
            drum.drumSpin(gamepad1);
            sCage.cageSpin(gamepad2, telemetry);
            load.ordering();
        }
    }