package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class UnloadBarrel extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        //TODO: IMPLEMENT
        opMode.telemetry.addLine("Shooting...");
        return State.SUCCESS;
    }
}
