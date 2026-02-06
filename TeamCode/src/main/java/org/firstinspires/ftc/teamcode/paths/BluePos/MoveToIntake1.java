package org.firstinspires.ftc.teamcode.paths.BluePos;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Vector2D;

public class MoveToIntake1 {
    public static Path p;

    public static void factory (Drive d) {
        p = d.PathBuilder(new Vector2D(12, 30))
                .xScale(0.8)
                .yScale(0.8)
                .headingConstant(90)
                .point(new Vector2D(11.4, 50))
                .build();
    }
}
