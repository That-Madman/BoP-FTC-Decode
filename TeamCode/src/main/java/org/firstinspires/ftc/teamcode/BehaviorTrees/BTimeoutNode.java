package org.firstinspires.ftc.teamcode.BehaviorTrees;

import com.qualcomm.robotcore.util.ElapsedTime;

abstract public class BTimeoutNode extends BNode {
    ElapsedTime timer = new ElapsedTime();
    public double seconds;
    boolean isTimerStarted;

    public BTimeoutNode(double seconds){
        super();
        this.seconds = seconds;
    }
    public boolean hasTimedOut(){
        if (!isTimerStarted){
            timer.reset();
            isTimerStarted = true;
        }
        return timer.seconds() >= seconds;
    }
}
