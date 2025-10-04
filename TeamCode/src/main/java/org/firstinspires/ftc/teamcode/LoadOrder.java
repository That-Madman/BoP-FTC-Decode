package org.firstinspires.ftc.teamcode;


import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class LoadOrder {
    ColorSensor cSensor;
    DistanceSensor dSensor;
    public LoadOrder(HardwareMap hardwareMap) {
        cSensor = hardwareMap.get(ColorSensor.class, "color sensor");
        dSensor = hardwareMap.get(DistanceSensor.class, "color sensor");

    }
    public void ordering() {
        float hsvValues[] = {0, 0, 0};
        final double SCALE_FACTOR = 255;
        android.graphics.Color.RGBToHSV(
                (int) (cSensor.red() * SCALE_FACTOR),
                (int) (cSensor.green() * SCALE_FACTOR),
                (int) (cSensor.blue() * SCALE_FACTOR),
                hsvValues
        );
        float purpleValue = Math.abs(hsvValues[0] - 220);
        float greenValue = Math.abs(hsvValues[0] - 160);

        double distance = dSensor.getDistance(DistanceUnit.CM);

        telemetry.addLine("Load Order starting");

        if(distance<=1) {
            if (purpleValue < greenValue) {
                telemetry.addLine("purple");
            } else if (greenValue < purpleValue) {
                telemetry.addLine("green");
            } else {
                telemetry.addLine("");
            }
        }
    }
}
