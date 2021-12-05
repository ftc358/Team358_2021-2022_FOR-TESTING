package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class B_TeleOp358 extends RobotMain358{

    public void runOpMode() throws InterruptedException {

        TEST_CHASSIS_INITIALIZE();

        waitForStart();
        while(opModeIsActive()){

///////////////////////////////////////////////////////////////////////////////
                                                                             //
            // define slow drive                                             //
            if (gamepad1.right_bumper){                                      //
                if (System.currentTimeMillis() - lastTime > timeElapsed){    //
                    driveFactor = switchDriveUp(driveFactor);                //
                    lastTime = System.currentTimeMillis();                   //
                }                                                            //
            }                                                                //
                                                                             //
            // define slow drive                                             //
            if (gamepad1.left_bumper){                                       //
                if (System.currentTimeMillis() - lastTime > timeElapsed){    //
                    driveFactor = switchDriveDown(driveFactor);              //
                    lastTime = System.currentTimeMillis();                   //
                }                                                            //
            }                                                                //
                                                                             //
            // add telemetry                                                 //
            telemetry.addData("drive factor", driveFactor);           //
                                                                             //
            // define drive power                                            //
            double fwd = gamepad1.left_stick_y;                              //
            double turn = gamepad1.right_stick_x;                            //
                                                                             //
            // set motors to drive power                                     //
            lf.setPower(driveFactor * (fwd - turn));                         //
            lb.setPower(driveFactor * (fwd - turn));                         //
            rf.setPower(driveFactor * (fwd + turn));                         //
            rb.setPower(driveFactor * (fwd + turn));                         //
                                                                             //
            // add telemetry                                                 //
            telemetry.addData("forward power", fwd);                  //
            telemetry.addData("turn power", turn);                    //
                                                                             //
//////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                //
            /** CAROUSEL MOTORS **/                                                             //
            crMotor.setPower(0);                                                                //
            while (gamepad2.a) {                                                                //
                crMotor.setPower(-0.3);                                                         //
            } while (gamepad2.y) {                                                              //
                crMotor.setPower(0.3);                                                          //
            }                                                                                   //
                                                                                                //
                                                                                                //
                                                                                                //
            /** SLIDE MOTORS **/                                                                //
            // reset button                                                                     //
            slideMotor.setPower(0);                                                             //
            if (gamepad2.left_bumper && gamepad2.right_bumper) {                                //
                slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);                     //
                slideMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);                        //
            }                                                                                   //
                                                                                                //
            // down                                                                             //
            while (gamepad2.dpad_down) {                                                        //
                if (slideMotor.getCurrentPosition() <= 0){                                      //
                    slideMotor.setPower(0);                                                     //
                } else if (slideMotor.getCurrentPosition() > 0) {                               //
                    slideMotor.setPower(-0.3);                                                  //
                }                                                                               //
            }                                                                                   //
                                                                                                //
            // up                                                                               //
            while (gamepad2.dpad_up) {                                                          //
                if (slideMotor.getCurrentPosition() >= 1700){                                   //
                    slideMotor.setPower(0);                                                     //
                } else {                                                                        //
                    slideMotor.setPower(0.5);                                                   //
                }                                                                               //
            }                                                                                   //
                                                                                                //
            telemetry.addData("slide encoder", slideMotor.getCurrentPosition());         //
            telemetry.update();                                                                 //
                                                                                                //
                                                                                                //
                                                                                                //
            /** INTAKE **/                                                                      //
            intakeServo.setPower(0);                                                            //
            // out                                                                              //
            while (gamepad2.left_trigger > 0.2) {                                               //
                intakeServo.setPower(0.3);                                                      //
            }                                                                                   //
            // in                                                                               //
            while (gamepad2.right_trigger > 0.2){                                               //
                intakeServo.setPower(-1);                                                       //
            }                                                                                   //
                                                                                                //
//////////////////////////////////////////////////////////////////////////////////////////////////
        }
    }
}
