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

    public Barrel (HardwareMap hardwareMap) {
        indexer = hardwareMap.get(DcMotorEx.class, "indexer");
        indexer.setPower(1);
        indexer.setTargetPosition(0);
        indexer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void setTargetPosition(int tar) {
        indexer.setTargetPosition(tar);
    }

    public void incrTargetPosition () {
        indexer.setTargetPosition(indexer.getTargetPosition() + (int) (res /4));
    }

    public void decrTargetPosition () {
        indexer.setTargetPosition(indexer.getTargetPosition() - (int) (res /4));
    }

    public void update (Gamepad gamepad) {
        indexer.setTargetPosition(indexer.getTargetPosition() +
                (int) ((res / 4) *
                        ((gamepad.dpadRightWasPressed() ? 1 : 0) -
                                (gamepad.dpadLeftWasPressed() ? 1 : 0))));
    }
}
