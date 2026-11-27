package org.firstinspires.ftc.teamcode.opmodes.autonomous

import com.pedropathing.math.Pose
import com.seattlesolvers.solverslib.geometry.Pose2d
import com.seattlesolvers.solverslib.geometry.Rotation2d
import com.seattlesolvers.solverslib.geometry.Translation2d
import com.seattlesolvers.solverslib.trajectory.TrajectoryGenerator
import org.firstinspires.ftc.teamcode.subsystems.tankDrive.TankDriveConstants

object AutoOne {

    val trajectoryStartPoints = mutableListOf<Pose2d>()
    val secondTrajectoryPoints = mutableListOf<Pose2d>()
    val thirdTrajectoryPoints = mutableListOf<Pose2d>()
    val fourthTrajectoryPoints = mutableListOf<Pose2d>()
    val trajectoryEndPoints = mutableListOf<Pose2d>()

    init{
        trajectoryStartPoints.add(Pose2d(Translation2d(56.0, 8.0), Rotation2d(90.0)))
        trajectoryStartPoints.add(Pose2d(Translation2d(56.0,36.0), Rotation2d(90.0)))

        secondTrajectoryPoints.add(Pose2d(Translation2d(56.0,36.0), Rotation2d(90.0)))
        secondTrajectoryPoints.add(Pose2d(Translation2d(21.3219, 35.8111), Rotation2d(-179.6879)))

        thirdTrajectoryPoints.add(Pose2d(Translation2d(21.3219, 35.8111), Rotation2d(-179.6879)))
        thirdTrajectoryPoints.add(Pose2d(Translation2d(23.018, 115.7683,), Rotation2d(88.7848)))

        trajectoryEndPoints.add(Pose2d(Translation2d(23.018, 115.7683,), Rotation2d(88.7848)))
        trajectoryEndPoints.add(Pose2d(Translation2d(5.5728, 115.2837,), Rotation2d(-178.4089)))

    }
    object Trajectory{

    }

}