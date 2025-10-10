package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveBase {
    //tells robot that those variables are DcMotors and tells it how treat that variable
    DcMotor fRight;
    DcMotor fLeft;
    DcMotor bLeft;
    DcMotor bRight;
    public DriveBase(HardwareMap hardwareMap) {
        /*
         basically tells the robot where the motors are,
         the motors' names,
         and how the motors should act
         */
        fRight = hardwareMap.get(DcMotor.class, "frontRight");
        fRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fRight.setPower(0);

        fLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        fLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fLeft.setPower(0);

        bRight = hardwareMap.get(DcMotor.class, "backRight");
        bRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bRight.setPower(0);

        bLeft = hardwareMap.get(DcMotor.class, "backLeft");
        bLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bLeft.setPower(0);
    }
    public void driveMecanum(Gamepad gamepad1){
        //tells how the gamepad makes it move
        setPowers(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
    }

    public void setPowers(double y, double x, double r) {
        fLeft.setPower(-y - x - r);
        bLeft.setPower(-y + x - r);
        fRight.setPower(y - x - r);
        bRight.setPower(y + x - r);
    }
}
