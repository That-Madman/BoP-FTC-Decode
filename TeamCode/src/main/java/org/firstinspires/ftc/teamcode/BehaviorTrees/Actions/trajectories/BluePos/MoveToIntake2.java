package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BluePos;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BMoveToIntakeNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class MoveToIntake2 extends BMoveToIntakeNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (null ==  org.firstinspires.ftc.teamcode.paths.BluePos.MoveToIntake2.p)
            org.firstinspires.ftc.teamcode.paths.BluePos.MoveToIntake2.factory(opMode.hwSuite.drive);

        if (org.firstinspires.ftc.teamcode.paths.BluePos.MoveToIntake2.p.runAsync()) {
            isFinished = true;
            return State.SUCCESS;
        } else {
            return State.RUNNING;
        }
    }
}
