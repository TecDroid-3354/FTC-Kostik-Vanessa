package org.firstinspires.ftc.teamcode.subsystems.arm

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import org.firstinspires.ftc.teamcode.subsystems.arm.ArmConstants.Positions.deployed
import org.firstinspires.ftc.teamcode.subsystems.arm.ArmConstants.Positions.closed
import org.firstinspires.ftc.teamcode.utils.devices.OpServoEx

class Arm(hardwareMap: HardwareMap) {

    lateinit var Servo: OpServoEx

    init {
        Servo = OpServoEx(hardwareMap, ArmConstants.Identification.armId)
        Servo.applyConfiguration(ArmConstants.Configuration.servoConfig)
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
