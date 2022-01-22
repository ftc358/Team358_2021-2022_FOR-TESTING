package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;

@Disabled
@TeleOp
public class ServoTest extends LinearOpMode {
    public CRServo servo1;

    public void runOpMode() throws InterruptedException{
        servo1 = hardwareMap.crservo.get("servo1");

        waitForStart();

        while (opModeIsActive()) {
            servo1.setPower(0);
            while (gamepad1.a) {
                servo1.setPower(0.75);
            } while (gamepad1.b){
                servo1.setPower(-0.75);
            }
        }
    }
}

