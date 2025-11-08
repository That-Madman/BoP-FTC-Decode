package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Angler {
    private final Servo angleServo;
    private double tarPos;

    public Angler (HardwareMap hwMap) {
        angleServo = hwMap.get(Servo.class, "angler");
        tarPos = 0;
    }

    public Angler (HardwareMap hwMap, double startPos) {
        angleServo = hwMap.get(Servo.class, "angler");
        tarPos = startPos;
    }

    public void setPos (double pos) {
        tarPos = pos;
        angleServo.setPosition(pos);
    }

    /**
     * Sets angle of the servo
     * @param angle The desired angle, in degrees
     */
    public void setAngleDeg (double angle) {
        setPos(angle / 180); //angle * 1/180
    }

    /**
     * Sets angle of the servo
     * @param angle The desired angle, in radians
     */
    public void setAngleRad (double angle) {
        setPos(angle / Math.PI); //angle * 1/PI
    }
}
