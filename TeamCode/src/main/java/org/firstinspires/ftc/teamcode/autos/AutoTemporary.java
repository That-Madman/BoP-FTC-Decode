package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.resources.DriveBase;

@Autonomous
public class AutoTemporary extends LinearOpMode {
    DriveBase driveBase;
    @Override
    public void runOpMode() throws InterruptedException {
        driveBase = new DriveBase(hardwareMap);
        waitForStart();
        sleep(2000);
        driveBase.setPowers(1,0,0);
        sleep(500);
        driveBase.setPowers(0,0,0);
    }
}
