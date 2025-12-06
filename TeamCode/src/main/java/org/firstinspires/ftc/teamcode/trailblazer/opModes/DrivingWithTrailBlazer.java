package org.firstinspires.ftc.teamcode.trailblazer.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;

@TeleOp(group = "Trailblazer_OpModes")
public class DrivingWithTrailBlazer extends OpMode {
    Drive d;

    boolean tN, bHeld;

    @Override
    public void init() {
        d = new Drive(hardwareMap);
    }

    @Override
    public void loop() {
        if (tN) d.trueNorthDrive(gamepad1);
        else    d.mecanumDrive  (gamepad1);

        telemetry.addData("Drive Mode", (tN) ? "True North" : "Robot Relative");

        if (gamepad1.b && bHeld) tN ^= true;
        bHeld = gamepad1.b;
    }
}
