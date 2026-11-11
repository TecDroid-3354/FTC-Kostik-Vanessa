package org.firstinspires.ftc.teamcode.opmodes.autonomousMax

import androidx.core.util.Supplier
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver
import com.seattlesolvers.solverslib.command.CommandOpMode
import com.seattlesolvers.solverslib.command.SequentialCommandGroup
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit
import org.firstinspires.ftc.teamcode.subsystems.tankDrive.TankDrive
import org.firstinspires.ftc.teamcode.utils.Alliance
import org.firstinspires.ftc.teamcode.utils.Angle
import org.firstinspires.ftc.teamcode.utils.devices.OpMotorEx

open class AutonomousMaxBuilder(private val alliance: Alliance) : CommandOpMode() {

    private lateinit var pinpoint: GoBildaPinpointDriver
    private lateinit var drive: TankDrive

    override fun initialize() {
        super.reset()
        OpMotorEx.clearRegistry()

        pinpoint = hardwareMap.get(GoBildaPinpointDriver::class.java, PINPOINT_ID)
        pinpoint.resetPosAndIMU()

        val paths = AutonomousMaxPaths(alliance)
        drive = TankDrive(
            hardwareMap,
            Supplier { Angle.fromRadians(pinpoint.getHeading(AngleUnit.RADIANS)) },
            paths.start
        )

        val autonomousCommand = SequentialCommandGroup(
            drive.ramsetteCommand(paths.forward),
            drive.turnToAngle(paths.turn)
        )

        waitForStart()
        autonomousCommand.schedule()
    }

    override fun run() {
        pinpoint.update()
        super.run()
        OpMotorEx.updateAll()
    }

    companion object {
        const val PINPOINT_ID = "pinpoint"
    }
}
