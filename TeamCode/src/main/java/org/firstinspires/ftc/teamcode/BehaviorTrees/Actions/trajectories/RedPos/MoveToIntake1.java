package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class MoveToIntake1 extends BNode {
    public static boolean finished = false;

    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (null ==  org.firstinspires.ftc.teamcode.paths.RedPos.MoveToIntake1.p)
            org.firstinspires.ftc.teamcode.paths.RedPos.MoveToIntake1.factory(opMode.hwSuite.drive);

        if (org.firstinspires.ftc.teamcode.paths.RedPos.MoveToIntake1.p.runAsync()) {
            finished = true;
            return State.SUCCESS;
        } else {
            return State.RUNNING;
        }
    }
}
