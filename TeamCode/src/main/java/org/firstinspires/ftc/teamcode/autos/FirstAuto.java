package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Vector2D;

@Autonomous
public class FirstAuto extends LinearOpMode {
    Drive drive;
    Path p;
    @Override
    public void runOpMode() throws InterruptedException {
        drive = new Drive(hardwareMap);
        p = drive.PathBuilder(new Vector2D(53, 53))
                //TODO: WHY DOES THIS NOT WORK?
//                .xScale(0.25, Path.EventType.SEQUENTIAL)
//                .yScale(0.25, Path.EventType.SEQUENTIAL)
                .point(new Vector2D(38.5, 38.5))
                .headingConstant(45)
                .point(new Vector2D(24, 24))
                .action(() -> {
                    telemetry.addLine("Shooting 1...");
                    telemetry.update();

                    sleep(1000);
                })
                .headingConstant(90)
                .point(new Vector2D(12, 24))
                .action(() -> {
                    telemetry.addLine("Intaking...");
                    telemetry.update();
                })
                .point(new Vector2D(12, 60))
                .point(new Vector2D(12, 24))
                .headingConstant(45)
                .point(new Vector2D(24, 24))
                .action(() -> {
                    telemetry.addLine("Shooting 2...");
                    telemetry.update();

                    sleep(1000);
                })
                .build();

        telemetry.addLine("Ready");
        telemetry.update();

        waitForStart();

        drive.odometry.setPosition(53, 53, 225, DistanceUnit.INCH, AngleUnit.DEGREES);
        p.run(telemetry);
        drive.runMotors(new double[4]);

        while(opModeIsActive() && !isStopRequested()) {
            telemetry.addData("Position", drive.odometry.getPosition());
            telemetry.update();
        }
    }
}
