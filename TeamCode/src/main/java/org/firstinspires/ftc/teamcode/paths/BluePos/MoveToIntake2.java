package org.firstinspires.ftc.teamcode.paths.BluePos;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Vector2D;

public class MoveToIntake2 {
    public static Path p;

    public static void factory (Drive d) {
        p = d.PathBuilder(new Vector2D(-8.6, 25.6))
                .headingConstant(90)
                .point(new Vector2D(-12.6,50))
                .build();
    }
}
