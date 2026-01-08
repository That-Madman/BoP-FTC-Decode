package org.firstinspires.ftc.teamcode.paths.BlueNeg;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Vector2D;

public class MoveToPickup {
    public static Path p;

    public static void factory (Drive d) {
        p = d.PathBuilder(new Vector2D(-68,15))
                .headingConstant(90)
                .point(new Vector2D(-37, 60))
                .build();
    }
}
