package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp
public class Mec_TeleOp358 extends RobotMain358{

    public void runOpMode() throws InterruptedException {

        CHASSIS_INITIALIZE();

        waitForStart();
        while(opModeIsActive()){

            runtime.reset();    // Start game timer.

///////////////////////////// Drive Train ////////////////////////////////////////////////
                                                                                        //
            // define slow drive                                                        //
            if (gamepad1.right_bumper){                                                 //
                if (System.currentTimeMillis() - lastTime > timeElapsed){               //
                    driveFactor = switchDriveUp(driveFactor);                           //
                    lastTime = System.currentTimeMillis();                              //
                }                                                                       //
            }                                                                           //
                                                                                        //
            // define slow drive                                                        //
            if (gamepad1.left_bumper){                                                  //
                if (System.currentTimeMillis() - lastTime > timeElapsed){               //
                    driveFactor = switchDriveDown(driveFactor);                         //
                    lastTime = System.currentTimeMillis();                              //
                }                                                                       //
            }                                                                           //
                                                                                        //
                                                                                        //
            double y = gamepad1.left_stick_y;                                           //
            double x = gamepad1.left_stick_x;                                           //
            double rx = gamepad1.right_stick_x;                                         //
                                                                                        //
            double denom = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);       //
            double lfPower = (y + x + rx) / denom;                                      //
            double lbPower = (y - x + rx) / denom;                                      //
            double rfPower = (y - x - rx) / denom;                                      //
            double rbPower = (y + x - rx) / denom;                                      //
                                                                                        //
            lf.setPower(lfPower * driveFactor);                                         //
            lb.setPower(lbPower * driveFactor);                                         //
            rf.setPower(rfPower * driveFactor);                                         //
            rb.setPower(rbPower * driveFactor);                                         //
                                                                                        //
//////////////////////////////////////////////////////////////////////////////////////////
                                                                                        //
            /** CAROUSEL MOTORS **/                                                     //
            crMotor.setPower(0);                                                        //
            while (gamepad2.a) {                                                        //
                crMotor.setPower(-0.45);                                                //
            } while (gamepad2.y) {                                                      //
                crMotor.setPower(0.45);                                                 //
            }                                                                           //
                                                                                        //
            /** INTAKE **/                                                              //
            intakeServo.setPower(0);                                                    //
            // in                                                                       //
            while (gamepad1.right_trigger > 0.2) {                                      //
                intakeServo.setPower(1);                                                //
            }                                                                           //
            // out                                                                      //
            while (gamepad1.left_trigger > 0.2){                                        //
                intakeServo.setPower(-0.3);                                             //
            }                                                                           //
                                                                                        //
            /** SLIDE MOTORS **/                                                        //
            // reset button                                                             //
            slideMotor.setPower(0.1);                                                   //
            if (gamepad2.left_bumper && gamepad2.right_bumper) {                        //
                slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);             //
                slideMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);                //
            }                                                                           //
            // down                                                                     //
            while (gamepad2.dpad_down) {                                                //
                if (slideMotor.getCurrentPosition() <= 0){                              //
                    slideMotor.setPower(0);                                             //
                } else {                                                                //
                    slideMotor.setPower(-0.5);                                          //
                }                                                                       //
            }                                                                           //
            // up                                                                       //
            while (gamepad2.dpad_up) {                                                  //
                if (slideMotor.getCurrentPosition() >= 1500){                           //
                    slideMotor.setPower(0);                                             //
                } else {                                                                //
                    slideMotor.setPower(0.8);                                           //
                }                                                                       //
            }                                                                           //
                                                                                        //
            /** Black Box **/                                                           //
            // in                                                                       //
            if (gamepad2.left_stick_y == 0 && gamepad2.right_stick_y == 0){             //
                blackBox.setPower(0);                                                   //
            }                                                                           //
            else if (gamepad2.left_stick_y < -0.5 && gamepad2.right_stick_y < -0.5) {   //
                blackBox.setPower(0.3);                                                 //
            }                                                                           //
            // out                                                                      //
            else if (gamepad2.left_stick_y > 0.5 && gamepad2.right_stick_y > 0.5){      //
                blackBox.setPower(-0.3);                                                //
            }                                                                           //
                                                                                        //
            //add telemetry                                                             //
            telemetry.addData("drive factor", driveFactor);                      //
            telemetry.addData("slide", slideMotor.getCurrentPosition());         //
            telemetry.update();                                                         //
                                                                                        //
//////////////////////////////////////////////////////////////////////////////////////////
                                                                                        //
            // create gamepad rumble effects                                            //
            if (runtime.seconds() == HALF_TIME)  {
                gamepad1.rumble(300);
                gamepad2.rumble(300);
            } else if (runtime.seconds() == END_GAME) {
                gamepad1.rumble(1000);
                gamepad2.rumble(1000);
            }

//            if (gamepad1.left_bumper) {
//                // Left Bumper is being pressed, so send left and right "trigger" values to left and right rumble motors.
//                gamepad1.rumble(gamepad1.left_trigger, gamepad1.right_trigger, Gamepad.RUMBLE_DURATION_CONTINUOUS);
//
//                // Show what is being sent to rumbles
//                telemetry.addData(">", "Squeeze triggers to control rumbles");
//                telemetry.addData("> : Rumble", "Left: %.0f%%   Right: %.0f%%", gamepad1.left_trigger * 100, gamepad1.right_trigger * 100);
//            } else {
//                // Make sure rumble is turned off when Left Bumper is released (only one time each press)
//                if (!gamepad1.left_bumper) {
//                    gamepad1.stopRumble();
//                }
//
//                //  Prompt for manual rumble action
//                telemetry.addData(">", "Hold Left-Bumper to test Manual Rumble");
//                telemetry.addData(">", "Press A (Cross) for three blips");
//                telemetry.addData(">", "Squeeze right trigger slowly for 1 blip");
//            }

        }
    }
}
