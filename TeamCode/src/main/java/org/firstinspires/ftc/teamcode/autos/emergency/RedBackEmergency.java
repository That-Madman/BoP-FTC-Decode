package org.firstinspires.ftc.teamcode.autos.emergency;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Vector2D;

@Autonomous(group = "Emergency")
public class RedBackEmergency extends LinearOpMode {
    Drive d;
    Path p;

    @Override
    public void runOpMode() throws InterruptedException {
        d = new Drive(hardwareMap);

        p = d.PathBuilder(new Vector2D(53, -53))
                .point(new Vector2D(24, -48))
                .build();

        waitForStart();

        d.odometry.setPosition(53, 53, 135, DistanceUnit.INCH, AngleUnit.DEGREES);
        p.run(telemetry);

        d.runMotors(new double[4]);
    }
}
