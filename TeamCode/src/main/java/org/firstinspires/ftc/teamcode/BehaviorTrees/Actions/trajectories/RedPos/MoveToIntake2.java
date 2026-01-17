package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BMoveToIntakeNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;
import org.firstinspires.ftc.teamcode.paths.RedPos.MoveToPickup1;

public class MoveToIntake2 extends BMoveToIntakeNode {

    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (null ==  org.firstinspires.ftc.teamcode.paths.RedPos.MoveToIntake2.p)
            org.firstinspires.ftc.teamcode.paths.RedPos.MoveToIntake2.factory(opMode.hwSuite.drive);

//        if (org.firstinspires.ftc.teamcode.paths.RedPos.MoveToIntake2.p.runAsync()) {
        org.firstinspires.ftc.teamcode.paths.RedPos.MoveToIntake2.p.run();
            isFinished = true;
            return State.SUCCESS;
//        } else {
//            return State.RUNNING;
//        }
    }
}
