package org.firstinspires.ftc.teamcode.BehaviorTrees.trees;

import com.ftcteams.behaviortrees.Failover;
import com.ftcteams.behaviortrees.Node;
import com.ftcteams.behaviortrees.Sequence;
import com.ftcteams.behaviortrees.Parallel;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.Delay;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.EmergencyPark;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Conditions.IsOdomCorrectRedPos;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.initializeOdom.InitializeOdomRedPos;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.MoveStraightToFire;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.UnloadBarrel;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.MoveToIntake1;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.MoveToPickup;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.RevUpIntake;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.CheckAndIndex;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.DisengageIntake;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedPos.MoveFrom1ToFire;


public class RedPosTree {
    public static Node root(){
        return new Failover(
                new Sequence(
                        new Failover(
                                new InitializeOdomRedPos(),
                                new Sequence(
                                        new Delay(1, new ElapsedTime()),
                                        new IsOdomCorrectRedPos())),
                        new MoveStraightToFire(),
                        new UnloadBarrel(),
                        new MoveToPickup(),
                        new RevUpIntake(),
                        new Parallel(2,
                                new MoveToIntake1(),
                                new CheckAndIndex()),
                        new DisengageIntake(),
                        new MoveFrom1ToFire(),
                        new UnloadBarrel()),
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
|  |  |  |  [IsOdomCorrectRedPos]
|  |  [MoveStraightToFire]
|  |  [UnpatternedFire]
|  |  [MoveToPickup]
|  |  [RevUpIntake]
|  |  =2
|  |  |  [MoveToIntake1]
|  |  |  [CheckAndIndex]
|  |  [DisengageIntake]
|  |  [MoveFrom1ToFire]
|  |  [UnpatternedFire]
|  [EmergencyPark]
 */