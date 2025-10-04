package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class DrumMotor {
    DcMotor drum;
    public DrumMotor(HardwareMap hardwareMap){
        drum = hardwareMap.get(DcMotor.class, "drum motor");
        drum.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        drum.setPower(0);
    }
    public void drumSpin(Gamepad gamepad2){
        double spin = gamepad2.right_trigger;
        drum.setPower(spin);
    }
}
