package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Test_TeleOp extends RobotMain358{

    public void runOpMode() throws InterruptedException {

        initialize();

        waitForStart();
        while(opModeIsActive()){
//            telemetry.addData("millisecond", System.currentTimeMillis());
//            telemetry.addData("millisecond", lastTime);

            // define slow drive
            if (gamepad1.right_bumper){
                if (System.currentTimeMillis() - lastTime > timeElapsed){
                    driveFactor = switchDriveUp(driveFactor);
                    lastTime = System.currentTimeMillis();
                }
            }

            // define slow drive
            if (gamepad1.left_bumper){
                if (System.currentTimeMillis() - lastTime > timeElapsed){
                    driveFactor = switchDriveDown(driveFactor);
                    lastTime = System.currentTimeMillis();
                }
            }

            // add telemetry
            telemetry.addData("precision status", driveFactor);

            // define drive power
            double leftDrive = gamepad1.left_stick_y;
            double rightDrive = gamepad1.right_stick_y;
            double finalLeft = leftDrive * driveFactor;
            double finalRight = rightDrive * driveFactor;

            // set motors to drive power
            lf.setPower(finalLeft);
            lb.setPower(finalLeft);
            rf.setPower(finalRight);
            rb.setPower(finalRight);

            // add telemetry
            telemetry.addData("left power", finalLeft);
            telemetry.addData("right power", finalRight);

            //slideMotor
            if (gamepad1.dpad_left || gamepad1.dpad_right){ //stay there, but still needs constant power
                slideMotor.setPower(-0.2);
            } else if (gamepad1.dpad_down) { //down
                slideMotor.setPower(0);
            } else if (gamepad1.dpad_up) { //up
                slideMotor.setPower(-0.4);
            }
            telemetry.addData("slide encoder", slideMotor.getCurrentPosition());
            telemetry.update();


            // crServo
            if (gamepad2.x || gamepad2.b){
                crServo.setPower(0);
            } else if (gamepad2.a) {
                crServo.setPower(-1);
            } else if (gamepad2.y) {
                crServo.setPower(1);
            }

            // slideServo
            if (gamepad2.dpad_left || gamepad2.dpad_right){
                slideServo.setPower(0);
            } else if (gamepad2.dpad_up) {
                slideServo.setPower(1);
            } else if (gamepad2.dpad_down) {
                slideServo.setPower(-1);
            }

            // intakeServo
            if (gamepad2.left_bumper && gamepad2.right_bumper){
                intakeServo.setPower(0);
            } else if (gamepad2.left_bumper) {
                intakeServo.setPower(1);
            } else if (gamepad2.right_bumper) {
                intakeServo.setPower(-1);
            }
        }
    }
}
