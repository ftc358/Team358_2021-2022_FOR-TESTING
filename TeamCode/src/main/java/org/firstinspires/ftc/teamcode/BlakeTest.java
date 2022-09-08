package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/*

***This is the code the for Driver Control Period***

These are the controls as of right now.
Feel free to edit these as you edit this code

right joystick --> Moving the robot forward/backward
left joystick --> Making the robot turn left/right
right trigger --> Spinning wheel
right bumper --> moving the linear slide up
left bumper --> moving the linear slide down
a (hold) --> open claw
a (let go) --> close claw


 */

@TeleOp
public class BlakeTest extends MainStuff {
    //declaring motors
    private DcMotor motorLeft;
    private DcMotor motorRight;


    public void runOpMode() throws InterruptedException {
        ROBOT_INITIALIZE();

        waitForStart();

        while (opModeIsActive()) {
            //Turns the robot when corresponding buttons are pressed
            TurnTele();

            //Moves the robot forward/backward when corresponding buttons are pressed
            ForwardTele();

            telemetry.addData("forward speed set to", -gamepad2.right_stick_x);
            telemetry.addData("turn speed set to", gamepad2.left_stick_y);
            telemetry.update();
        }
    }
}