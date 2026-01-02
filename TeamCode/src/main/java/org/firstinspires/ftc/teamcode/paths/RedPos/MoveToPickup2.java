package org.firstinspires.ftc.teamcode.paths.RedPos;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Vector2D;

public class MoveToPickup2 {
    public static Path p;

    public static void factory (Drive d) {
        p = d.PathBuilder(new Vector2D (24, -24))
                .headingConstant(-90)
                .point(new Vector2D(-8.6, -25.6))
                .build();
    }
}
