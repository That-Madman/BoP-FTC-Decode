package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.resources.Limelight;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;

@TeleOp(group = "Tests")
public class TestLimelight extends OpMode {
    Limelight l;
    Drive drive;

    @Override
    public void init() {
        drive = new Drive(hardwareMap);
        l = new Limelight(hardwareMap, drive);
    }

    @Override
    public void loop() {
        telemetry.addData("Read position", l.megaTag().toString());
    }
}
