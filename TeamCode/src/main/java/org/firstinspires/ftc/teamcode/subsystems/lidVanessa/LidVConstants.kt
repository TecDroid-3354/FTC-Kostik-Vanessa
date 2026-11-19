package org.firstinspires.ftc.teamcode.subsystems.lidVanessa
import com.qualcomm.robotcore.hardware.PIDFCoefficients
import org.firstinspires.ftc.teamcode.utils.Angle
//import org.firstinspires.ftc.teamcode.utils.configurations.OpServoExConfiguration
import org.firstinspires.ftc.teamcode.utils.configurations.servoControlModeConfiguration.ServoRunToPositionModeConfiguration
object LidVConstants {
    object Identification {
        const val servoId = "simpleServo"
    }
    object Configuration {
        const val inverted = false
        const val maxPower = 1.0
        var gearRatio = 0.5
        var limits = Angle.fromDegrees(0.0)..Angle.fromDegrees(90.0)
        var lidTolerance = Angle.fromDegrees(91.0)
        var CoefficientsPIDF = PIDFCoefficients(1.0,0.0,0.5,0.0)
        val servoConfig = ServoRunToPositionModeConfiguration()
            .withInverted(inverted)
            .withGearRatio(gearRatio)
            .withAbsoluteId(Identification.servoId)
            .withPositionLimits(limits)
            .withPIDFCoefficients(CoefficientsPIDF)
            .withPositionTolerance(lidTolerance)
    }
}