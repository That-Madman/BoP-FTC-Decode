package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
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
