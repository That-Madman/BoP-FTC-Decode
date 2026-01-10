package org.firstinspires.ftc.teamcode.resources;


import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HorizontalAim {
    DcMotorEx aim;

    int target = 0;

    private final int co = 100;

    public HorizontalAim(HardwareMap hardwareMap){
        aim = hardwareMap.get(DcMotorEx.class,"aimH");
        aim.setTargetPosition(0);
        aim.setPower(1);
        aim.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }

    public void setTarget (int t) {
        target = t;
        aim.setTargetPosition(target);
    }
    public void rotate(Gamepad gamepad){
        setTarget(target + (int) ((gamepad1.right_trigger - gamepad.left_trigger) * co));
    }

}
