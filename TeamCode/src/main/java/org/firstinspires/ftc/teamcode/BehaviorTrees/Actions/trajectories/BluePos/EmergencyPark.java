package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BluePos;

import com.ftcteams.behaviortrees.DebugTree;
import com.ftcteams.behaviortrees.Node;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class EmergencyPark extends BNode {
    @Override
    public Node.State tick(DebugTree debug, BoPMode opMode) {
        //TODO: ADD AN ACTUAL EMERGENCY PARKING SYSTEM
        opMode.telemetry.addLine("We failed");
        opMode.telemetry.update();
        return Node.State.SUCCESS;
    }
}
