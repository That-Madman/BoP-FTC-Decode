package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class MoveToPickup2 extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (null == org.firstinspires.ftc.teamcode.paths.RedPos.MoveToPickup2.p)
            org.firstinspires.ftc.teamcode.paths.RedPos.MoveToPickup2.factory(opMode.hwSuite.drive);

        return (org.firstinspires.ftc.teamcode.paths.RedPos.MoveToPickup2.p.runAsync()) ?
                State.SUCCESS : State.RUNNING;
    }
}
