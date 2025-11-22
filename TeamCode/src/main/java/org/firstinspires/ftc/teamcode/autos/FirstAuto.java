package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Pose2D;
import org.fotmrobotics.trailblazer.Vector2D;

@Autonomous
public class FirstAuto extends LinearOpMode {
    Drive drive;

    Path p;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new Drive(hardwareMap);

        p = drive.PathBuilder(new Vector2D(0, 0))
                .point(new Vector2D(10, 0))
                .build();

        telemetry.addLine("Ready");
        telemetry.update();

        waitForStart();

        p.run();

        telemetry.addLine("Done!");
        telemetry.update();
    }
}
