package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
public class SwyftWheels {
    private final DcMotor sWheel;
    public SwyftWheels(HardwareMap hardwareMap) {
        sWheel = hardwareMap.get(DcMotor.class, "swyftWheels");
        sWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void WheelSpin(Gamepad gamepad2, Telemetry telemetry) {
        sWheel.setPower((gamepad2.y ? 1 : 0) - (gamepad2.x ? 1 : 0));
    }
}