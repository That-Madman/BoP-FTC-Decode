package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FlywheelSystem {

    Servo flyLeft;
    Servo flyRight;

    public FlywheelSystem(HardwareMap hardwareMap){
        flyLeft = hardwareMap.get(Servo.class, "flyLeft");
        flyLeft.setPosition(0);

        flyRight = hardwareMap.get(Servo.class, "flyRight");
        flyRight.setPosition(0);
    }
    public void flyShoot(Gamepad gamepad1, Telemetry telemetry){
        double s = gamepad1.right_trigger;

        flyLeft.setPosition(s);
        flyRight.setPosition(-s);

        telemetry.addLine("firing artifact(s)");
    }
}
