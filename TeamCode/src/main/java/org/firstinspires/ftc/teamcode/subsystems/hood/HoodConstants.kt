package org.firstinspires.ftc.teamcode.subsystems.hood

import com.qualcomm.robotcore.hardware.PIDFCoefficients
import com.seattlesolvers.solverslib.hardware.motors.Motor
import org.firstinspires.ftc.teamcode.utils.Angle
import org.firstinspires.ftc.teamcode.utils.configurations.OpMotorExConfiguration
import org.firstinspires.ftc.teamcode.utils.configurations.genericConfigurations.GenericMotorConfiguration
import org.firstinspires.ftc.teamcode.utils.configurations.motorControlModeConfiguration.MotorPositionModeConfiguration

object HoodConstants {

    object Identification {
        const val HOOD_MOTOR_ID = "hoodMotor"
    }

    object PhysicalCharacteristics {
        const val GEAR_RATIO = 1.0
        const val COUNTS_PER_REV = 28.0
    }

    object Configuration {
        const val inverted = false
        val zeroPowerBehavior = Motor.ZeroPowerBehavior.BRAKE

        val PIDF = PIDFCoefficients(1.0, 0.0, 0.3, 0.2)
        val POSITION_TOLERANCE = Angle.fromDegrees(2.0)
        val POSITION_LIMITS = Angle.fromDegrees(3.0)..Angle.fromDegrees(100.0)

        private val genericConfiguration = GenericMotorConfiguration()
            .withInverted(inverted)
            .withZeroPowerBehavior(zeroPowerBehavior)
            .withGearRatio(PhysicalCharacteristics.GEAR_RATIO)
            .withTicksPerRev(PhysicalCharacteristics.COUNTS_PER_REV)

        private val controlModeConfiguration = MotorPositionModeConfiguration()
            .withPIDFCoefficients(PIDF)
            .withPositionTolerance(POSITION_TOLERANCE.rotations)
            .withPositionLimits(POSITION_LIMITS)

        val motorConfig = OpMotorExConfiguration()
            .withGenericMotorConfiguration(genericConfiguration)
            .withControlModeConfiguration(controlModeConfiguration)
    }
}
