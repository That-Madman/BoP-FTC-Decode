package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;

public class DrumServo {
    Servo drum;

    byte drumSpot = 0;

    public DrumServo(HardwareMap hardwareMap){
        drum = hardwareMap.get(Servo.class, "drum servo");
        drum.setPosition(0);
    }
    public void drumSpin(Gamepad gamepad1){
        if (gamepad1.b) {
            ++drumSpot;
            drumSpot %= 3;
        }

        switch (drumSpot) {
            case 0:
                drum.setPosition(0);
                break;

            case 1:
                drum.setPosition(0.5);
                break;

            case 2:
                drum.setPosition(1);
                break;

            default:
                drumSpin(gamepad1); //If it fails, we just try one more time to let modulo work
        }
    }
}
