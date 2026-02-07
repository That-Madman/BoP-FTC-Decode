package org.firstinspires.ftc.teamcode.BehaviorTrees.trees;

import com.ftcteams.behaviortrees.Failover;
import com.ftcteams.behaviortrees.Node;
import com.ftcteams.behaviortrees.Sequence;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.Delay;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.FireAllInBarrelBack;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.initializeOdom.InitializeOdomRedNeg;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedNeg.EmergencyPark;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedNeg.MoveToFire;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.RedNeg.Park;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Conditions.IsOdomCorrectRedNeg;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;

public class RedNegTree {

   public static void factory (Drive d) {
       org.firstinspires.ftc.teamcode.paths.RedNeg.MoveToPickup.factory(d);
       org.firstinspires.ftc.teamcode.paths.RedNeg.MoveToIntake.factory(d);
       org.firstinspires.ftc.teamcode.paths.RedNeg.MoveBackToFire.factory(d);
       org.firstinspires.ftc.teamcode.paths.RedNeg.Park.factory(d);

       org.firstinspires.ftc.teamcode.paths.RedNeg.MoveToIntake.factory(d);
   }

    public static Node root() {
        return new Failover(
                new Sequence(
                        new Failover(
                                new InitializeOdomRedNeg(),
                                new Sequence(
                                        new Delay(1, new ElapsedTime()),
                                        new IsOdomCorrectRedNeg())),
                        new MoveToFire(),
                        new FireAllInBarrelBack(),
                        new Park()),
                new EmergencyPark());
    }
}

/* TREE
?
|  ->
|  |  ?
|  |  |  [InitializeOdomRedNeg]
|  |  |  ->
|  |  |  |  [Delay]
|  |  |  |  (IsOdomCorrectRedNeg)
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