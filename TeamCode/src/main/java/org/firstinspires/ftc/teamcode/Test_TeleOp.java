package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class Test_TeleOp extends LinearOpMode{

    public DcMotor lf;
    public DcMotor lb;
    public DcMotor rf;
    public DcMotor rb;

    public final double slowDriveSpeed = 0.2;
//    public final double drive_threshold = 0.5;
    public boolean precision = false;

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
        while(opModeIsActive()){

            // define slow drive
            if (gamepad1.right_bumper){
                if (precision) {
                    precision = false;
                }
                else if (!precision){
                    precision = true;
                }
            }

            telemetry.addData("precision status", precision);
            telemetry.update();


            // define drive power
            double leftDrive = gamepad1.left_stick_y;
            double rightDrive = gamepad1.right_stick_y;

            // set left motors to left drive power
            if(precision) {
                lf.setPower(slowDriveSpeed);
                lb.setPower(slowDriveSpeed);
            }else{
                lf.setPower(leftDrive);
                lb.setPower(leftDrive);
            }

            telemetry.addData("left power", leftDrive);
            telemetry.addData("right power", rightDrive);
            telemetry.update();

        }
    }
}
