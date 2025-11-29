package org.firstinspires.ftc.teamcode.trailblazer.opModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Vector2D;

@Autonomous(group = "Trailblazer_OpModes")
public class BackAndForth extends OpMode {
    Drive d;

    Path p;

    int i = 0;

    @Override
    public void init() {
        d = new Drive(hardwareMap);

        p = d.PathBuilder(new Vector2D(0, 0))
                .headingConstant(0)
                .xScale(0.85)
                .yScale(0.85)
                .point(new Vector2D(48, 0))
                .point(new Vector2D(-48, 0))
                .point(new Vector2D(0, 0))
                .build();
    }

    @Override
    public void loop() {
       p.run();
       i++;

       telemetry.addData("Iteration", i);
       telemetry.addData("Last Path Ended", d.odometry.getPosition());
    }
}
