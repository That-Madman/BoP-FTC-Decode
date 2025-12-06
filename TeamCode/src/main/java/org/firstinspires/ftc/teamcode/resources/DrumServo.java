package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DrumServo{
    CRServo drum;
    public DrumServo(HardwareMap hardwareMap, boolean manual) {
        drum = hardwareMap.get(CRServo.class, "drum servo");
    }
    public void drumSpin(Gamepad gamepad2){
         drum.setPower((gamepad2.left_bumper ? 1:0) - (gamepad2.right_bumper ? 1:0));
    }
}