package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class AUTONOMOUS_BLUE_RIGHT extends RobotMain358{

    private boolean done = false;

    public void runOpMode() throws InterruptedException {

        TEST_CHASSIS_INITIALIZE();

        waitForStart();
        while (opModeIsActive() && !done) {
            slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            forward(10, 0.2);                 // go forward a little bit
            turn(90, 0.2);                  // turn right
            forward(11,0.2);                  // go towards the carousel

            carousel("blue");                                  // turn the carousel

            forward(-5, 0.2);                 // back off a little bit
            turn(-90, 0.2);                 // return to facing front

            forward(15, 0.3);                 // go forward a little bit
            turn(-80,0.2);                  // face towards the crater

            slide(500);                           // lift the slide up
            forward(90, 1);                 // dash!!!

            done = true;
        }
    }
}
