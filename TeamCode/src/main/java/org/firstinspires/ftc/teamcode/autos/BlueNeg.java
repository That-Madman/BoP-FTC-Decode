package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.trees.BlueNegTree;

@Autonomous (name = "BLUE SIDE NEAR SMALL TRIANGLE")
public class BlueNeg extends BoPMode {

    @Override
    public void locInit() {
        BlueNegTree.factory(hwSuite.drive);
    }

    @Override
    public void main() {
        BlueNegTree.root().tick(debugTree, this);
    }
}

