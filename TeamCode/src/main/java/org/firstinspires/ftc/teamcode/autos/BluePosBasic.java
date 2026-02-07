package org.firstinspires.ftc.teamcode.autos;

import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.trees.basics.BluePosBasicTree;

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
