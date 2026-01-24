package org.firstinspires.ftc.teamcode.BehaviorTrees.trees;

import com.ftcteams.behaviortrees.Failover;
import com.ftcteams.behaviortrees.Node;
import com.ftcteams.behaviortrees.Sequence;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.Delay;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.EmergencyPark;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.MoveFrom2ToFire;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.MoveToIntake2;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.MoveToPickup2;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.Park;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Conditions.IsOdomCorrectRedPos;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.initializeOdom.InitializeOdomRedPos;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.MoveStraightToFire;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.FireAllInBarrel;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.MoveToIntake1;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.MoveToPickup1;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.RevUpIntake;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.DisengageIntake;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.MoveFrom1ToFire;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;


public class RedPosTree {

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

   static MoveToIntake1 m1 = new MoveToIntake1();
   static MoveToIntake2 m2 = new MoveToIntake2();

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
                        new MoveToPickup1(),
                        new RevUpIntake(),
                                m1,
                        new DisengageIntake(),
                        new MoveFrom1ToFire(),
                        new FireAllInBarrel(),
                        new MoveToPickup2(),
                        new RevUpIntake(),
//                        new Parallel(2,
                                m2,
//                                new CheckAndIndex(m2)),
                        new MoveFrom2ToFire(),
                        new DisengageIntake(),
                        new Park()),
                new EmergencyPark());
    }
}

/* TREE
?
|  ->
|  |  ?
|  |  |  [InitializeOdomRedPos]
|  |  |  ->
|  |  |  |  [Delay]
|  |  |  |  (IsOdomCorrectRedPos)
|  |  [MoveStraightToFire]
|  |  [FireAllInBarrel]
|  |  [MoveToPickup1]
|  |  [RevUpIntake]
|  |  =2
|  |  |  [MoveToIntake1]
|  |  |  [CheckAndIndex]
|  |  [DisengageIntake]
|  |  [MoveFrom1ToFire]
|  |  [FireAllInBarrel]
|  |  [MoveToPickup2]
|  |  [RevUpIntake]
|  |  =2
|  |  |  [MoveToIntake2]
|  |  |  [CheckAndIndex]
|  |  [MoveFrom2ToFire]
|  |  [DisengageIntake]
|  |  [Park]
|  [EmergencyPark]
 */