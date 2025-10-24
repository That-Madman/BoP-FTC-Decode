package org.firstinspires.ftc.teamcode.BehaviorTrees;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BehaviorTrees.QQNode;

abstract public class QQTimeoutNode extends QQNode {
    ElapsedTime timer = new ElapsedTime();
    public double seconds;
    boolean isTimerStarted;

    public QQTimeoutNode(double seconds){
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
