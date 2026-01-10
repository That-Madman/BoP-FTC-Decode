package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
public class SwyftWheels {
    private final DcMotor sWheel;
    private final ColorSensor color;
    public SwyftWheels(HardwareMap hardwareMap) {
        sWheel = hardwareMap.get(DcMotor.class, "swyftWheels");
        sWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        color = hardwareMap.get(ColorSensor.class,"color sense");
    }
    public void WheelSpin(Gamepad gamepad2, Telemetry telemetry) {
        sWheel.setPower((gamepad2.y ? 1 : 0) - (gamepad2.x ? 1 : 0));
    }
    public void autoSpin(double power){
        sWheel.setPower(power);
    }
    public boolean ballSense(Telemetry telemetry){
        if((color.blue() >= 170 && color.blue() <= 210) ||
        (color.green() >= 160 && color.green() <= 200)){
            return true;
        }
        else
            return false;
    }
}