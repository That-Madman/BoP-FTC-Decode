package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class FireAllInBarrel extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        opMode.telemetry.addLine("Shooting...");

        opMode.hwSuite.flyWheel.flyRun(1650);
        opMode.sleep(1000);

        for (int i = 0; i < 4; i++) {
            opMode.hwSuite.bar.incrTargetPosition();
            opMode.sleep(250);
        }

        opMode.hwSuite.flyWheel.flyRun(0);

        return State.SUCCESS;
    }
}
