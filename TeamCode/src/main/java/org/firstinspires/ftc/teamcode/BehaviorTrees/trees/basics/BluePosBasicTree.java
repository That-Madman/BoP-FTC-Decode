package org.firstinspires.ftc.teamcode.BehaviorTrees.trees.basics;

import com.ftcteams.behaviortrees.Failover;
import com.ftcteams.behaviortrees.Node;
import com.ftcteams.behaviortrees.Sequence;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.Delay;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.FireAllInBarrel;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.initializeOdom.InitializeOdomBluePos;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BluePos.EmergencyPark;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BluePos.MoveStraightToFire;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Actions.trajectories.BluePos.Park;
import org.firstinspires.ftc.teamcode.BehaviorTrees.Conditions.IsOdomCorrectBluePos;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;

public class BluePosBasicTree {
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
                        new Park()),
                new EmergencyPark());
    }
}
