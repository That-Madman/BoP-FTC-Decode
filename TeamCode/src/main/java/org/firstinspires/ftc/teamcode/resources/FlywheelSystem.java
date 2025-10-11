package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FlywheelSystem {

    private final DcMotorEx fly;

    public FlywheelSystem(HardwareMap hardwareMap){
        fly = hardwareMap.get(DcMotorEx.class, "fly wheels");
        fly.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void flyShoot(Gamepad gamepad1, Telemetry telemetry){
         double near = 2000;
         double far = 3000;

         if(gamepad1.x){
             fly.setVelocity(near);
         }
         else if(gamepad1.y){
             fly.setVelocity(far);
         }
         else {
             fly.setVelocity(0);
         }


        telemetry.addLine("firing artifact(s)");
    }

    public void flyCon (double velo) {
        fly.setPower(velo);
    }
}
