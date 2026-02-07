package org.firstinspires.ftc.teamcode.resources;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class VertAim {
    Servo servo;

    private final double co = 0.1;

    public VertAim (HardwareMap hwMap) {
        servo = hwMap.get(Servo.class, "vertAim");
    }

    public void update (Gamepad gamepad, Telemetry t) {
        servo.setPosition(servo.getPosition()
                + ((gamepad.left_bumper) ? co : (gamepad.right_bumper) ? -co : 0));
        t.addData("Aim Position", servo.getPosition());
    }

    public void setPos (double pos) {
        servo.setPosition(pos);
    }
}
