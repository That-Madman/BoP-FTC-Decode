package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.resources.DrumServo;
import org.firstinspires.ftc.teamcode.resources.FlywheelSystem;
import org.firstinspires.ftc.teamcode.resources.SquirrelCage;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;

@TeleOp
public class TeleV1 extends OpMode{
        Drive drive;
        DrumServo drum;
        SquirrelCage sCage;
        FlywheelSystem shoot;
        @Override
        public void init() {
            drive = new Drive(hardwareMap);
            drum = new DrumServo(hardwareMap);
            sCage = new SquirrelCage(hardwareMap);
            shoot = new FlywheelSystem(hardwareMap);
        }
        @Override
        public void loop() {
            drive.trueNorthDrive(gamepad1);
            drum.drumSpin(gamepad2);
            sCage.cageSpin(gamepad2, telemetry);
            shoot.flyShoot(gamepad1, telemetry);
        }
    }