package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class VertAim {
    Servo servo;

    private final double co = 0.2;

    public VertAim (HardwareMap hwMap) {
        servo = hwMap.get(Servo.class, "vertAim");
    }

    public void update (Gamepad gamepad) {
        servo.setPosition(servo.getPosition()
                + ((gamepad.left_bumper) ? co : (gamepad.right_bumper) ? -co : 0));
    }
}
