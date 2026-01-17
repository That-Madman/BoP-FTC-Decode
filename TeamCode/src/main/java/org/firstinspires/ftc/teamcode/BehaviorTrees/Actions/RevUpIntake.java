package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class RevUpIntake extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        opMode.telemetry.addLine("Reving intake...");
        opMode.hwSuite.sCage.spin(1);
        opMode.hwSuite.bar.engageFreeSpin();
        return State.SUCCESS;
    }
}
