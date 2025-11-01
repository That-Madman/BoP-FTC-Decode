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
        fly1 = hardwareMap.get(DcMotorEx.class, "fly motor right");
        fly1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fly2 = hardwareMap.get(DcMotorEx.class, "fly motor left");
        fly2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void flyShoot(Gamepad gamepad1, Telemetry telemetry){
         double near = 2000;
         double far = 3000;

         if(gamepad1.x){
             fly1.setVelocity(near);
             fly2.setVelocity(near);
         }
         else if(gamepad1.y){
             fly1.setVelocity(far);
             fly2.setVelocity(far);
         }
         else {
             fly1.setVelocity(0);
             fly2.setVelocity(0);
         }


        telemetry.addLine("firing artifact(s)");
    }

    public void flyCon (double velo) {
        fly1.setPower(velo);
    }
}
