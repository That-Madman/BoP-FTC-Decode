package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.AnalogSensor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.fotmrobotics.trailblazer.PIDF;

public class Barrel {
    DcMotorEx indexer;

    private final double res = 537.7;

    private boolean emergency = false;

    public Barrel (HardwareMap hardwareMap) {
        indexer = hardwareMap.get(DcMotorEx.class, "indexer");
        indexer.setPower(1);
        indexer.setTargetPosition(0);
        indexer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void engageFreeSpin() {
        indexer.setPower(0);
        indexer.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        indexer.setPower(1);
    }

    public void disengageFreeSpin () {
        indexer.setPower(0);
        indexer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        indexer.setPower(1);
    }

    public void setTargetPosition(int tar) {
        indexer.setTargetPosition(tar);
    }

    public void incrTargetPosition () {
        setTargetPosition(indexer.getTargetPosition() + (int) (res /4));
    }

    public void decrTargetPosition () {
        setTargetPosition(indexer.getTargetPosition() - (int) (res /4));
    }

    public void update (Gamepad gamepad) {
       if (!emergency) {
           if (gamepad.dpadRightWasPressed()) incrTargetPosition();
           if (gamepad.dpadLeftWasPressed()) decrTargetPosition();

           if (gamepad.dpad_down) {
               emergency = true;

               indexer.setPower(0);
               indexer.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
           }
       } else {
           indexer.setPower(gamepad.dpad_right ? 1 : gamepad.dpad_left ? -1 : 0);
       }
    }
}
