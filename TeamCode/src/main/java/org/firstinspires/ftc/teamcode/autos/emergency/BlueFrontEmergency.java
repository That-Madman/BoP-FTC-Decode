package org.firstinspires.ftc.teamcode.autos.emergency;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Vector2D;
@Autonomous(group = "Emergency")
public class BlueFrontEmergency extends LinearOpMode{
    Drive drive;
    Path p;
    @Override
    public void runOpMode() throws InterruptedException {
        drive = new Drive(hardwareMap);
        waitForStart();
        p = drive.PathBuilder(new Vector2D(-72, 24))
                .point(new Vector2D(-60, 6))
                .point(new Vector2D(-48, 24))
                .build();

        waitForStart();

        p.run(telemetry);

        drive.runMotors(new double[4]);
    }
}
