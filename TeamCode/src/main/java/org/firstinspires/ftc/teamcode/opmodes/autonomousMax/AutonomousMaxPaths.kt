package org.firstinspires.ftc.teamcode.opmodes.autonomousMax

import com.seattlesolvers.solverslib.geometry.Pose2d
import com.seattlesolvers.solverslib.geometry.Rotation2d
import com.seattlesolvers.solverslib.trajectory.Trajectory
import com.seattlesolvers.solverslib.trajectory.TrajectoryConfig
import com.seattlesolvers.solverslib.trajectory.TrajectoryGenerator
import org.firstinspires.ftc.teamcode.utils.Alliance
import org.firstinspires.ftc.teamcode.utils.Angle
import org.firstinspires.ftc.teamcode.utils.Distance

class AutonomousMaxPaths(alliance: Alliance) {

    private val mirror = alliance.multiplier

    private val config = TrajectoryConfig(MAX_VELOCITY_MPS, MAX_ACCELERATION_MPS2)

    val start: Pose2d = pose(0.0, 0.0, 0.0)

    val forward: Trajectory = TrajectoryGenerator.generateTrajectory(
        start,
        listOf(),
        pose(48.0, 0.0, 0.0),
        config
    )

    val turn: Angle = Angle.fromDegrees(90.0 * mirror)

    private fun pose(xInches: Double, yInches: Double, headingDegrees: Double) = Pose2d(
        Distance.fromInches(xInches).meters,
        Distance.fromInches(yInches * mirror).meters,
        Rotation2d.fromDegrees(headingDegrees * mirror)
    )

    companion object {
        const val MAX_VELOCITY_MPS = 0.5
        const val MAX_ACCELERATION_MPS2 = 0.5
    }
}
