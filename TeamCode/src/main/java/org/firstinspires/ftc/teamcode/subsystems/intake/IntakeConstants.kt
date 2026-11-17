package org.firstinspires.ftc.teamcode.subsystems.intake

import com.qualcomm.robotcore.hardware.PIDCoefficients
import com.seattlesolvers.solverslib.controller.wpilibcontroller.SimpleMotorFeedforward
import com.seattlesolvers.solverslib.hardware.motors.Motor
import org.firstinspires.ftc.teamcode.utils.AngularVelocity

import org.firstinspires.ftc.teamcode.utils.configurations.OpMotorExConfiguration
import org.firstinspires.ftc.teamcode.utils.configurations.genericConfigurations.GenericMotorConfiguration
import org.firstinspires.ftc.teamcode.utils.configurations.motorControlModeConfiguration.MotorVelocityModeConfiguration

object IntakeConstants {
    object Identification{

        val intakeId = "intakeMotor"
    }
    object Configuration{

        private val isMotorInverted = false

        private val zeroPowerBehavior = Motor.ZeroPowerBehavior.FLOAT

        private val gearRatio = 1.0/1.0

        private val genericConf = GenericMotorConfiguration()
            .withInverted(org.firstinspires.ftc.teamcode.subsystems.intake.IntakeConstants.Configuration.isMotorInverted)
            .withZeroPowerBehavior(zeroPowerBehavior)
            .withGearRatio(gearRatio)

        private val PID = PIDCoefficients( 1.0,0.0,0.5)
        private val  maxRPM = 400.0
        val feedforward = SimpleMotorFeedforward(1.0,0.0)
        val controlConf = MotorVelocityModeConfiguration()
            .withVelocityCoefficients(PID)
            .withFeedforwardCoefficients(feedforward)

        val config = OpMotorExConfiguration(genericMotorConfiguration =  genericConf, controlConf)
        val targetRPM = AngularVelocity.fromRpm(400.0)
    }
}
