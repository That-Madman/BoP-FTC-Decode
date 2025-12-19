package org.firstinspires.ftc.teamcode.autos.emergency;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
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
                .point(new Vector2D(-72, 48))
                .build();

        waitForStart();

        drive.odometry.setPosition(-72, 24, 0, DistanceUnit.INCH, AngleUnit.DEGREES);

        p.run(telemetry);

        drive.runMotors(new double[4]);
    }
}
