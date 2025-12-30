package org.firstinspires.ftc.teamcode.BehaviorTrees.Conditions;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;
import org.firstinspires.ftc.teamcode.resources.Helpers;

public class IsOdomCorrectRedPos extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        return
                (Helpers.apprEqual(opMode.hwSuite.drive.odometry.getPosition().getX(), 52, 1) &&
                        Helpers.apprEqual(opMode.hwSuite.drive.odometry.getPosition().getY(), -52, 1) &&
                        Helpers.apprEqual(opMode.hwSuite.drive.odometry.getPosition().getH(), -45, -5)) ?
                State.SUCCESS : State.FAILURE;
    }
}
