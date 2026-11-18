package org.firstinspires.ftc.teamcode.subsystems.lid

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import org.firstinspires.ftc.teamcode.subsystems.lid.LidConstants.Positions.deployed
import org.firstinspires.ftc.teamcode.subsystems.lid.LidConstants.Positions.closed
import org.firstinspires.ftc.teamcode.utils.devices.OpServoEx

class Lid(hardwareMap: HardwareMap) {

    lateinit var Servo: OpServoEx

    init {
        Servo = OpServoEx(hardwareMap, LidConstants.Identification.lidId)
        Servo.applyConfiguration(LidConstants.Configuration.servoConfig)
    }
    private fun deploy() {
        Servo.runToPosition(deployed)
    }
    private fun close() {
        Servo.runToPosition(closed)
    }

    fun deployCMD() : Command{
        return InstantCommand({deploy()})
    }

    fun closeCMD() : Command{
        return InstantCommand({close()})
    }
}