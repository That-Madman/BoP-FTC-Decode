package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ActualIntake {
    DcMotor sCage;

    public ActualIntake(HardwareMap hardwareMap){
        sCage = hardwareMap.get(DcMotor.class, "squirrelCage");
        sCage.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        sCage.setPower(0);

    }
    public void squirrelCage(Gamepad gamepad1, Telemetry telemetry){
        double g = gamepad1.left_trigger;

        sCage.setPower(g);
        telemetry.addLine("grabbing artifact");
    }
}
