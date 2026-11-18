package org.firstinspires.ftc.teamcode.opmodes.autonomous

import com.pedropathing.math.Pose
import com.seattlesolvers.solverslib.geometry.Pose2d
import com.seattlesolvers.solverslib.trajectory.Trajectory
import com.seattlesolvers.solverslib.trajectory.TrajectoryConfig
import com.seattlesolvers.solverslib.trajectory.TrajectoryGenerator

object AutonomousTrajectories {


    private val startpoint = mutableListOf<Pose2d>()
    private val point1 = mutableListOf<Pose2d>()
    private val point2 = mutableListOf<Pose2d>()
    private val point3 = mutableListOf<Pose2d>()
    private val point4 = mutableListOf<Pose2d>()

    init {
        startpoint.add(Pose2d(56.0, 8.0, 90.0))
        point1.add(Pose2d(56.0, 36.0, 90.0))
        point2.add(Pose2d(21.3219, 35.8111, -180.0))
        point3.add(Pose2d(23.018, 115.7683, 90.0))
        point4.add(Pose2d(5.5728, 115.2837, -180.0))
    }

    val forward: Trajectory = TrajectoryGenerator.generateTrajectory(
        startpoint,
        point1,
        point2,
        point3,
        point4,
    )

    object Trajectories {

    }
}

//import com.pedropathing.api.Paths.*
//import com.pedropathing.api.Paths
//import com.pedropathing.api.PoseFactory
//import com.pedropathing.math.Pose
//import com.pedropathing.paths.Path
//
//class Paths {
//
//    private val poseFactory = PoseFactory.degrees()
//
//    private val start = poseFactory.of(56.0, 8.0, 90.0)
//    private val path1 = poseFactory.of(56.0, 36.0, 90.0)
//    private val point2 = poseFactory.of(21.3219, 35.8111, -179.6879)
//    private val point3 = poseFactory.of(23.018, 115.7683, 88.7848)
//    private val point4 = poseFactory.of(5.5728, 115.2837, -178.4089)
//
//    fun path1(): Path = Paths.line(start, path1).linear(start, path1)
//
//    fun path2(): Path = Paths.line(path1, point2).tangent()
//
//    fun path3(): Path = Paths.line(point2, point3).tangent()
//
//    fun path4(): Path = Paths.line(point3, point4).tangent()
//}