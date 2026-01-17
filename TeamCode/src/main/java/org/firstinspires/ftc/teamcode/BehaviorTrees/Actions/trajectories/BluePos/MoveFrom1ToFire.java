package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BluePos;

import com.ftcteams.behaviortrees.DebugTree;
import com.ftcteams.behaviortrees.Node;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class MoveFrom1ToFire extends BNode {
    @Override
    public Node.State tick(DebugTree debug, BoPMode opMode) {
        if (null == org.firstinspires.ftc.teamcode.paths.BluePos.MoveFrom1ToFire.p)
            org.firstinspires.ftc.teamcode.paths.BluePos.MoveFrom1ToFire.factory(opMode.hwSuite.drive);

        org.firstinspires.ftc.teamcode.paths.BluePos.MoveFrom1ToFire.p.run();
        return Node.State.SUCCESS;
    }
}
