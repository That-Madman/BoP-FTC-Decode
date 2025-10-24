package org.firstinspires.ftc.teamcode.BehaviorTrees;

import com.ftcteams.behaviortrees.DebugTree;
import com.ftcteams.behaviortrees.Node;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

abstract public class BNode extends Node {
    @Override
    public State tick(DebugTree debug, Object obj) {
        return tick(debug, (OpMode)obj);
    }
    abstract public State tick(DebugTree debug, OpMode opMode);
}
