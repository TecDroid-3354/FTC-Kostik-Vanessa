package org.firstinspires.ftc.teamcode

import com.pedropathing.math.Pose
import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.gamepad.GamepadEx
import org.firstinspires.ftc.robotcore.external.Telemetry
import org.firstinspires.ftc.teamcode.subsystems.pruebaIndexV.IndexV
import org.firstinspires.ftc.teamcode.subsystems.exampleSubsystem.ExampleSubsystem
import org.firstinspires.ftc.teamcode.utils.Alliance
import org.firstinspires.ftc.teamcode.utils.TecDroidRobot
import org.firstinspires.ftc.teamcode.utils.extensions.circle
import org.firstinspires.ftc.teamcode.utils.extensions.onFalse
import org.firstinspires.ftc.teamcode.utils.extensions.onTrue
import org.firstinspires.ftc.teamcode.utils.extensions.a
import org.firstinspires.ftc.teamcode.utils.extensions.whileTrue
import com.seattlesolvers.solverslib.command.StartEndCommand
import org.firstinspires.ftc.teamcode.utils.extensions.b

class Robot(
    private val alliance: Alliance,
    private val hardwareMap: HardwareMap,
    private val controller: GamepadEx,
    telemetry: Telemetry
): TecDroidRobot(telemetry, hardwareMap) {

    val indexer = IndexV(hardwareMap = hardwareMap)

    private lateinit var exampleSubsystem: ExampleSubsystem

    init {
        subsystemInitialization()
    }

    /* Initialize your subsystems and follower here */
    override fun subsystemInitialization() {
        exampleSubsystem = ExampleSubsystem(hardwareMap)
    }

    /* Runs indefinitely after the init button on the DS is pressed. Stops when play button is pressed */
    override fun initLoop() {}

    /* Initialize your teleop controller commands here */
    override fun initTeleOp() {
        // Chassis default command

        // Build Commands:
        // controller.button().onTrue(Command)

        controller.a().whileTrue(
            StartEndCommand(
                { indexer.index() },
                {indexer.stop()}, indexer
            )
        )
        controller.b().whileTrue(
            StartEndCommand(
                { indexer.reverse() },
                { indexer.stop() }, indexer
            )
        )

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
        path: com.pedropathing.paths.Path,
        holdEnd: Boolean,
        maxPower: Double
    ): Command {
        return InstantCommand()
    }
}