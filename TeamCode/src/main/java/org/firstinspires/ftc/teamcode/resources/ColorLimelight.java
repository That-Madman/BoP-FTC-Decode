package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ColorLimelight {
    Limelight3A limelight;

    public ColorLimelight(HardwareMap hardwareMap) {
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.setPollRateHz(100);
        limelight.start();
    }

    public void colorSense(Telemetry telemetry) {
        limelight.pipelineSwitch(0);
        LLResult result1 = limelight.getLatestResult();
        if (result1 != null && result1.isValid()) {
            telemetry.addLine("It's green");

        } else {
            limelight.pipelineSwitch(1);
            telemetry.addLine("It's purple");
            limelight.pipelineSwitch(0);
        }
    }
}


