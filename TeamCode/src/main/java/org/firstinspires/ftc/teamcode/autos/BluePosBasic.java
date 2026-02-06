package org.firstinspires.ftc.teamcode.autos;

import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.trees.BluePosTree;

public class BluePosBasic extends BoPMode {
    @Override
    public void locInit() {
        BluePosTree.factory(hwSuite.drive);
    }

    @Override
    public void main() {
        BluePosTree.root().tick(debugTree, this);
    }
}
