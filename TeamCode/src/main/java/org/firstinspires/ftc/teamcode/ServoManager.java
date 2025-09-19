package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoManager {
    double p;
    Servo servo;

    public ServoManager(HardwareMap hardwareMap){
        servo = hardwareMap.get(Servo.class, "servo");

    }
    public void servoValues(Gamepad gamepad1){
        servo.setPosition(p);

        if(gamepad1.dpad_up)
             p = 1;
         else if(gamepad1.dpad_down)
             p = 0;
    }
}
