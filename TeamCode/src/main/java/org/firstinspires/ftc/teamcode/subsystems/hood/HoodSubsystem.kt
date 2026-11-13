package org.firstinspires.ftc.teamcode.subsystems.hood

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.command.SubsystemBase
import com.seattlesolvers.solverslib.command.WaitUntilCommand
import org.firstinspires.ftc.teamcode.utils.Angle
import org.firstinspires.ftc.teamcode.utils.devices.OpMotorEx

class HoodSubsystem(hardwareMap: HardwareMap): SubsystemBase() {

    private val motor = OpMotorEx(hardwareMap, HoodConstants.Identification.HOOD_MOTOR_ID)

    init {
        motor.applyConfigurationAndResetEncoder(HoodConstants.Configuration.motorConfig)
    }

    fun setAngle(angle: Angle) {
        motor.setAngle(angle)
    }

    fun getAngle(): Angle = motor.getPosition().get()

    fun isAtTarget(): Boolean = motor.isAtPositionTarget().asBoolean

    fun setAngleCMD(angle: Angle): Command {
        return InstantCommand({ setAngle(angle) }, this)
            .andThen(WaitUntilCommand(motor.isAtPositionTarget()))
    }
}
