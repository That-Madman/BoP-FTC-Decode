package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BluePos;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BMoveToIntakeNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class MoveToIntake1 extends BMoveToIntakeNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (null ==  org.firstinspires.ftc.teamcode.paths.BluePos.MoveToIntake1.p)
            org.firstinspires.ftc.teamcode.paths.BluePos.MoveToIntake1.factory(opMode.hwSuite.drive);

        if (org.firstinspires.ftc.teamcode.paths.BluePos.MoveToIntake1.p.runAsync()) {
            isFinished = true;
            return State.SUCCESS;
        } else {
            return State.RUNNING;
        }
    }
}
