package org.firstinspires.ftc.teamcode.subsystems.hood

import com.qualcomm.robotcore.hardware.PIDFCoefficients
import org.firstinspires.ftc.robotcore.external.navigation.Position
import org.firstinspires.ftc.teamcode.utils.configurations.motorControlModeConfiguration.MotorPositionModeConfiguration
import org.firstinspires.ftc.teamcode.utils.configurations.motorControlModeConfiguration.MotorVelocityModeConfiguration

object HoodConstants {
   object Identfication {
       var hoodMotorID = "hoodMotor"
   }
    object Configuration {
        val PIDF = (PIDFCoefficients(1.0,0.0,0.3,0.2))
        val PositionTolerance = (2.0)

        val PositionLimits = ClosedRange<Double>(3.0 , 100.0)

        private var genericConf {

        }
        private var controlModeConfiguration = MotorPositionModeConfiguration()
            .withPositionLimits(PositionLimits)
            .withPIDFCoefficients(PIDF)
            .withPositionTolerance(PositionTolerance)
    }
}