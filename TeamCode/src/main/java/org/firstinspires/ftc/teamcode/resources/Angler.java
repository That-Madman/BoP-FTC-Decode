package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Angler {
    private final DcMotor angleDcMotor;

    private final double ticsPerRev;

    public Angler (HardwareMap hwMap) {
        angleDcMotor = hwMap.get(DcMotor.class, "angler");

        angleDcMotor.setPower(1);
        angleDcMotor.setTargetPosition(0);
        angleDcMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        angleDcMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        ticsPerRev = angleDcMotor.getMotorType().getTicksPerRev();
    }

    public Angler (HardwareMap hwMap, int startPos) {
        angleDcMotor = hwMap.get(DcMotor.class, "angler");

        angleDcMotor.setPower(1);
        angleDcMotor.setTargetPosition(0);
        angleDcMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        angleDcMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        ticsPerRev = angleDcMotor.getMotorType().getTicksPerRev();
    }

    public void setPos (int pos) {
        angleDcMotor.setTargetPosition(pos);
    }

    /**
     * Sets angle of the servo
     * @param angle The desired angle, in degrees
     */
    public void setAngleDeg (double angle) {
        setPos(perToTics(angle / 180)); //angle * 1/180
    }

    /**
     * Sets angle of the servo
     * @param angle The desired angle, in radians
     */
    public void setAngleRad (double angle) {
        setPos(perToTics(angle / Math.PI)); //angle * 1/PI
    }

    public int perToTics (double percent) {
        return (int) (percent * ticsPerRev);
    }
}
