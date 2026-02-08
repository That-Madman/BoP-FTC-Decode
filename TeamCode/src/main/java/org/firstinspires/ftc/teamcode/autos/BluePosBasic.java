package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.trees.basics.BluePosBasicTree;

@Autonomous (name = "BLUE SIDE NEAR BIG TRIANGLE")
public class BluePosBasic extends BoPMode {
    @Override
    public void locInit() {
        BluePosBasicTree.factory(hwSuite.drive);
    }

    @Override
    public void main() {
        BluePosBasicTree.root().tick(debugTree, this);
    }
}
