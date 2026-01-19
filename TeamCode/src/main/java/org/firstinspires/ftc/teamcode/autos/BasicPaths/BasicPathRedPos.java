package org.firstinspires.ftc.teamcode.autos.BasicPaths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Vector2D;
@Autonomous(group = "Basic Path")
public class BasicPathRedPos extends LinearOpMode {
    Drive d;
    Path p;
    ElapsedTime e;
    @Override
    public void runOpMode() throws InterruptedException {
        d = new Drive(hardwareMap);
        e = new ElapsedTime();

        p = d.PathBuilder(new Vector2D(52,-52))
                .headingConstant(-45)
                .point(new Vector2D(24,-24))
                .action(() -> {
                    telemetry.addLine("Shooting...");
                    telemetry.update();
                })
                .pause(()-> e.seconds() >= 1.5)
                .headingConstant(-90)
                .point(new Vector2D(12,-30))
                .point(new Vector2D(11.4,-54))
                .point(new Vector2D(12,-30))
                .headingConstant(-45)
                .point(new Vector2D(24,-24))
                .action(() -> {
                    telemetry.addLine("Shooting...");
                    telemetry.update();

                    e.reset();
                })
                .pause(() ->e.seconds() >= 1.5)
                .headingConstant(-90)
                .point(new Vector2D(-8.6,-25.6))
                .point(new Vector2D(-12.6,-56))
                .point(new Vector2D(-8.6,-25.6))
                .headingConstant(-45)
                .point(new Vector2D(24,-24))
                .action(() -> {
                    telemetry.addLine("Shooting...");
                    telemetry.update();

                    e.reset();
                })
                .point(new Vector2D(12, -24))
                .build();

        telemetry.addLine("Ready...");
        telemetry.update();

        waitForStart();

        d.odometry.setPosition(52,-52,-45, DistanceUnit.INCH, AngleUnit.DEGREES);
        p.run(telemetry);
        d.runMotors(new double[4]);

        while(opModeIsActive() && !isStopRequested()){
            telemetry.addData("Position",d.odometry.getPosition());
            telemetry.update();

        }
    }
}
