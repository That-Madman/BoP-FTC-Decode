package org.firstinspires.ftc.teamcode.paths.RedPos;

import android.provider.Telephony;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Vector2D;

public class MoveFrom2ToFire {
    public static Path p;

    public static void factory (Drive d) {
        p = d.PathBuilder(new Vector2D(-12.6, -56))
                .headingConstant(-90)
                .point(new Vector2D(-8.6,-25.6))
                .headingConstant(-45)
                .point(new Vector2D(24,-24))
                .build();
    }
}
