package org.firstinspires.ftc.teamcode.subsystems.pruebaIndexV

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.SubsystemBase
import org.firstinspires.ftc.teamcode.utils.devices.OpMotorEx

class IndexV (hardwareMap: HardwareMap) : SubsystemBase() {
    private val motor = OpMotorEx(hardwareMap, IndexVConstants.Identification.motorId). apply {
        applyConfigurationAndResetEncoder(IndexVConstants.Configuration.motorConfig)
    }
    fun index() = motor.setPower(IndexVConstants.Power.index)
    fun reverse() = motor.setPower(IndexVConstants.Power.reverse)
    fun stop() = motor.stopMotor()
}