package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.initializeOdom;

import com.ftcteams.behaviortrees.DebugTree;
import com.ftcteams.behaviortrees.Node;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;
import org.firstinspires.ftc.teamcode.resources.Helpers;

public class InitializeOdomRedNeg extends BNode {
    @Override
    public Node.State tick(DebugTree debug, BoPMode opMode) {
        opMode.hwSuite.drive.odometry.setPosition(-68, -15, 0, DistanceUnit.INCH, AngleUnit.DEGREES);

        return
                (Helpers.apprEqual(opMode.hwSuite.drive.odometry.getPosition().getX(), -68, 1) &&
                        Helpers.apprEqual(opMode.hwSuite.drive.odometry.getPosition().getY(), -15, 1) &&
                        Helpers.apprEqual(opMode.hwSuite.drive.odometry.getPosition().getH(), 0, 5)) ?
                        Node.State.SUCCESS : Node.State.FAILURE;
    }
}
