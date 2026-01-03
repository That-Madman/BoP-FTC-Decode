package org.firstinspires.ftc.teamcode.BehaviorTrees.trees;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import com.ftcteams.behaviortrees.Failover;
import com.ftcteams.behaviortrees.Node;
import com.ftcteams.behaviortrees.Sequence;
import com.ftcteams.behaviortrees.Parallel;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.Delay;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BluePos.EmergencyPark;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BluePos.MoveFrom2ToFire;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BluePos.MoveToIntake2;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BluePos.MoveToPickup2;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BluePos.Park;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Conditions.IsOdomCorrectBluePos;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.initializeOdom.InitializeOdomBluePos;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BluePos.MoveStraightToFire;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.FireAllInBarrel;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BluePos.MoveToIntake1;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BluePos.MoveToPickup1;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.RevUpIntake;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.CheckAndIndex;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.DisengageIntake;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BluePos.MoveFrom1ToFire;

public class BluePosTree {

    public static void factory (Drive d) {
        org.firstinspires.ftc.teamcode.paths.BluePos.MoveStraightToFire.factory(d);
        org.firstinspires.ftc.teamcode.paths.BluePos.MoveToPickup1.factory(d);
        org.firstinspires.ftc.teamcode.paths.BluePos.MoveToIntake1.factory(d);
        org.firstinspires.ftc.teamcode.paths.BluePos.MoveFrom1ToFire.factory(d);
        org.firstinspires.ftc.teamcode.paths.BluePos.MoveToPickup2.factory(d);
        org.firstinspires.ftc.teamcode.paths.BluePos.MoveToIntake2.factory(d);
        org.firstinspires.ftc.teamcode.paths.BluePos.MoveFrom2ToFire.factory(d);
        org.firstinspires.ftc.teamcode.paths.BluePos.Park.factory(d);
    }

   static MoveToIntake1 m1 = new MoveToIntake1();
   static MoveToIntake2 m2 = new MoveToIntake2();

    public static Node root(){
        return new Failover(
                new Sequence(
                        new Failover(
                                new InitializeOdomBluePos(),
                                new Sequence(
                                        new Delay(1, new ElapsedTime()),
                                        new IsOdomCorrectBluePos())),
                        new MoveStraightToFire(),
                        new FireAllInBarrel(),
                        new MoveToPickup1(),
                        new RevUpIntake(),
                        new Parallel(2,
                                m1,
                                new CheckAndIndex(m1)),
                        new DisengageIntake(),
                        new MoveFrom1ToFire(),
                        new FireAllInBarrel(),
                        new MoveToPickup2(),
                        new RevUpIntake(),
                        new Parallel(2,
                                m2,
                                new CheckAndIndex(m2)),
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
|  |  |  [InitializeOdomBluePos]
|  |  |  ->
|  |  |  |  [Delay]
|  |  |  |  (IsOdomCorrectBluePos)
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
