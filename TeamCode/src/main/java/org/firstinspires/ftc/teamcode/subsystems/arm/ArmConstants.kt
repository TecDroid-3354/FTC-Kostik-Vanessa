package org.firstinspires.ftc.teamcode.subsystems.arm

import com.qualcomm.robotcore.hardware.PIDFCoefficients
import org.firstinspires.ftc.teamcode.subsystems.arm.ArmConstants.Identification.armId
import org.firstinspires.ftc.teamcode.utils.Angle
import org.firstinspires.ftc.teamcode.utils.configurations.servoControlModeConfiguration.ServoRunToPositionModeConfiguration

object ArmConstants {

    object Identification{
        val armId = "arm"
    }
    object Configuration {
        val inverted = false
        val GearRatio = 3.0 / 5.0
        val PositionLimits = Angle.fromDegrees(0.0)..Angle.fromDegrees(90.0)
        val PIDFCoefficients = PIDFCoefficients(2.0, 0.0, 0.5, 0.2)
        val PositionTolerance = Angle.fromDegrees(1.0)
        val AbsoluteId = armId
            val servoConfig = ServoRunToPositionModeConfiguration()
            .withInverted(inverted )
            .withGearRatio(GearRatio)
            .withPositionLimits(PositionLimits)
            .withPIDFCoefficients(PIDFCoefficients)
            .withPositionTolerance(PositionTolerance)
            .withAbsoluteId( AbsoluteId)
    }





}