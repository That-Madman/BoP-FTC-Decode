package org.firstinspires.ftc.teamcode.BehaviorTrees.Actions;

import com.ftcteams.behaviortrees.DebugTree;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BehaviorTrees.BTimeoutNode;
import org.firstinspires.ftc.teamcode.BehaviorTrees.boPMode.BoPMode;

public class Delay extends BTimeoutNode {
    public Delay(double seconds, ElapsedTime timer) {
        super(seconds, timer);
    }

    @Override
    public State tick(DebugTree debug, BoPMode opMode) {
        if (hasTimedOut()){
            return State.SUCCESS;
        }
        return State.RUNNING;
    }
}
