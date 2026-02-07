package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class FireAllInBarrelBack extends BNode {
    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        opMode.telemetry.addLine("Shooting...");

        opMode.hwSuite.vert.setPos(0.66);
        opMode.hwSuite.flyWheel.flyRun(1850);
        opMode.sleep(1000);

        for (int i = 0; i < 4; i++) {
            opMode.hwSuite.bar.incrTargetPosition();
            opMode.sleep(500);
        }

        opMode.hwSuite.flyWheel.flyRun(0);

        return State.SUCCESS;
    }
}
