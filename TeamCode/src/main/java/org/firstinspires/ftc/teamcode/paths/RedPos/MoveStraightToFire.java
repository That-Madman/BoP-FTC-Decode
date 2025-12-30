package org.firstinspires.ftc.teamcode.paths.RedPos;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Vector2D;

public class MoveStraightToFire {
    public static Path p;

    public static void factory(Drive d) {
        p = d.PathBuilder(new Vector2D(52, -52))
                .headingConstant(-45)
                .point(new Vector2D(24, -24))
                .build();
    }
}
