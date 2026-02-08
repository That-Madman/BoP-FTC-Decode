package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.trees.RedNegTree;

@Autonomous (name = "RED SIDE NEAR SMALL TRIANGLE")
public class RedNeg extends BoPMode {

    @Override
    public void locInit() {
        RedNegTree.factory(hwSuite.drive);
    }

    @Override
    public void main() {
        RedNegTree.root().tick(debugTree, this);
    }
}
