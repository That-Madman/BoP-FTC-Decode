package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.GoBildaPinpointDriver;

@TeleOp(name = "Tests")
public class TestGoBildaPinpointDriver extends OpMode {

    GoBildaPinpointDriver pin;

    @Override
    public void init() {
        pin = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");

        pin.setOffsets(4,0,DistanceUnit.MM);
        pin.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        pin.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD, GoBildaPinpointDriver.EncoderDirection.FORWARD);
        pin.resetPosAndIMU();

        telemetry.addLine("Odom tuned and ready");
        telemetry.update();
    }

    @Override
    public void loop() {
        pin.update();
        telemetry.addData("Position", pin.getPosition(DistanceUnit.INCH, AngleUnit.DEGREES));
    }
}
