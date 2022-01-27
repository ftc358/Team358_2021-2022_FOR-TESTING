package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp
public class TEST_SERVO extends LinearOpMode {

    public CRServo servo1;

    public long lastTime = System.currentTimeMillis();
    public int runTime = 1000;

//    public TouchSensor ts1 = hardwareMap.touchSensor.get("ts1");

    public void runOpMode() throws InterruptedException{

        servo1 = hardwareMap.crservo.get("servo1");

        waitForStart();
        while (opModeIsActive()) {

            /**
             * Timer Method
             */
            servo1.setPower(0);
            if (gamepad1.a) {
                telemetry.addData("hi","hi");
                lastTime = System.currentTimeMillis();
                servo1.setPower(1);

                if (System.currentTimeMillis() - lastTime > runTime) {
                    servo1.setPower(0);
                }
            } else if (gamepad1.b) {
                telemetry.addData("hi","hi");
                lastTime = System.currentTimeMillis();
                servo1.setPower(-1);

                if (System.currentTimeMillis() - lastTime > runTime) {
                    servo1.setPower(0);
                }
            }

            telemetry.addData("current", System.currentTimeMillis());
            telemetry.addData("last", lastTime);
            telemetry.update();

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

