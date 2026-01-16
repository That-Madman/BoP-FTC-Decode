package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions;

import com.ftcteams.behaviortrees.DebugTree;

import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BMoveToIntakeNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.BNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class CheckAndIndex extends BNode {
    BMoveToIntakeNode intake;

    public CheckAndIndex (BMoveToIntakeNode intake) {
        this.intake = intake;
    }

    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        opMode.telemetry.addLine("Intaking...");
        opMode.telemetry.update();

        if (opMode.hwSuite.sCage.ballSense()) {
            opMode.hwSuite.bar.incrTargetPosition();
        }

        return intake.isFinished ? State.SUCCESS : State.RUNNING;
    }
}
