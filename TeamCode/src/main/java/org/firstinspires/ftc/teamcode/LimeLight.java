package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class LimeLight {

    Limelight3A limelight;

    public LimeLight(HardwareMap hardwareMap){
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
    }

    /**
     * Dummy fucntion.
     * @param telemetry
     */
    public void limeSense(Telemetry telemetry){
        limelight.pipelineSwitch(0);
        LLResult llResult = limelight.getLatestResult();
        if (llResult != null && llResult.isValid()) {
            telemetry.addData("Tx", llResult.getTx());
            telemetry.addData("Ty", llResult.getTy());
            telemetry.addData("Ta", llResult.getTa());
        }
        else{
            limelight.pipelineSwitch(1);
            }
        if (llResult != null && llResult.isValid()){
            telemetry.addData("Tx", llResult.getTx());
            telemetry.addData("Ty", llResult.getTy());
            telemetry.addData("Ta", llResult.getTa());
            }
        }

    }

