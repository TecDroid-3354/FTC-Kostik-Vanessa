package org.firstinspires.ftc.teamcode.subsystems.Hood

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import org.firstinspires.ftc.teamcode.utils.Angle
import org.firstinspires.ftc.teamcode.utils.devices.OpServoEx

class Hood(hardwareMap: HardwareMap) {

    private val servo: OpServoEx = OpServoEx(
        hardwareMap,
        HoodConstant.Identification.hoodId
    )

    init {
        servo.applyConfiguration(
            HoodConstant.Conf.runToPositionConf
        )
    }

    fun setAngle(targetAngle: Angle) {
        servo.runToPosition(targetAngle)
    }

    fun setAngleCMD(targetAngle: Angle): Command {
        return object : InstantCommand() {
            override fun initialize() {
                setAngle(targetAngle)
            }
        }
    }
}
