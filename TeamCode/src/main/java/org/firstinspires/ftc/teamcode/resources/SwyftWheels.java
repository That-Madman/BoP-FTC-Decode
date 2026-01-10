package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SwyftWheels {
    private final DcMotor sWheel;
    private final ColorSensor color;
    public SwyftWheels(HardwareMap hardwareMap) {
        sWheel = hardwareMap.get(DcMotor.class, "swyftWheels");
        sWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        color = hardwareMap.get(ColorSensor.class,"colorSense");
    }

    public void update (Gamepad gamepad2) {
        spin((gamepad2.y) ? 1 : (gamepad2.x) ? -1 : 0);
    }
    public void spin(double power){
        sWheel.setPower(power);
    }
    public boolean ballSense (){
         return (color.blue() >= 170 && color.blue() <= 210) ||
        (color.green() >= 160 && color.green() <= 200);
    }
}