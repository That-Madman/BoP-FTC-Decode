package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BlueNeg;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class MoveBackToFire extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (null == org.firstinspires.ftc.teamcode.paths.BlueNeg.MoveBackToFire.p)
            org.firstinspires.ftc.teamcode.paths.BlueNeg.MoveBackToFire.factory(opMode.hwSuite.drive);

        return (org.firstinspires.ftc.teamcode.paths.BlueNeg.MoveBackToFire.p.runAsync()) ?
                State.SUCCESS : State.RUNNING;
    }
}
