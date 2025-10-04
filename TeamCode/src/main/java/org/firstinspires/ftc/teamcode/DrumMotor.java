package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DrumMotor {
    DcMotor drum;
    public DrumMotor(HardwareMap hardwareMap){
        drum = hardwareMap.get(DcMotor.class, "drum motor");
        drum.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        drum.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        drum.setPower(0);
    }

    public DrumMotor (HardwareMap hardwareMap, boolean manual) {
        drum = hardwareMap.get(DcMotor.class, "drum motor");
        drum.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        if (manual) {
            drum.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            drum.setPower(0);
        } else {
            drum.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            drum.setTargetPosition(0);
            drum.setPower(1);
        }
    }
    public void drumSpin(Gamepad gamepad2){
        double spin = gamepad2.right_trigger;
        drum.setPower(spin);
    }

    public void setTargetPosition(int pos) {
        drum.setTargetPosition(pos);
    }
}
