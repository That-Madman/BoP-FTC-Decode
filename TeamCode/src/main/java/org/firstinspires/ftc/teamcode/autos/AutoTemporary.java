package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;

@Deprecated
@Autonomous
public class AutoTemporary extends LinearOpMode {
    Drive driveBase;
    @Override
    public void runOpMode() throws InterruptedException {
        driveBase = new Drive(hardwareMap);
        waitForStart();
        sleep(2000);
        //driveBase.setPowers(1,0,0);
        driveBase.runMotors(new double[] {-1, -1, 1, 1});
        sleep(500);
        //driveBase.setPowers(0,0,0);
        driveBase.runMotors(new double[] {0, 0, 0, 0});
    }
}
