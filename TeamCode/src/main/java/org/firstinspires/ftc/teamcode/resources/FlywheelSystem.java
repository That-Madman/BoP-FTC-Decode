package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FlywheelSystem {

    private final DcMotorEx fly1;
    private final DcMotorEx fly2;


    public FlywheelSystem(HardwareMap hardwareMap){
        fly1 = hardwareMap.get(DcMotorEx.class, "fly motor1");
        fly1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fly2 = hardwareMap.get(DcMotorEx.class, "fly motor2");
        fly2.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }
    public void flyShoot(Gamepad gamepad1, Telemetry telemetry){
         if(gamepad1.x){
             fly1.setVelocity(3000);
             fly2.setVelocity(3000);
             telemetry.addData("encoder output 1", fly1.getVelocity());
             telemetry.addData("encoder output 2", fly2.getVelocity());
             telemetry.addLine("firing artifact(s)");
         }
         else fly1.setVelocity(0);
    }
}
