package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;
import org.firstinspires.ftc.teamcode.paths.RedPos.MoveToPickup1;

public class MoveToIntake2 extends BNode {
    public static boolean finished = false;

    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (null ==  org.firstinspires.ftc.teamcode.paths.RedPos.MoveToIntake2.p)
            org.firstinspires.ftc.teamcode.paths.RedPos.MoveToIntake2.factory(opMode.hwSuite.drive);

        if (org.firstinspires.ftc.teamcode.paths.RedPos.MoveToIntake2.p.runAsync()) {
            finished = true;
            return State.SUCCESS;
        } else {
            return State.RUNNING;
        }
    }
}
