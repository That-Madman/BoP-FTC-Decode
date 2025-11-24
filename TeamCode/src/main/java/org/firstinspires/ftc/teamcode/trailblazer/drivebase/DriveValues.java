package org.firstinspires.ftc.teamcode.trailblazer.drivebase;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.fotmrobotics.trailblazer.PIDF;
import org.fotmrobotics.trailblazer.Vector2D;

/**
 * Edit all components here.
 */
public class DriveValues{
    /*
    Name of the motors in the configuration
    Control Hub:
    0. Front Left
    1. Front Right
    Expansion Hub
    TBD Back Left
    TBD Back Right
    */
    String[] motorNames = {
            "frontLeft",
            "frontRight",
            "backLeft",
            "backRight"
    };

    // TODO: Reverse motors if necessary.
    int[] reverseMotors = {
            1,
            2,
            3
    };

    GoBildaPinpointDriver.EncoderDirection[]  odoDir = {
            GoBildaPinpointDriver.EncoderDirection.REVERSED,
            GoBildaPinpointDriver.EncoderDirection.FORWARD
    };

    // TODO: Tune the PIDF loops.
    PIDF positionPID = new PIDF(0.06, 0,0.05,0);
    PIDF headingPID = new PIDF(0, 0,0,0);

    // TODO: Change if necessary.
    // Position of the GoBildaPinpointDriver relative to the center.
    Vector2D offset = new Vector2D(4,0);
    DistanceUnit offsetUnit = DistanceUnit.MM;

    // Units
    public DistanceUnit linearUnit = DistanceUnit.INCH;
    public AngleUnit angularUnit = AngleUnit.DEGREES;

    //Type of odom pod used
    public GoBildaPinpointDriver.GoBildaOdometryPods podType = GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD;

    // Scale for speed.
    double xScale = 1;
    double yScale = 1;
    double angularScale = 1;
}
