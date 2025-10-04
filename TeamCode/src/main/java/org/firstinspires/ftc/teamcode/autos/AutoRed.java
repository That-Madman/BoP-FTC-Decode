package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.DriveBase;
import org.firstinspires.ftc.teamcode.DrumMotor;
import org.firstinspires.ftc.teamcode.FlywheelSystem;

import java.util.List;
@Autonomous
public class AutoRed extends LinearOpMode {
    Limelight3A limelight;
    FlywheelSystem flywheels;
    DriveBase dB;
    LLResult result;
    ElapsedTime timer;
    DrumMotor drum;

    @Override
    public void runOpMode() throws InterruptedException {
        drum = new DrumMotor(hardwareMap, false);

        dB = new DriveBase(hardwareMap);

        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        telemetry.setMsTransmissionInterval(11);
        limelight.start();
        limelight.pipelineSwitch(0);
        timer = new ElapsedTime();

        if (opModeIsActive()) {
            timer.reset();
            result = limelight.getLatestResult();
            if (result != null && result.isValid()) {
                List<LLResultTypes.FiducialResult> fiducials = result.getFiducialResults();
                for (LLResultTypes.FiducialResult fiducial : fiducials) {
                    switch (fiducial.getFiducialId()) {
                        case 24:
                            timer.reset();
                            while (timer.seconds() < 0.0875) {
                                dB.setPowers(0, 0, 1);
                            }

                            dB.setPowers(0, 0, 0);

                            while (timer.seconds() < 3) {
                                telemetry.addLine("Firing Artifacts");
                                flywheels.flyCon(1);
                                drum.setTargetPosition(140);
                                wait(1);
                                drum.setTargetPosition(280);
                                wait(1);
                                drum.setTargetPosition(420);
                            }
                            break;

                        case 21:
                            telemetry.addLine("green, purple, purple");
                            break;

                        case 22:
                            telemetry.addLine("purple, green, purple");
                            break;

                        case 23:
                            telemetry.addLine("purple, purple, green");
                            break;

                        case 20:
                            telemetry.addLine("wrong goal");
                            break;

                        default:
                            if (timer.seconds() < 0.25) {
                                dB.setPowers(1, 0,0);
                            } else {
                                telemetry.addLine("Auto run complete, staying stationary for remainder");
                            }
                    }
                }
            }
        }
    }
}