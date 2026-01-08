package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedNeg;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BMoveToIntakeNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class MoveToIntake extends BMoveToIntakeNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (null ==  org.firstinspires.ftc.teamcode.paths.RedNeg.MoveToIntake.p)
            org.firstinspires.ftc.teamcode.paths.RedNeg.MoveToIntake.factory(opMode.hwSuite.drive);

        if (org.firstinspires.ftc.teamcode.paths.RedNeg.MoveToIntake.p.runAsync()) {
            isFinished = true;
            return State.SUCCESS;
        } else {
            return State.RUNNING;
        }
    }
}
