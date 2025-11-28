package org.firstinspires.ftc.teamcode.trailblazer.drivebase;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.fotmrobotics.trailblazer.Pose2D;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;

/**
 * Controls the odometry. Currently supports the SparkFunOTOS and Gobuilda Odom Computers.
 * To change the odometry method, change the methods corresponding to what they do.
 *
 * @author Preston Cokis
 */
public class Odometry {
    DriveValues driveValues = new DriveValues();

    private final GoBildaPinpointDriver odo;

    Pose2D currentPos;
    Pose2D lastPos;

    public Odometry(HardwareMap hardwareMap) {
        odo = hardwareMap.get(GoBildaPinpointDriver.class, "odo");

        odo.setOffsets(driveValues.offset.getX(),driveValues.offset.getY(), driveValues.offsetUnit);

        odo.setEncoderDirections(driveValues.odoDir[0], driveValues.odoDir[1]);

        odo.setEncoderResolution(driveValues.podType);

        odo.resetPosAndIMU();

        currentPos = new Pose2D(0,0,0);

        odo.setPosition(new org.firstinspires.ftc.robotcore.external.navigation.Pose2D(
                DistanceUnit.MM, 0,0,AngleUnit.RADIANS, 0));
    }

    /**
     * Updates the position values.
     */
    public void update() {
        lastPos = currentPos;
        odo.update();

        currentPos.setX(odo.getPosX(driveValues.linearUnit));
        currentPos.setY(odo.getPosY(driveValues.linearUnit));
        currentPos.setH(odo.getHeading(driveValues.angularUnit));
    }

    public Pose2D getPosition() {
        update();
        return currentPos;
    }

    public Pose2D getLastPosition() {
        return lastPos;
    }

    /**
     * Resets the heading.
     */
    public void resetHeading() {
        odo.setHeading(0, AngleUnit.DEGREES);
    }

    /**
     * Resets the position.
     */
    public void resetPosition() {
        odo.resetPosAndIMU();
    }

    public int getLoopTime () {
        return odo.getLoopTime();
    }
}
