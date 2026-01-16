package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BluePos;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class MoveStraightToFire extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (null == org.firstinspires.ftc.teamcode.paths.BluePos.MoveStraightToFire.p)
            org.firstinspires.ftc.teamcode.paths.BluePos.MoveStraightToFire.factory(opMode.hwSuite.drive);

        return (org.firstinspires.ftc.teamcode.paths.BluePos.MoveStraightToFire.p.runAsync()) ?
                State.SUCCESS : State.RUNNING;
    }
}
