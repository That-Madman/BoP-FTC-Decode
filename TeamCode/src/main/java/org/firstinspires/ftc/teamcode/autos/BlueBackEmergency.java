package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Vector2D;

public class BlueBackEmergency extends LinearOpMode {
    Drive d;
    Path p;

    @Override
    public void runOpMode() throws InterruptedException {
        d = new Drive(hardwareMap);

        p = d.PathBuilder(new Vector2D(53, 53))
                .point(new Vector2D(24, 48))
                .build();

        waitForStart();

        d.odometry.setPosition(53, 53, 45, DistanceUnit.INCH, AngleUnit.DEGREES);
        p.run(telemetry);

        d.runMotors(new double[4]);
    }
}
