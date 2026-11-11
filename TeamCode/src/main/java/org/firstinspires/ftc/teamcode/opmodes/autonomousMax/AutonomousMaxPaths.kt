package org.firstinspires.ftc.teamcode.opmodes.autonomousMax

import com.seattlesolvers.solverslib.geometry.Pose2d
import com.seattlesolvers.solverslib.geometry.Rotation2d
import com.seattlesolvers.solverslib.geometry.Translation2d
import com.seattlesolvers.solverslib.trajectory.Trajectory
import com.seattlesolvers.solverslib.trajectory.TrajectoryConfig
import com.seattlesolvers.solverslib.trajectory.TrajectoryGenerator
import org.firstinspires.ftc.teamcode.constants.FieldConstants
import org.firstinspires.ftc.teamcode.utils.Alliance
import org.firstinspires.ftc.teamcode.utils.Angle
import org.firstinspires.ftc.teamcode.utils.Distance

class AutonomousMaxPaths(alliance: Alliance) {

    class Segment(val heading: Angle, val trajectory: Trajectory)

    private val mirrored = alliance == Alliance.BLUE

    private val startPoint = point(56.0, 8.0)
    private val point1 = point(56.0, 36.0)
    private val point2 = point(29.5321, 36.6553)
    private val point3 = point(30.385, 93.8024)
    private val point4 = point(6.8668, 107.5691)

    val segments: List<Segment> = listOf(
        line(startPoint, point1, reversed = false),
        line(point1, point2, reversed = true),
        line(point2, point3, reversed = true),
        line(point3, point4, reversed = true)
    )

    val start: Pose2d = Pose2d(startPoint, Rotation2d(segments.first().heading.radians))

    private fun point(xInches: Double, yInches: Double): Translation2d {
        val x = Distance.fromInches(xInches).meters
        return Translation2d(
            if (mirrored) FieldConstants.FIELD_WIDTH.meters - x else x,
            Distance.fromInches(yInches).meters
        )
    }

    private fun line(from: Translation2d, to: Translation2d, reversed: Boolean): Segment {
        val direction = to.minus(from)
        val travel = Rotation2d(direction.x, direction.y)
        val heading = if (reversed) travel.rotateBy(Rotation2d.fromDegrees(180.0)) else travel

        val trajectory = TrajectoryGenerator.generateTrajectory(
            Pose2d(from, heading),
            listOf(),
            Pose2d(to, heading),
            TrajectoryConfig(MAX_VELOCITY_MPS, MAX_ACCELERATION_MPS2).setReversed(reversed)
        )
        return Segment(Angle.fromRadians(heading.radians), trajectory)
    }

    companion object {
        const val MAX_VELOCITY_MPS = 0.5
        const val MAX_ACCELERATION_MPS2 = 0.5
    }
}
