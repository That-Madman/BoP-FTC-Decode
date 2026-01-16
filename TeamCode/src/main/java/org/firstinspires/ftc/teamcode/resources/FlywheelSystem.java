package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.fotmrobotics.trailblazer.PIDF;

import kotlin.Unit;

public class FlywheelSystem {

    private final DcMotorEx fly;
    PIDF pid;


    public FlywheelSystem(OpMode opMode){
        fly = opMode.hardwareMap.get(DcMotorEx.class, "fly motor");
        fly.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        pid = new PIDF(0.5, 0, 0, 0,
                this::getVelo,
                (Number p) -> {
                    fly.setPower(p.doubleValue());
                    return null;
                },
                opMode::getRuntime
        );
    }

    public double getVelo () {
        return fly.getVelocity();
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
         else flyRun(0);
    }
}
