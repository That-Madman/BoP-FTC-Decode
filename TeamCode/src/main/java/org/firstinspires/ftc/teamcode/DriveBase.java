package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class DriveBase {
    DcMotor fRight;
    DcMotor fLeft;
    DcMotor bLeft;
    DcMotor bRight;

    public DriveBase(HardwareMap hardwareMap) {
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
        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double r = gamepad1.right_stick_x;

        //TODO: Check if this is right on our other drivebase.
        fLeft.setPower(y + x + r);
        bLeft.setPower(-y + x - r);
        fRight.setPower(y - x - r);
        bRight.setPower(y + x - r);

    }

}
