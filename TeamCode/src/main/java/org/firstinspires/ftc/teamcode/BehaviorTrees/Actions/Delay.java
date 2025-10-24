package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions;

import com.ftcteams.behaviortrees.DebugTree;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BTimeoutNode;

public class Delay extends BTimeoutNode {
    public Delay(double seconds) {
        super(seconds);
    }

    @Override
    public State tick(DebugTree debug, OpMode opMode) {
        if (hasTimedOut()){
            return State.SUCCESS;
        }
        return State.RUNNING;
    }
}
