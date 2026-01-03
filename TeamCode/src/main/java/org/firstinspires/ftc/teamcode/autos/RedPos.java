package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.trees.RedPosTree;

@Autonomous
public class RedPos extends BoPMode {

    @Override
    public void locInit() {

    }

    @Override
    public void main() {
        RedPosTree.root().tick(debugTree, this);
    }
}
