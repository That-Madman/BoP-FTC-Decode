package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class EmergencyPark extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        //TODO: ADD AN ACTUAL EMERGENCY PARKING SYSTEM
        opMode.telemetry.addLine("We failed");
        return State.SUCCESS;
    }
}
