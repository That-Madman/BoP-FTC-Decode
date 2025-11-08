package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.fotmrobotics.trailblazer.Pose2D;

import java.util.List;

public class Limelight {
    Limelight3A limelight;
    Drive drive;
    LLResult lastResult;

    public Limelight(HardwareMap hwMap, Drive dr) {
        limelight = hwMap.get(Limelight3A.class, "limelight");
        limelight.setPollRateHz(100);
        limelight.start();
        limelight.pipelineSwitch(0);

        drive = dr;
    }

    public void updateVis () {
        lastResult = limelight.getLatestResult();
    }

    @Deprecated
    public void sight(Telemetry telemetry){ //TODO: poor practice. Rename or remove.
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

    /**
     * Gets where we are
     * @return A Pose2D of where we are
     */
    public Pose2D megaTag () {
        limelight.updateRobotOrientation(drive.odometry.getPosition().getH());
        updateVis();

        if (lastResult != null && lastResult.isValid() &&lastResult.getBotpose_MT2()!= null) {
                return new Pose2D(
                        //X
                        drive.driveValues.linearUnit.fromUnit(
                                lastResult.getBotpose_MT2().getPosition().unit,
                                lastResult.getBotpose_MT2().getPosition().x),

                        //Y
                        drive.driveValues.linearUnit.fromUnit(
                                lastResult.getBotpose_MT2().getPosition().unit,
                                lastResult.getBotpose_MT2().getPosition().y),

                        //Theta
                        lastResult.getBotpose_MT2().getOrientation().getYaw(drive.driveValues.angularUnit)
                        );
        }

        return null;
    }
}
