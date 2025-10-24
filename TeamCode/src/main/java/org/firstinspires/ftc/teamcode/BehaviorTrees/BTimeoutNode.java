package org.firstinspires.ftc.teamcode.BehaviorTrees;

import com.qualcomm.robotcore.util.ElapsedTime;

abstract public class BTimeoutNode extends BNode {
    ElapsedTime timer;
    public double seconds;
    boolean isTimerStarted;
    public double startTime;

    public BTimeoutNode(double seconds, ElapsedTime timer){
        super();
        this.seconds = seconds;
        this.timer = timer;
    }
    public boolean hasTimedOut(){
        if (!isTimerStarted){
            startTime = timer.seconds();
            isTimerStarted = true;
        }
        return timer.seconds() >= seconds;
    }
}
