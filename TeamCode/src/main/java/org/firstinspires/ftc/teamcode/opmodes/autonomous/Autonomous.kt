package org.firstinspires.ftc.teamcode.opmodes.autonomous

import com.pedropathing.api.Paths
import com.pedropathing.api.PoseFactory
import com.pedropathing.paths.Path
import org.firstinspires.ftc.teamcode.utils.Alliance

class autonomousDavidPaths(alliance: Alliance) {
    private val poseFactory = PoseFactory.degrees()

    private val start = poseFactory.of(56.0, 8.0, 90.0)
    private val path1 = poseFactory.of(56.0, 36.0, 90.0)
    private val point2 = poseFactory.of(21.3219, 35.8111, -179.6879)
    private val point3 = poseFactory.of(23.018, 115.7683, 88.7848)
    private val point4 = poseFactory.of(5.5728, 115.2837, -178.4089)

    fun path1(): Path = Paths.line(start, path1).linear(start, path1)

    fun path2(): Path = Paths.line(path1, point2).tangent()

    fun path3(): Path = Paths.line(point2, point3).tangent()

    fun path4(): Path = Paths.line(point3, point4).tangent()
}

