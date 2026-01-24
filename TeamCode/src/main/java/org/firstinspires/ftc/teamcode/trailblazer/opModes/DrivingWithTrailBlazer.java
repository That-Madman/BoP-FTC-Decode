package org.firstinspires.ftc.teamcode.trailblazer.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.DriveValues;
import org.fotmrobotics.trailblazer.Pose2D;

@TeleOp(group = "Trailblazer_OpModes")
public class DrivingWithTrailBlazer extends OpMode {
    Drive d;

    boolean tN, bHeld;

    int i = 0;

    double c = 0.001;

    @Override
    public void init() {
        d = new Drive(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.y) d.movePoint((new Pose2D(0, 0, 0)));
        else if (tN) d.trueNorthDrive(gamepad1);
        else    d.mecanumDrive  (gamepad1);

        telemetry.addData("Drive Mode", (tN) ? "True North" : "Robot Relative");

        if (gamepad1.b && bHeld) tN ^= true;
        bHeld = gamepad1.b;

        i = (i + (gamepad1.dpadRightWasPressed() ? 1 : 0) - (gamepad1.dpadLeftWasPressed() ? 1 : 0)) % 3;

        switch (i) {
            case 0:
                telemetry.addData("Updating", 'P');
                DriveValues.positionPID.setKP(
                        DriveValues.positionPID.getKP()
                        + (gamepad1.dpadUpWasPressed()   ? c : 0)
                        - (gamepad1.dpadDownWasPressed() ? c : 0)
                );
                break;

            case 1:
                telemetry.addData("Updating", 'I');
                DriveValues.positionPID.setKI(
                        DriveValues.positionPID.getKI()
                                + (gamepad1.dpadUpWasPressed()   ? c : 0)
                                - (gamepad1.dpadDownWasPressed() ? c : 0)
                );
                break;

            case 2:
                telemetry.addData("Updating", 'D');
                DriveValues.positionPID.setKD(
                        DriveValues.positionPID.getKD()
                        + (gamepad1.dpadUpWasPressed()   ? c : 0)
                        - (gamepad1.dpadDownWasPressed() ? c : 0)
                );
                break;

            default:
                telemetry.addData("Updating", "None");
        }

        telemetry.addData("KP", DriveValues.positionPID.getKP());
        telemetry.addData("KI", DriveValues.positionPID.getKI());
        telemetry.addData("KD", DriveValues.positionPID.getKD());
    }
}
