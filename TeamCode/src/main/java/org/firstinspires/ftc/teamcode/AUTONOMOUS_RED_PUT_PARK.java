package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class AUTONOMOUS_RED_PUT_PARK extends RobotMain358{

    private boolean done = false;

    public void runOpMode() throws InterruptedException {

        TEST_CHASSIS_INITIALIZE();

        waitForStart();
        while (opModeIsActive() && !done) {
            slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            slide(300);
            forward(15, 0.2);                 // go forward a little bit
            slide(1400);                           // lift the slide up
            telemetry.addData("slide status", "done");
            telemetry.update();

            forward(2, 0.2);

            telemetry.addData("forward status ", "done");
            telemetry.update();
            intake();

            slide(500);
            turn(90, 0.2);
            forward(70, 0.8);               //dash!!!

            done = true;
        }
    }
}
