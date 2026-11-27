package org.firstinspires.ftc.teamcode


import com.pedropathing.math.Pose
import com.pedropathing.paths.Path
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot
import com.qualcomm.robotcore.hardware.HardwareMap
import com.qualcomm.robotcore.hardware.IMU
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.gamepad.GamepadEx
import org.firstinspires.ftc.robotcore.external.Telemetry
import org.firstinspires.ftc.teamcode.subsystems.exampleSubsystem.ExampleSubsystem
import org.firstinspires.ftc.teamcode.utils.Alliance
import org.firstinspires.ftc.teamcode.utils.TecDroidRobot
import org.firstinspires.ftc.teamcode.utils.extensions.circle
import org.firstinspires.ftc.teamcode.utils.extensions.onFalse
import org.firstinspires.ftc.teamcode.utils.extensions.onTrue
import com.seattlesolvers.solverslib.geometry.Pose2d
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles
import org.firstinspires.ftc.teamcode.subsystems.tankDrive.TankDrive
import org.firstinspires.ftc.teamcode.utils.Angle

class Robot(
    private val alliance: Alliance,
    private val hardwareMap: HardwareMap,
    private val controller: GamepadEx,
    telemetry: Telemetry
): TecDroidRobot(telemetry, hardwareMap) {


    private lateinit var exampleSubsystem: ExampleSubsystem
    lateinit var imu: IMU
    lateinit var chassis: TankDrive
    val startingPose : Pose2d


    init {
        subsystemInitialization()
    }

    /* Initialize your subsystems and follower here */
    override fun subsystemInitialization() {
        exampleSubsystem = ExampleSubsystem(hardwareMap)
        imu = hardwareMap.get(IMU::class.java, "imu")
        val revHubOrientationOnRobot = RevHubOrientationOnRobot(
            RevHubOrientationOnRobot.LogoFacingDirection.LEFT,
            RevHubOrientationOnRobot.UsbFacingDirection.UP
        )
        imu.initialize(IMU.Parameters(revHubOrientationOnRobot))
        imu.resetYaw()
        chassis = TankDrive(hardwareMap, {getAngle()}, startingPose)

    }
    fun getAngle(): Angle {
        return Angle.fromDegrees(AngleUnit.normalizeDegrees(imu.robotYawPitchRollAngles.getYaw(
            AngleUnit.DEGREES)))
    }

    /* Runs indefinitely after the init button on the DS is pressed. Stops when play button is pressed */
    override fun initLoop() {}

    /* Initialize your teleop controller commands here */
    override fun initTeleOp() {
        // Chassis default command

        // Build Commands:
        // controller.button().onTrue(Command)

        controller.circle()
            .onTrue(InstantCommand({ exampleSubsystem.enableMotor() }))
            .onFalse(InstantCommand({ exampleSubsystem.disableMotor() }))
    }

    /* Initialize your auto commands here, set chassis alliance and starting pose */
    override fun initAuto(startingPose: Pose) {}

    /* When the teleop ends, declare what to do */
    override fun onEnd() {}

    /* Print telemetry using the pTelemetry object on RobotConstants.Telemetry. It will be printed on both Panels and Driver Hub */
    override fun printTelemetry() {
        pTelemetry.addData("Robot Pose", 1.0)
    }

    /**
     * @return the Pedro's Follower
     */

    /* Common method to follow any path */
    override fun followPathCMD(
        path: Path,
        holdEnd: Boolean,
        maxPower: Double
    ): Command {
        return InstantCommand()
    }
}