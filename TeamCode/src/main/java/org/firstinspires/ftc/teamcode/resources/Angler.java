package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Angler {
    private final DcMotor angleDcMotor;

    public Angler (HardwareMap hwMap) {
        angleDcMotor = hwMap.get(DcMotor.class, "angler");
        angleDcMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        angleDcMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }
    public void hood(Gamepad gamepad2){
        angleDcMotor.setPower(gamepad2.left_trigger - gamepad2.right_trigger);
    }
}
