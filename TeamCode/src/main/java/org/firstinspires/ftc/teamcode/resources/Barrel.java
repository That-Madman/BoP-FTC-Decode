package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Barrel {
    DcMotorEx indexer;
    boolean emergency;

    public Barrel (HardwareMap hwMap) {
        indexer = hwMap.get(DcMotorEx.class, "barrel");

        indexer.setPower(1);
        indexer.setTargetPosition(0);
        indexer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void run () {
        if (!emergency) {

        } else {
            
        }
    }
}
