package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.lang.*;

// TODO: change to autonomous

@TeleOp
public class Test_TeleOp extends LinearOpMode{

    public DcMotor lf;
    public DcMotor lb;
    public DcMotor rf;
    public DcMotor rb;
    //TODO: put these declarations into a new class

    public double driveFactor = 0.3;
    public long lastTime = System.currentTimeMillis();
    public int timeElapsed = 2000; // this is in milliseconds

    public void runOpMode() throws InterruptedException {

        lf = hardwareMap.dcMotor.get("lf");
        lb = hardwareMap.dcMotor.get("lb");
        rf = hardwareMap.dcMotor.get("rf");
        rb = hardwareMap.dcMotor.get("rb");

        lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        rf.setDirection(DcMotor.Direction.REVERSE);
        rb.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()) {

//            telemetry.addData("millisecond", System.currentTimeMillis());
//            telemetry.addData("millisecond", lastTime);

            // define slow drive
            if (gamepad1.right_bumper){
                if (System.currentTimeMillis() - lastTime > timeElapsed){
                    driveFactor = switchDrive(driveFactor);
                    lastTime = System.currentTimeMillis();
                }
            }

            // add telemetry
            telemetry.addData("precision status", driveFactor);

            // define drive power
            double leftDrive = gamepad1.left_stick_y;
            double rightDrive = gamepad1.right_stick_y;
            double finalLeft = leftDrive * driveFactor;
            double finalRight = rightDrive * driveFactor;

            // set motors to drive power
            lf.setPower(finalLeft);
            lb.setPower(finalLeft);
            rf.setPower(finalRight);
            rb.setPower(finalRight);

            // add telemetry
            telemetry.addData("left power", finalLeft);
            telemetry.addData("right power", finalRight);
            telemetry.update();

        }
    }

    public double switchDrive(double df){
        if (df == 0.3) {
            return 1;
        }
        else if (df == 1){
            return 0.3;
        }
        return df;
    }

}
