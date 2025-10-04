package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FlywheelSystem {

    DcMotorEx flyLeft;
    DcMotorEx flyRight;

    public FlywheelSystem(HardwareMap hardwareMap){
        flyLeft = hardwareMap.get(DcMotorEx.class, "flyLeft");
        flyLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        flyRight = hardwareMap.get(DcMotorEx.class, "flyRight");
        flyRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }
    public void flyShoot(Gamepad gamepad1, Telemetry telemetry){
        //TODO WHY ARE THESE ZERO?
         double near = 0;
         double far = 0;

         if(gamepad1.x){
             flyCon(near);
         }
         else if(gamepad1.y){
             flyCon(far);
         }
         else {
             flyCon(0);
         }


        telemetry.addLine("firing artifact(s)");
    }

    public void flyCon (double velo) {
        flyLeft.setVelocity(velo);
        flyRight.setVelocity(-velo);
    }
}
