package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Autonomous358 extends RobotMain358{

    private boolean done = false;

    public void runOpMode() throws InterruptedException {

        TEST_CHASSIS_INITIALIZE();

        waitForStart();
        while (opModeIsActive() && !done) {
            forward(30, 0.3);
            turn(90,0.3);
            forward(30, 0.3);
            turn(90,0.3);
            forward(30, 0.3);
            turn(90,0.3);
            forward(30, 0.3);
            turn(90,0.3);
            done = true;
        }
    }
}
