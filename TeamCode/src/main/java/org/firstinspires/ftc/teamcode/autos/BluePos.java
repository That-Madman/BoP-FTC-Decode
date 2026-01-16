package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.trees.BluePosTree;

@Autonomous
public class BluePos extends BoPMode {
    @Override
    public void locInit() {
        BluePosTree.factory(hwSuite.drive);
    }

    @Override
    public void main() {
        BluePosTree.root().tick(debugTree, this);
    }
}
