package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedNeg;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class MoveToIntake extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (null ==  org.firstinspires.ftc.teamcode.paths.RedNeg.MoveToIntake.p)
            org.firstinspires.ftc.teamcode.paths.RedNeg.MoveToIntake.factory(opMode.hwSuite.drive);

        do
           if (opMode.hwSuite.sCage.ballSense())
               opMode.hwSuite.bar.incrTargetPosition();
        while (!opMode.isStopRequested() && opMode.opModeIsActive()
                && !org.firstinspires.ftc.teamcode.paths.RedNeg.MoveToIntake.p.runAsync());

        return State.SUCCESS;
    }
}
