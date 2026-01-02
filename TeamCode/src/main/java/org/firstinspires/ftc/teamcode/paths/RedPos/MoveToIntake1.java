package org.firstinspires.ftc.teamcode.paths.RedPos;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Vector2D;

public class MoveToIntake1 {
    public static Path p;

    public static void factory (Drive d) {
        p = d.PathBuilder(new Vector2D(12, -30))
                .headingConstant(-90)
                .point(new Vector2D(11.4, -56))
                .build();
    }
}
