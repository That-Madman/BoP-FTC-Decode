package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.trees.basics.RedPosBasicTree;

@Autonomous
public class RedPosBasic extends BoPMode {
    @Override
    public void locInit() {
        RedPosBasicTree.factory(hwSuite.drive);
    }

    @Override
    public void main() {
        RedPosBasicTree.root().tick(debugTree, this);
    }
}
