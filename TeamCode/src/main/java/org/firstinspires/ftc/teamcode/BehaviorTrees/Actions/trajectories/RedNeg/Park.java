package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedNeg;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class Park extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (null == org.firstinspires.ftc.teamcode.paths.RedNeg.Park.p)
            org.firstinspires.ftc.teamcode.paths.RedNeg.Park.factory(opMode.hwSuite.drive);

       org.firstinspires.ftc.teamcode.paths.RedNeg.Park.p.run();
       return State.SUCCESS;
    }
}
