package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class ritaAutoTest extends LinearOpMode {
    DcMotor leftDrive;
    DcMotor rightDrive;

    public void runOpMode() {

        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");

        waitForStart();

        while(opModeIsActive()){
            leftDrive.setPower(0);
            rightDrive.setPower(0);
            leftDrive.

        }
    }
}
