package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous
public class BlueAutoDriveTest extends LinearOpMode {
    ElapsedTime timer;
    DcMotor fRight;
    DcMotor fLeft;
    DcMotor bLeft;
    DcMotor bRight;

    @Override
    public void runOpMode() throws InterruptedException {
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
        timer = new ElapsedTime();
        waitForStart();
        if(opModeIsActive()){
            timer.reset();

            while (timer.seconds() < 0.0875){
                fRight.setPower(1);
                fLeft.setPower(1);
                bRight.setPower(1);
                bLeft.setPower(1);
            }
            fRight.setPower(0);
            fLeft.setPower(0);
            bRight.setPower(0);
            bLeft.setPower(0);
            while(timer.seconds() < 3){
                telemetry.addLine("firing");
            }
            timer.reset();
            while (timer.seconds() < 0.5){
                fRight.setPower(1);
                fLeft.setPower(-1);
                bLeft.setPower(-1);
                bRight.setPower(1);

                telemetry.addLine("Auto Run Complete.");
            }
        }
    }
}
