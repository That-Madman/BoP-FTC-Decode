package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FlywheelSystem {

    private final DcMotorEx fly;
//    PIDF pid;


    public FlywheelSystem(OpMode opMode){
        fly = opMode.hardwareMap.get(DcMotorEx.class, "fly motor");
        fly.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fly.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fly.setDirection(DcMotorSimple.Direction.REVERSE);

//        pid = new PIDF(0.0003, 0.00001, 0.00001, 0,
//                this::getVelo,
//                null,
//                opMode::getRuntime
//        );
    }

    public double getVelo () {
        return fly.getVelocity();
    }

    public void flyRun (int velo) {
//        fly.setPower(pid.pidCalc(velo));
        fly.setVelocity(velo);
    }

    public void update(Gamepad gamepad, Telemetry telemetry){
         if(gamepad.x){
             flyRun(3000);
             telemetry.addData("firing", true);
         } else if (gamepad.y) {
             fly.setVelocity(6000);
             telemetry.addData("firing", true);
         } else {
             flyRun(0);
             telemetry.addData("firing", true);
         }

        telemetry.addData("encoder output (velo)", fly.getVelocity());
        telemetry.addData("Power output (power)", fly.getPower());
    }
}
