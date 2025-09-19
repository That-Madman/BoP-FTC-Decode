package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SquirrelCage {
    CRServo sCage;

    public SquirrelCage(HardwareMap hardwareMap){
        sCage = hardwareMap.get(CRServo.class, "squirrelCage");
    }
    public void squirrelCage(Gamepad gamepad1, Telemetry telemetry){
        double g = gamepad1.left_trigger;

        sCage.setPower(g);
        if (g > 0) telemetry.addLine("squirrel cage engaged");
    }
}
