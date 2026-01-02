package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class MoveFrom2ToFire extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (null == org.firstinspires.ftc.teamcode.paths.RedPos.MoveFrom2ToFire.p)
            org.firstinspires.ftc.teamcode.paths.RedPos.MoveFrom2ToFire.factory(opMode.hwSuite.drive);

        return (org.firstinspires.ftc.teamcode.paths.RedPos.MoveFrom2ToFire.p.runAsync()) ?
                State.SUCCESS : State.RUNNING;
    }
}
