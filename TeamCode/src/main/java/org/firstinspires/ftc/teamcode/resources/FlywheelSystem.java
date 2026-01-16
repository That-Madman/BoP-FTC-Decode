package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FlywheelSystem {

    private final DcMotorEx fly;


    public FlywheelSystem(HardwareMap hardwareMap){
        fly = hardwareMap.get(DcMotorEx.class, "fly motor");
        fly.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void flyRun (int velo) {
        fly.setVelocity(velo);
    }

    public void update(Gamepad gamepad, Telemetry telemetry){
         if(gamepad.x){
             flyRun(3000);
             telemetry.addData("encoder output 1", fly.getVelocity());
             telemetry.addLine("firing artifact(s)");
         }
         else fly.setVelocity(0);
    }
}
