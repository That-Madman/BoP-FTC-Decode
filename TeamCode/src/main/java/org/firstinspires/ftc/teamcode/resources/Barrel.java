package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

//TODO: REWRITE TO BE CORRECT
public class Barrel {
    CRServo indexer;
    boolean emergency;

    //TODO: FIND ACTUAL VALUE. DO NOT KEEP IT AS THIS OR YOU WILL RUN INTO ISSUES!
    private final int ticsToNext = 1; //Tics to the next slot, assuming the first barrel is at 0.
    //TODO: SET EVERYTHING UP FOR A CONTINUOUS ROTATION SERVO INSTEAD OF A MOTOR EX
    public Barrel (HardwareMap hwMap) {
        indexer = hwMap.get(CRServo.class, "barrel");

        indexer.setPower(1);
        //indexer.setTargetPosition(0);
    }

    public void run (Gamepad g) {
        if (!emergency) {
            //indexer.setTargetPosition(Math.max(0, Math.min(2 * ticsToNext,
                    //indexer.getTargetPosition() +
                           // ((g.dpad_right) ?  ticsToNext : (g.dpad_left) ? -ticsToNext : 0))));

            if (g.left_stick_button && g.right_stick_button) {
                indexer.setPower(0);
                //indexer.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                emergency = true;
            }
        } else {
            indexer.setPower(g.right_stick_x); //TODO: FIND WHAT CONTROL THIS SHOULD REALLY BE
        }
    }
}
