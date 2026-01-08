package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.AnalogSensor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.fotmrobotics.trailblazer.PIDF;

public class Barrel {
    CRServo servo;
    AnalogSensor enc;

    PIDF pid;

    int rotsDone = 0;
    double lastVolt = 0;

    double target = 0;

    private final double degreesToTic = 90; //TODO: Check if correct

    boolean emergency;

    public Barrel(OpMode op) {
        servo = op.hardwareMap.get(CRServo.class, "indexer");
        enc = op.hardwareMap.get(AnalogSensor.class, "indexerEnc");

        pid = new PIDF(
                0.1,
                0.0,
                0.0,
                0.0,
                this::getAngle,
                (Number target) -> {
                    servo.setPower(target.doubleValue());
                    return null;
                },
                op::getRuntime
        );
    }

    public double getAngle() {
        double currVol = enc.readRawVoltage();

        rotsDone += (servo.getPower() > 0) ?
                (currVol < lastVolt) ? 1 : 0 :
                (currVol > lastVolt) ? -1 : 0;

        lastVolt = currVol;

        return ((enc.readRawVoltage() / 3.3) + rotsDone) * 360;
    }

    public void setTargetPos(double target) {
        this.target = target;
        pid.pidCalc(target);
    }

    public void update(Gamepad gamepad) {
        if (!emergency) {
            setTargetPos(target + ((gamepad.dpad_right) ?
                    degreesToTic : (gamepad.dpad_left) ? -degreesToTic : 0));

            if (gamepad.left_stick_button && gamepad.right_stick_button) {
                servo.setPower(0);
                emergency = true;
            }
        } else {
            servo.setPower(gamepad.right_stick_x); //TODO: FIND WHAT CONTROL THIS SHOULD REALLY BE
        }
    }
}
