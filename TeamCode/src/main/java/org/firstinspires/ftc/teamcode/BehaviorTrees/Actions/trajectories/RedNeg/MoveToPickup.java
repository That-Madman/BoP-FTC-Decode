package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedNeg;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class MoveToPickup extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (null == org.firstinspires.ftc.teamcode.paths.RedNeg.MoveToPickup.p)
            org.firstinspires.ftc.teamcode.paths.RedNeg.MoveToPickup.factory(opMode.hwSuite.drive);

        org.firstinspires.ftc.teamcode.paths.RedNeg.MoveToPickup.p.run();
        return State.SUCCESS;
    }
}
