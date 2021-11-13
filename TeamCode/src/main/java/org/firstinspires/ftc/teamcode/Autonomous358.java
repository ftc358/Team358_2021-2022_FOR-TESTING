package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Autonomous358 extends RobotMain358{

    public void runOpMode() throws InterruptedException {

        initialize();

        waitForStart();
        while (opModeIsActive()) {
            forward(10,0.2);

//            turn(90,0.2);
        }
    }
}
