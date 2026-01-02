package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.MoveToIntake1;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.MoveToIntake2;
import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class CheckAndIndex extends BNode {
    public static boolean onFirst = true;

    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        opMode.telemetry.addLine("Intaking...");
        opMode.telemetry.update();

        if (onFirst) {
            if (MoveToIntake1.finished) {
                MoveToIntake1.finished = false;
                onFirst = false;
                return State.SUCCESS;
            } else {
                return State.RUNNING;
            }
        } else {
            if (MoveToIntake2.finished) {
                MoveToIntake2.finished = false;
                onFirst = true;
                return State.SUCCESS;
            } else {
                return State.RUNNING;
            }
        }
    }
}
