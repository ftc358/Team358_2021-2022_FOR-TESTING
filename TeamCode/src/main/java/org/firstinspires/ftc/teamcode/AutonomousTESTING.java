package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class AutonomousTESTING extends RobotMain358{

    private boolean done = false;

    public void runOpMode() throws InterruptedException {

        TEST_CHASSIS_INITIALIZE();

        waitForStart();
        while (opModeIsActive() && !done) {
            turn(90, 0.75);

            done = true;
        }
    }
}
