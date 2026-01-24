package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BluePos;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class MoveToIntake1 extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (null ==  org.firstinspires.ftc.teamcode.paths.BluePos.MoveToIntake1.p)
            org.firstinspires.ftc.teamcode.paths.BluePos.MoveToIntake1.factory(opMode.hwSuite.drive);

        do
           if (opMode.hwSuite.sCage.ballSense())
               opMode.hwSuite.bar.incrTargetPosition();
        while (!opMode.isStopRequested() && opMode.opModeIsActive()
                && !org.firstinspires.ftc.teamcode.paths.BluePos.MoveToIntake1.p.runAsync());

        return State.SUCCESS;
    }
}
