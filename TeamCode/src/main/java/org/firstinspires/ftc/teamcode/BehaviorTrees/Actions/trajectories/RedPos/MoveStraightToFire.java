package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class MoveStraightToFire extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (null ==  org.firstinspires.ftc.teamcode.paths.RedPos.MoveStraightToFire.p)
            org.firstinspires.ftc.teamcode.paths.RedPos.MoveStraightToFire.factory(opMode.hwSuite.drive);

        org.firstinspires.ftc.teamcode.paths.RedPos.MoveStraightToFire.p.runAsync();
        return State.SUCCESS;
    }
}
