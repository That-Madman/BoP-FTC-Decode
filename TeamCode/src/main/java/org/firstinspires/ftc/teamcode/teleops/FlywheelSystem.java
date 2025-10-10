package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FlywheelSystem {

    private final DcMotor fly;

    public FlywheelSystem(HardwareMap hardwareMap){
        fly = hardwareMap.get(DcMotor.class, "fly wheels");
        fly.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void flyShoot(Gamepad gamepad1, Telemetry telemetry){
         double near = 0.625;
         double far = 0.8825;

         if(gamepad1.x){
             fly.setPower(near);
         }
         else if(gamepad1.y){
             fly.setPower(far);
         }
         else {
             fly.setPower(0);
         }


        telemetry.addLine("firing artifact(s)");
    }

    public void flyCon (double velo) {
        fly.setPower(velo);
    }
}
