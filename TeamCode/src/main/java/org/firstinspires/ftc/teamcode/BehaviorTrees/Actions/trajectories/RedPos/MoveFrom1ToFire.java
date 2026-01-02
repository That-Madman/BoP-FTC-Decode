package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;
import org.firstinspires.ftc.teamcode.paths.RedPos.MoveToPickup1;

public class MoveFrom1ToFire extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (null == org.firstinspires.ftc.teamcode.paths.RedPos.MoveFrom1ToFire.p)
            org.firstinspires.ftc.teamcode.paths.RedPos.MoveFrom1ToFire.factory(opMode.hwSuite.drive);

        return (org.firstinspires.ftc.teamcode.paths.RedPos.MoveFrom1ToFire.p.runAsync()) ?
                State.SUCCESS : State.RUNNING;
    }
}
