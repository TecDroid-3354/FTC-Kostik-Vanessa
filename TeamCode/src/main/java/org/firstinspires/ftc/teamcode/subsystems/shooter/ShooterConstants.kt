package org.firstinspires.ftc.teamcode.subsystems.shooter

import com.bylazar.configurables.annotations.Configurable
import com.qualcomm.robotcore.hardware.PIDCoefficients
import com.seattlesolvers.solverslib.controller.wpilibcontroller.SimpleMotorFeedforward
import com.seattlesolvers.solverslib.hardware.motors.Motor
import org.firstinspires.ftc.teamcode.utils.configurations.OpMotorExConfiguration
import org.firstinspires.ftc.teamcode.utils.configurations.genericConfigurations.GenericMotorConfiguration
import org.firstinspires.ftc.teamcode.utils.configurations.motorControlModeConfiguration.MotorVelocityModeConfiguration

object ShooterConstants {

    object Identification {
        const val SHOOTER_MOTOR_ID = "shooterMotor"
    }

    object PhysicalCharacteristics {
        const val GEAR_RATIO = 1.0
        const val COUNTS_PER_REV = 28.0
    }

    @Configurable
    object Tunables {
        @JvmField
        var velocityCoefficients = PIDCoefficients(0.001, 0.0, 0.0)
        @JvmField
        var feedforward = SimpleMotorFeedforward(0.0, 0.00036, 0.0)
        @JvmField
        var targetRpm = 4000.0
        @JvmField
        var toleranceRpm = 100.0
        @JvmField
        var inverted = false
    }

    object Configuration {
        private val zeroPowerBehavior = Motor.ZeroPowerBehavior.FLOAT

        private val genericConfiguration = GenericMotorConfiguration()
            .withInverted(Tunables.inverted)
            .withGearRatio(PhysicalCharacteristics.GEAR_RATIO)
            .withTicksPerRev(PhysicalCharacteristics.COUNTS_PER_REV)
            .withZeroPowerBehavior(zeroPowerBehavior)

        val modeConfiguration: MotorVelocityModeConfiguration
            get() = MotorVelocityModeConfiguration()
                .withVelocityCoefficients(Tunables.velocityCoefficients)
                .withFeedforwardCoefficients(Tunables.feedforward)

        val motorConfiguration = OpMotorExConfiguration()
            .withGenericMotorConfiguration(genericConfiguration)
            .withControlModeConfiguration(modeConfiguration)
    }
}
