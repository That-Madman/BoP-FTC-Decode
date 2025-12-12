package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FlywheelSystem {

    private final DcMotorEx fly1;


    public FlywheelSystem(HardwareMap hardwareMap){
        fly1 = hardwareMap.get(DcMotorEx.class, "fly motor");
        fly1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void flyShoot(Gamepad gamepad1, Telemetry telemetry){
         if(gamepad1.x){
             fly1.setVelocity(3000);
             telemetry.addData("encoder output", fly1.getVelocity());
             telemetry.addLine("firing artifact(s)");
         }
         else if(gamepad1.y){
             fly1.setVelocity(35);
             telemetry.addData("encoder output idle", fly1.getVelocity());
         }
         else fly1.setVelocity(0);
    }

    public void flyCon (double velo) {
        fly1.setPower(velo);
    }
}
