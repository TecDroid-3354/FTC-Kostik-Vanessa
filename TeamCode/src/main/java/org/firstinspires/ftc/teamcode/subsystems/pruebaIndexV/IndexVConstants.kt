package org.firstinspires.ftc.teamcode.subsystems.pruebaIndexV

import com.seattlesolvers.solverslib.hardware.motors.Motor
import org.firstinspires.ftc.teamcode.utils.configurations.OpMotorExConfiguration
import org.firstinspires.ftc.teamcode.utils.configurations.genericConfigurations.GenericMotorConfiguration
import org.firstinspires.ftc.teamcode.utils.configurations.motorControlModeConfiguration.MotorPercentageModeConfiguration

object IndexVConstants {

    object Identification {
        const val motorId = "indexerMotor"
    }
    object Configuration {
        const val inverted = false
        val zeroPowerBehavior = Motor.ZeroPowerBehavior.BRAKE
        const val maxPower = 1.0

        private val genericConfiguration = GenericMotorConfiguration()
            .withInverted(inverted)
            .withZeroPowerBehavior()

        private val controlModeConfiguration = MotorPercentageModeConfiguration()
            .withMaxPower(maxPower)

        val motorConfig = OpMotorExConfiguration()
            .withGenericMotorConfiguration(genericConfiguration)
            .withControlModeConfiguration(controlModeConfiguration)
    }
    object Power {
        const val index = 0.7
        const val reverse = -0.5
    }
}