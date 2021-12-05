package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;

@Disabled
@Autonomous
public class AUTONOMOUS_BLUE_PUT_PARK extends RobotMain358{

    private boolean done = false;

    public void runOpMode() throws InterruptedException {

        TEST_CHASSIS_INITIALIZE();

        waitForStart();
        while (opModeIsActive() && !done) {
            slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            slide(300);
            forward(15, 0.2);                 // go forward a little bit
            slide(1700);                           // lift the slide up
            turn(-90,0.2);
            forward(70, 1);                 // dash!!!

            done = true;
        }
    }
}
