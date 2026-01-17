package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BlueNeg;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class MoveToPickup extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (null == org.firstinspires.ftc.teamcode.paths.BlueNeg.MoveToPickup.p)
            org.firstinspires.ftc.teamcode.paths.BlueNeg.MoveToPickup.factory(opMode.hwSuite.drive);

        org.firstinspires.ftc.teamcode.paths.BlueNeg.MoveToPickup.p.run();
        return State.SUCCESS;
    }
}
