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
         double near = 0;
         double far = 0;

         if(gamepad1.x){
             flyLeft.setVelocity(near);
             flyRight.setVelocity(-near);
         }
         else if(gamepad1.y){
             flyLeft.setVelocity(far);
             flyRight.setVelocity(-far);
         }
         else {
             flyLeft.setVelocity(0);
             flyRight.setVelocity(0);
         }


        telemetry.addLine("firing artifact(s)");
    }
}
