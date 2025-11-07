package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.resources.ColorLimelight;

@TeleOp
@Deprecated
public class LimelightTestV1 extends OpMode {

    ColorLimelight color;
    @Override
    public void init() {
        color = new ColorLimelight(hardwareMap);
    }

    @Override
    public void loop() {
        color.colorSense(telemetry);

    }
}
