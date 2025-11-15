package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.resources.Limelight;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.fotmrobotics.trailblazer.Pose2D;

@TeleOp(group = "Tests")
public class TestPositioning extends OpMode {
    Limelight l;
    Drive drive;
    Pose2D p_b, p;

    @Override
    public void init() {
        drive = new Drive(hardwareMap);
        l = new Limelight(hardwareMap, drive);
    }

    @Override
    public void loop() {
        p_b = l.megaTag_base();
        p = l.megaTag();
        telemetry.addData("Odom pos:", drive.odometry.getLastPosition());
        telemetry.addData("Read position (without odom)", (p_b != null) ? p_b.toString() : "Not found");
        telemetry.addData("Read position (with odom)", (p != null) ? p.toString() : "Not found");
    }
}
