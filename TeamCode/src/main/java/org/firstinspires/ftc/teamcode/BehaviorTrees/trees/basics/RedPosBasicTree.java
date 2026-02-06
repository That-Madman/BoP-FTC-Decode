package org.firstinspires.ftc.teamcode.BehaviorTrees.trees.basics;

import com.ftcteams.behaviortrees.Failover;
import com.ftcteams.behaviortrees.Node;
import com.ftcteams.behaviortrees.Sequence;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.Delay;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.FireAllInBarrel;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.initializeOdom.InitializeOdomRedPos;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.EmergencyPark;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.MoveStraightToFire;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.Park;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Conditions.IsOdomCorrectRedPos;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;

public class RedPosBasicTree {
    public static void factory (Drive d) {
        org.firstinspires.ftc.teamcode.paths.RedPos.MoveStraightToFire.factory(d);
        org.firstinspires.ftc.teamcode.paths.RedPos.MoveToPickup1.factory(d);
        org.firstinspires.ftc.teamcode.paths.RedPos.MoveToIntake1.factory(d);
        org.firstinspires.ftc.teamcode.paths.RedPos.MoveFrom1ToFire.factory(d);
        org.firstinspires.ftc.teamcode.paths.RedPos.MoveToPickup2.factory(d);
        org.firstinspires.ftc.teamcode.paths.RedPos.MoveToIntake2.factory(d);
        org.firstinspires.ftc.teamcode.paths.RedPos.MoveFrom2ToFire.factory(d);
        org.firstinspires.ftc.teamcode.paths.RedPos.Park.factory(d);
    }
    public static Node root(){
        return new Failover(
                new Sequence(
                        new Failover(
                                new InitializeOdomRedPos(),
                                new Sequence(
                                        new Delay(1, new ElapsedTime()),
                                        new IsOdomCorrectRedPos())),
                        new MoveStraightToFire(),
                        new FireAllInBarrel(),
                        new Park()),
                new EmergencyPark());
    }
}
