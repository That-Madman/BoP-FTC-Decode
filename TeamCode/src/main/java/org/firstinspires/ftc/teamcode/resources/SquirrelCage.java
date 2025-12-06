package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
public class SquirrelCage {
    private final DcMotor sCage;
    public SquirrelCage(HardwareMap hardwareMap) {
        sCage = hardwareMap.get(DcMotor.class, "squirrelCage");
        sCage.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void cageSpin(Gamepad gamepad2, Telemetry telemetry) {
        sCage.setPower((gamepad2.x ? 1 : 0) - (gamepad2.y ? 1 : 0));
    }
}