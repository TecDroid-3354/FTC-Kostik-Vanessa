
package org.firstinspires.ftc.teamcode.subsystems.Hood

import org.firstinspires.ftc.teamcode.utils.Angle
import org.firstinspires.ftc.teamcode.utils.configurations.OpMotorExConfiguration
import org.firstinspires.ftc.teamcode.utils.configurations.OpServoExConfiguration
import org.firstinspires.ftc.teamcode.utils.configurations.servoControlModeConfiguration.ServoRunToPositionModeConfiguration
import org.firstinspires.ftc.teamcode.utils.devices.OpServoEx

object HoodConstant {
    object Identification {
        const val hoodId = "hoodMotor"
    }
    object Conf{
        private val gearRatio = (1.2/1.0)
        private val isInverted = false
        private val positionTolerance = Angle.fromDegrees(0.1)
        private val MinDegrees = Angle.fromDegrees(90.0)
        private val MaxDegrees = Angle.fromDegrees(180.0)
        val runToPositionConf = ServoRunToPositionModeConfiguration()
            .withInverted(isInverted)
            .withPositionLimits(MaxDegrees..MinDegrees)
            .withPositionTolerance(positionTolerance)
            .withGearRatio(gearRatio)
        val servoConf = OpServoExConfiguration()
            .withServoModeConfiguration(runToPositionConf)

    }
}