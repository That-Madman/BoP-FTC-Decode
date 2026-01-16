package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class FireAllInBarrel extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        opMode.telemetry.addLine("Shooting...");

        for (int i = 0; i < 4; i++) {
            opMode.hwSuite.flyWheel.flyRun(3000);
            opMode.sleep(125);
            opMode.hwSuite.flyWheel.flyRun(0);

            opMode.hwSuite.bar.incrTargetPosition();
            opMode.sleep(125);
        }

        return State.SUCCESS;
    }
}
