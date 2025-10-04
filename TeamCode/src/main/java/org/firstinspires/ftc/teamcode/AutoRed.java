package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.List;
@Autonomous
public class AutoRed extends LinearOpMode {
    Limelight3A limelight;
    DcMotorEx flyRight;
    DcMotorEx flyLeft;
    DcMotor fRight;
    DcMotor fLeft;
    DcMotor bLeft;
    DcMotor bRight;
    ElapsedTime timer;
    DcMotor drum;
    @Override
    public void runOpMode() throws InterruptedException {
        drum = hardwareMap.get(DcMotor.class, "drum");
        drum.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        drum.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        drum.setPower(0);
        fRight = hardwareMap.get(DcMotor.class, "frontRight");
        fRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fRight.setPower(0);
        bRight = hardwareMap.get(DcMotor.class, "backRight");
        bRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bRight.setPower(0);
        fLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        fLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fLeft.setPower(0);
        bLeft = hardwareMap.get(DcMotor.class, "backLeft");
        bLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bLeft.setPower(0);
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        telemetry.setMsTransmissionInterval(11);
        limelight.start();
        limelight.pipelineSwitch(0);
        timer = new ElapsedTime();
        if (opModeIsActive()){

            timer.reset();
            LLResult result = limelight.getLatestResult();
            if(result != null && result.isValid()){
                List<LLResultTypes.FiducialResult> fiducials = result.getFiducialResults();
                for(LLResultTypes.FiducialResult fiducial : fiducials) {
                    int id = fiducial.getFiducialId();
                    if (id == 24){
                        timer.reset();
                        while (timer.seconds() < 0.0875){
                            fRight.setPower(-1);
                            fLeft.setPower(-1);
                            bRight.setPower(-1);
                            bLeft.setPower(-1);
                        }
                        fRight.setPower(0);
                        fLeft.setPower(0);
                        bRight.setPower(0);
                        bLeft.setPower(0);
                        while(timer.seconds()<3) {
                            telemetry.addLine("Firing Artifacts");
                            flyRight.setVelocity(-1);
                            flyLeft.setVelocity(1);
                            drum.setTargetPosition(140);
                            wait(1);
                            drum.setTargetPosition(280);
                            wait(1);
                            drum.setTargetPosition(420);
                        }
                        flyRight.setVelocity(-1);
                        flyLeft.setVelocity(1);
                        drum.setTargetPosition(140);
                        wait(1);
                        drum.setTargetPosition(280);
                        wait(1);
                        drum.setTargetPosition(420);
                    }
                    else if(id == 21){
                        telemetry.addLine("green, purple, purple");
                    }
                    else if(id == 22){
                        telemetry.addLine("purple, green, purple");
                    }
                    else if(id == 23){
                        telemetry.addLine("purple, purple, green");
                    }
                    else if(id == 20){
                        telemetry.addLine("wrong goal");
                    }
                    else if(timer.seconds() < 0.25){
                        fRight.setPower(1);
                        fLeft.setPower(-1);
                        bLeft.setPower(-1);
                        bRight.setPower(1);
                    }
                    else{
                        telemetry.addLine("Auto run complete, staying stationary for remainder");
                    }
                }
            }
        }
    }
}