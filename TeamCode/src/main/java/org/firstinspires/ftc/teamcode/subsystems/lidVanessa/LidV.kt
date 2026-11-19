package org.firstinspires.ftc.teamcode.subsystems.lidVanessa
import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.command.SubsystemBase
import org.firstinspires.ftc.teamcode.utils.Angle
import org.firstinspires.ftc.teamcode.utils.devices.OpServoEx

class LidV(hardwareMap: HardwareMap): SubsystemBase(){
    val servo: OpServoEx = OpServoEx(hardwareMap, LidVConstants.Identification.servoId)
    init {
        servo.applyConfiguration(LidVConstants.Configuration.servoConfig)
    }
    fun openPosition() {
        servo.runToPosition(Angle.fromDegrees(90.0))
    }
    fun closePosition() {
        servo.runToPosition(Angle.fromDegrees(0.0))
    }
    fun openPositionCMD(): Command {
        return InstantCommand({openPosition()})
    }
    fun closePositionCMD(): Command {
        return InstantCommand({closePosition()})
    }
}
