package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class RevUpIntake extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        //TODO: ACTUALLY IMPLEMENT
        opMode.telemetry.addLine("Reving intake...");
        return State.SUCCESS;
    }
}
