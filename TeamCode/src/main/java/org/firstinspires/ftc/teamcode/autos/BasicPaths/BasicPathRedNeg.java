package org.firstinspires.ftc.teamcode.autos.BasicPaths;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Vector2D;

public class BasicPathRedNeg extends LinearOpMode {
    Drive drive;
    Path p;
    ElapsedTime e;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new Drive(hardwareMap);
        e = new ElapsedTime();

        p = drive.PathBuilder(new Vector2D(-68, -15))
                .action(() -> {
                    telemetry.addLine("Firing...");
                    telemetry.update();
                })
                .point(new Vector2D(-40, -30))
                .headingConstant(-90)
                .point(new Vector2D(-37, -60))
                .point(new Vector2D(-40, -30))
                .headingConstant(0)
                .point(new Vector2D(-68, -15))
                .action(() -> {
                    telemetry.addLine("Firing again...");
                    telemetry.update();
                })
                .build();
        telemetry.addLine("Ready...");
        telemetry.update();

        waitForStart();

        drive.odometry.setPosition(-68, -15, 0, DistanceUnit.INCH, AngleUnit.DEGREES);
        p.run(telemetry);
        drive.runMotors(new double[4]);

        while (opModeIsActive() && !isStopRequested()) {
            telemetry.addData("Position", drive.odometry.getPosition());
            telemetry.update();
        }
    }
}
