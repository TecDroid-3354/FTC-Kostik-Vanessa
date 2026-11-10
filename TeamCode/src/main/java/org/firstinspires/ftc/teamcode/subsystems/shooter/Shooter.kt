package org.firstinspires.ftc.teamcode.subsystems.shooter

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.command.SubsystemBase
import org.firstinspires.ftc.teamcode.utils.AngularVelocity
import org.firstinspires.ftc.teamcode.utils.devices.OpMotorEx
import java.util.function.BooleanSupplier
import kotlin.math.abs

class Shooter(hardwareMap: HardwareMap): SubsystemBase() {

    private val motor = OpMotorEx(hardwareMap, ShooterConstants.Identification.SHOOTER_MOTOR_ID)
    private var targetVelocity = AngularVelocity.fromRpm(0.0)

    init {
        motor.applyConfigurationAndResetEncoder(ShooterConstants.Configuration.motorConfiguration)
    }

    override fun periodic() {
        motor.applyModeConfiguration(ShooterConstants.Configuration.modeConfiguration)
        if (targetVelocity.rpm == 0.0) motor.stopMotor() else motor.setVelocity(targetVelocity)
    }

    fun spinUpCMD(velocity: AngularVelocity): Command {
        return InstantCommand({ targetVelocity = velocity }, this)
    }

    fun spinUpCMD(): Command {
        return InstantCommand({ targetVelocity = AngularVelocity.fromRpm(ShooterConstants.Tunables.targetRpm) }, this)
    }

    fun stopCMD(): Command {
        return InstantCommand({ targetVelocity = AngularVelocity.fromRpm(0.0) }, this)
    }

    fun isAtSpeed(): BooleanSupplier {
        return BooleanSupplier {
            targetVelocity.rpm != 0.0 &&
                abs(getVelocity().rpm - targetVelocity.rpm) <= ShooterConstants.Tunables.toleranceRpm
        }
    }

    fun getVelocity(): AngularVelocity = motor.getVelocity().get()

    fun getTargetVelocity(): AngularVelocity = targetVelocity
}
