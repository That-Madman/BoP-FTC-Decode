package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
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

        drive.odometry.setPosition(53, 53, 225, DistanceUnit.INCH, AngleUnit.DEGREES);

        p = drive.PathBuilder(new Vector2D(53, 53))
                .action(() -> {
                    telemetry.addData("Position", drive.odometry.getPosition());
                    ElapsedTime t = new ElapsedTime();

                    while(t.seconds() < 5);
                })
                .point(new Vector2D(38.5, 38.5))
                .headingConstant(45)
                .point(new Vector2D(24, 24))
                .action(() -> {
                    telemetry.addLine("Shooting 1...");
                    telemetry.update();
                })
                .headingConstant(90)
                .point(new Vector2D(12, 24))
                .action(() ->{
                    telemetry.addLine("Intaking...");
                    telemetry.update();
                })
                .point(new Vector2D(12, 48))
                .point(new Vector2D(12, 24))
                .headingConstant(45)
                .point(new Vector2D(24, 24))
                .action(() -> {
                    telemetry.addLine("Shooting 2...");
                    telemetry.update();
                })
                .build();

        telemetry.addLine("Ready");
        telemetry.update();

        waitForStart();

        p.run(telemetry);
        drive.runMotors(new double[4]);

        while(opModeIsActive() && !isStopRequested()) {
            telemetry.addData("Position", drive.odometry.getPosition());
            telemetry.update();
        }
    }
}
