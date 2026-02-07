package org.firstinspires.ftc.teamcode.BehaviorTrees.trees;

import com.ftcteams.behaviortrees.Failover;
import com.ftcteams.behaviortrees.Node;
import com.ftcteams.behaviortrees.Parallel;
import com.ftcteams.behaviortrees.Sequence;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.Delay;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.FireAllInBarrel;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.RevUpIntake;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.initializeOdom.InitializeOdomBlueNeg;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BlueNeg.EmergencyPark;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BlueNeg.MoveBackToFire;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BlueNeg.MoveToIntake;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BlueNeg.MoveToPickup;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BlueNeg.Park;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Conditions.IsOdomCorrectBlueNeg;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;

public class BlueNegTree {

    public static void factory (Drive d) {
        org.firstinspires.ftc.teamcode.paths.BlueNeg.MoveToPickup.factory(d);
        org.firstinspires.ftc.teamcode.paths.BlueNeg.MoveToIntake.factory(d);
        org.firstinspires.ftc.teamcode.paths.BlueNeg.MoveBackToFire.factory(d);
        org.firstinspires.ftc.teamcode.paths.BlueNeg.Park.factory(d);
    }

    static MoveToIntake m = new MoveToIntake();

    public static Node root() {
        return new Failover(
                new Sequence(
                        new Failover(
                                new InitializeOdomBlueNeg(),
                                new Sequence(
                                        new Delay(1, new ElapsedTime()),
                                        new IsOdomCorrectBlueNeg())),
                        new FireAllInBarrel(),
                        new MoveToPickup(),
                        new Park()),
                new EmergencyPark());
    }
}

/* TREE
?
|  ->
|  |  ?
|  |  |  [InitializeOdomBlueNeg]
|  |  |  ->
|  |  |  |  [Delay]
|  |  |  |  (IsOdomCorrectBlueNeg)
|  |  [FireAllInBarrel]
|  |  [MoveToPickup]
|  |  [RevUpIntake]
|  |  =2
|  |  |  [MoveToIntake]
|  |  |  [CheckAndIndex]
|  |  [MoveBackToFire]
|  |  [FireAllInBarrel]
|  |  [Park]
|  [EmergencyPark]
 */
