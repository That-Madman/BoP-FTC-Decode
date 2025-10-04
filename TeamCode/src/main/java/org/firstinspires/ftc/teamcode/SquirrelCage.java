package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
public class SquirrelCage {
    DcMotor sCage;
    public SquirrelCage(HardwareMap hardwareMap) {
        sCage = hardwareMap.get(DcMotor.class, "squirrelCage");
        sCage.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void cageSpin(Gamepad gamepad2, Telemetry telemetry) {
        double g = gamepad2.left_trigger;
        sCage.setPower(-g);
        if (g > 0) {
            telemetry.addLine("squirrel cage engaged");
        }
        else{
            telemetry.addLine("");
        }
    }
}