package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions;

import com.ftcteams.behaviortrees.DebugTree;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.BehaviorTrees.QQTimeoutNode;

public class Delay extends QQTimeoutNode {
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
