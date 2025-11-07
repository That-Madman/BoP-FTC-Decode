package org.firstinspires.ftc.teamcode.resources;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.List;

public class AprilTagLocation {
    Limelight3A limelight;
    public AprilTagLocation(){
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.setPollRateHz(100);
        limelight.start();
    }
    public void sight(Telemetry telemetry){
        LLResult result = limelight.getLatestResult();
        List<LLResultTypes.FiducialResult> fiducials = result.getFiducialResults();
       if (result.isValid()){
           double tx = result.getTx();
           for (LLResultTypes.FiducialResult fiducial : fiducials) {
               int id = fiducial.getFiducialId();
               telemetry.addData("X distance to AprilTag", tx);
               telemetry.addData("AprilTag ID", id);
           }
       }
       else{
           telemetry.addLine("No target");
       }
    }
}
