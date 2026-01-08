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
public class BasicPathRedNeg extends LinearOpMode {
    Drive d;
    Path p;
    ElapsedTime e;

    @Override
    public void runOpMode() throws InterruptedException {
        d = new Drive(hardwareMap);
        e = new ElapsedTime();

        p = d.PathBuilder(new Vector2D(-68,-15))
                .action(() -> {
                    telemetry.addLine("Firing...");
                    telemetry.update();

                    e.reset();
                })
                .pause(() -> e.seconds() >= 1.5)
                .headingConstant(-90)
                .point(new Vector2D(-40, -30))
                .point(new Vector2D(-37, -60))
                .point(new Vector2D(-40, -30))
                .headingConstant(0)
                .point(new Vector2D(-68, -15))
                .action(() -> {
                    telemetry.addLine("Firing again...");
                    telemetry.update();

                    e.reset();
                })
                .pause(() -> e.seconds() >= 1.5)
                .headingFollow()
                .point(new Vector2D(-55, -30))
                .build();

        telemetry.addLine("Ready...");
        telemetry.update();

        waitForStart();

        d.odometry.setPosition(-68,-15,0, DistanceUnit.INCH, AngleUnit.DEGREES);
        p.run(telemetry);
        d.runMotors(new double[4]);

        while(opModeIsActive() && !isStopRequested()){
            telemetry.addData("Position",d.odometry.getPosition());
            telemetry.update();
        }
    }
}