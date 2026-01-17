package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class Park extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (null == org.firstinspires.ftc.teamcode.paths.RedPos.Park.p)
            org.firstinspires.ftc.teamcode.paths.RedPos.Park.factory(opMode.hwSuite.drive);

        org.firstinspires.ftc.teamcode.paths.RedPos.Park.p.run();
        return State.SUCCESS;
    }
}
