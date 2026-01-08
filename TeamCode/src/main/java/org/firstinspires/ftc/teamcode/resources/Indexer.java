package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.AnalogSensor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.fotmrobotics.trailblazer.PIDF;

public class Indexer {
    CRServo servo;
    AnalogSensor enc;

    PIDF pid;

    int rotsDone = 0;
    double lastVolt = 0;

    double target = 0;

    public Indexer (OpMode op) {
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

    public double getAngle () {
        double currVol = enc.readRawVoltage();

        rotsDone += (servo.getPower() > 0)        ?
                    (currVol < lastVolt) ?  1 : 0 :
                    (currVol > lastVolt) ? -1 : 0 ;

        lastVolt = currVol;

        return ((enc.readRawVoltage() / 3.3) + rotsDone) * 360;
    }

    public void setTargetPos (double target) {
        this.target = target;
        pid.pidCalc(target);
    }

    public void update (Gamepad gamepad) {

    }
}
