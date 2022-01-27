package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp
public class TEST_SERVO extends LinearOpMode {

    public CRServo servo1 = hardwareMap.crservo.get("servo1");

    public long lastTime = System.currentTimeMillis();
    public int runTime = 500;

//    public TouchSensor ts1 = hardwareMap.touchSensor.get("ts1");

    public void runOpMode() throws InterruptedException{

        waitForStart();
        while (opModeIsActive()) {

            /**
             * Timer Method
             */
            if (System.currentTimeMillis() - lastTime < runTime) {
                servo1.setPower(0);
            } else if (gamepad1.a) {
                lastTime = System.currentTimeMillis();
                servo1.setPower(0.5);
            } else if (gamepad1.b) {
                lastTime = System.currentTimeMillis();
                servo1.setPower(-0.5);
            }

//            /**
//             * Touch Sensor Method
//             */
//            if (ts1.isPressed() == true) {
//                servo1.setPower(0);
//            } else if (gamepad1.a) {
//                servo1.setPower(0.5);
//            } else if (gamepad1.b) {
//                servo1.setPower(-0.5);
//            }

            /**
             * Gyro Method
             */



        }
    }
}

