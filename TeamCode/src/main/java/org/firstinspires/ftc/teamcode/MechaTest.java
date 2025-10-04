package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class MechaTest extends OpMode {
    DriveBase drive;

    @Override
    public void init() {
        drive = new DriveBase(hardwareMap);
    }

    @Override
    public void loop() {
        drive.driveMecanum(gamepad1);
    }
}



