package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FlywheelSystem {

    CRServo flyLeft;
    CRServo flyRight;

    public FlywheelSystem(HardwareMap hardwareMap){
        flyLeft = hardwareMap.get(CRServo.class, "flyLeft");

        flyRight = hardwareMap.get(CRServo.class, "flyRight");
        flyRight.setPower(0);
    }
    public void flyShoot(Gamepad gamepad1, Telemetry telemetry){
        double s = gamepad1.right_trigger;

        flyLeft.setPower(s);
        flyRight.setPower(-s);

        telemetry.addLine("firing artifact(s)");
    }
}
