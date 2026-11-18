package org.firstinspires.ftc.teamcode.subsystems.arm

import com.qualcomm.robotcore.hardware.HardwareMap
import com.qualcomm.robotcore.hardware.configuration.typecontainers.ServoConfigurationType
import org.firstinspires.ftc.teamcode.subsystems.exampleSubsystem.ExampleConstants
import org.firstinspires.ftc.teamcode.utils.devices.OpServoEx

class Arm(hardwareMap: HardwareMap) {

    lateinit var Servo: OpServoEx

    init {
        Servo = OpServoEx(hardwareMap, ArmConstants.Identification.armId)
        Servo.applyConfiguration(ArmConstants.Configuration.servoConfig)
    }

}
