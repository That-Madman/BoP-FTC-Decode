package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;

public class DrumServo {

    Servo drum;

    public DrumServo(HardwareMap hardwareMap){
        drum = hardwareMap.get(Servo.class, "drum servo");
        drum.setPosition(0);

    }
    public void drumSpin(Gamepad gamepad1){

        if(gamepad1.b = true)
            drum.setPosition(1);

        else
            drum.setPosition(0);

    }
}
