package org.firstinspires.ftc.teamcode.paths.BlueNeg;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Vector2D;

public class MoveToIntake {public static Path p;

    public static void factory (Drive d) {
        p = d.PathBuilder(new Vector2D(-40,30))
                .headingConstant(90)
                .point(new Vector2D(-40, 30))
                .build();
    }
}
