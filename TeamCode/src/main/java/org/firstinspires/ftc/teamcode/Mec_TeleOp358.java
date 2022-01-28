package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class Mec_TeleOp358 extends RobotMain358{

    public void runOpMode() throws InterruptedException {

        TEST_CHASSIS_INITIALIZE();

        waitForStart();
        while(opModeIsActive()){

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
            // add telemetry                                                            //
            telemetry.addData("drive factor", driveFactor);                      //
                                                                                        //
            double y = gamepad1.left_stick_y;                                           //
            double x = -gamepad1.left_stick_x;                                           //
            double rx = -gamepad1.right_stick_x;                                         //
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

//            /** CAROUSEL MOTORS **/                                                     //
//            crMotor.setPower(0);                                                        //
//            while (gamepad2.a) {                                                        //
//                crMotor.setPower(-0.4);                                                 //
//            } while (gamepad2.y) {                                                      //
//                crMotor.setPower(0.4);                                                  //
//            }                                                                           //
//                                                                                        //
//            /** INTAKE **/                                                              //
//            intakeServo.setPower(0);                                                    //
//            // in                                                                       //
//            while (gamepad1.right_trigger > 0.2) {                                      //
//                intakeServo.setPower(1);                                                //
//            }                                                                           //
//            // out                                                                      //
//            while (gamepad1.left_trigger > 0.2){                                        //
//                intakeServo.setPower(-0.3);                                             //
//            }                                                                           //
//                                                                                        //
//            /** SLIDE MOTORS **/                                                        //
//            // reset button                                                             //
//            slideMotor.setPower(0.1);                                                     //
//            if (gamepad2.left_bumper && gamepad2.right_bumper) {                        //
//                slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);             //
//                slideMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);                //
//            }                                                                           //
//                                                                                        //
//            // down                                                                     //
//            while (gamepad2.dpad_down) {                                                //
//                if (slideMotor.getCurrentPosition() <= 0){                              //
//                    slideMotor.setPower(0);                                             //
//                } else {                                                                //
//                    slideMotor.setPower(-0.5);                                          //
//                }                                                                       //
//            }                                                                           //
//                                                                                        //
//            // up                                                                       //
//            while (gamepad2.dpad_up) {                                                  //
//                if (slideMotor.getCurrentPosition() >= 1500){                           //
//                    slideMotor.setPower(0);                                             //
//                } else {                                                                //
//                    slideMotor.setPower(0.8);                                           //
//                }                                                                       //
//            }
//
//            /** DISTANCE SENSORS **/
//
//                                                                                        //
//            telemetry.addData("slide", slideMotor.getCurrentPosition());
////            telemetry.addData("black box", blackBox.getPosition());
//            telemetry.update();
//
//            /** Black Box **/                                                           //
//            // in                                                                       //
//            if (gamepad2.left_stick_y == 0 && gamepad2.right_stick_y == 0){
//                blackBox.setPower(0);
//            }
//            else if (gamepad2.left_stick_y < -0.5 && gamepad2.right_stick_y < -0.5) {                                      //
//                blackBox.setPower(0.3);
//            }                                                                           //
//            // out                                                                      //
//            else if (gamepad2.left_stick_y > 0.5 && gamepad2.right_stick_y > 0.5){                                        //
//                blackBox.setPower(-0.3);                                             //
//            }

        }
    }
}
