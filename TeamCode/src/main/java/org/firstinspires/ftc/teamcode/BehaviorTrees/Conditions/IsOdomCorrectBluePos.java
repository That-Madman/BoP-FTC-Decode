package org.firstinspires.ftc.teamcode.BehaviorTrees.Conditions;

import com.ftcteams.behaviortrees.DebugTree;
import com.ftcteams.behaviortrees.Node;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;
import org.firstinspires.ftc.teamcode.resources.Helpers;

public class IsOdomCorrectBluePos extends BNode {
    @Override
    public Node.State tick(DebugTree debug, BoPMode opMode) {
        return
                (Helpers.apprEqual(opMode.hwSuite.drive.odometry.getPosition().getX(), 52, 1) &&
                        Helpers.apprEqual(opMode.hwSuite.drive.odometry.getPosition().getY(), 52, 1) &&
                        Helpers.apprEqual(opMode.hwSuite.drive.odometry.getPosition().getH(), 45, 5)) ?
                        Node.State.SUCCESS : Node.State.FAILURE;
    }
}
