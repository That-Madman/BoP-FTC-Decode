package org.firstinspires.ftc.teamcode.paths.RedNeg;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Vector2D;

public class MoveToFire {
    public static Path p;

    public static void factory (Drive d) {
        p = d.PathBuilder(new Vector2D(-68, -15))
                .headingConstant(-10)
                .point(new Vector2D(-67, -16))
                .build();
    }
}
