package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.lang.*;

public abstract class RobotMain358 extends LinearOpMode {
    protected DcMotor lf;
    protected DcMotor lb;
    protected DcMotor rf;
    protected DcMotor rb;
    protected DcMotor slideMotor;
    protected CRServo crServo;
    protected CRServo slideServo;
    protected CRServo intakeServo;

    public double driveFactor = 0.7; //for TeleOp
    public long lastTime = System.currentTimeMillis();
    public int timeElapsed = 2000; // this is in milliseconds

    final double DRIVE_FACTOR = 1000;
    final double TURN_FACTOR = 200;

    public void initialize() throws InterruptedException{
        lf = hardwareMap.dcMotor.get("lf");
        lb = hardwareMap.dcMotor.get("lb");
        rf = hardwareMap.dcMotor.get("rf");
        rb = hardwareMap.dcMotor.get("rb");

        slideMotor = hardwareMap.dcMotor.get("slideMotor");
        crServo = hardwareMap.crservo.get("crServo");
        slideServo = hardwareMap.crservo.get("slideServo");
        intakeServo = hardwareMap.crservo.get("intakeServo");

        lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rb.setZeroPowerBehavior(DcMotor. ZeroPowerBehavior.BRAKE);

        rf.setDirection(DcMotor.Direction.REVERSE);
        rb.setDirection(DcMotor.Direction.REVERSE);
    }

    // TeleOp Switch Drive
    public double switchDriveUp(double df){
        if (df == 0.3) {
            return 0.7;
        }
        else if (df == 0.7){
            return 1;
        }
        else if (df == 1){
            return 1;
        }
        return df;
    }

    public double switchDriveDown(double df){
        if (df == 0.3) {
            return 0.3;
        }
        else if (df == 0.7){
            return 0.3;
        }
        else if (df == 1){
            return 0.7;
        }
        return df;
    }

    public void forward (int inch, double power){
        //Reset Encoders
        lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Set Target Position
        lf.setTargetPosition((int) (inch * DRIVE_FACTOR));
        lb.setTargetPosition((int) (inch * DRIVE_FACTOR));
        rf.setTargetPosition((int) (inch * DRIVE_FACTOR));
        rb.setTargetPosition((int) (inch * DRIVE_FACTOR));

        //Set Drive Power
        lf.setPower(power);
        lb.setPower(power);
        rf.setPower(power);
        rb.setPower(power);

        //Set to RUN_TO_POSITION mode
        lf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rb.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (lf.isBusy() && lb.isBusy() && rf.isBusy() && rb.isBusy()){
            //Wait Until Target Position is Reached
        }
    }

    public void turn (int degree, double power){
        //Reset Encoders
        lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Set Target Position
        lf.setTargetPosition((int) (degree * TURN_FACTOR));
        lb.setTargetPosition((int) (degree * TURN_FACTOR));
        rf.setTargetPosition((int) (degree * TURN_FACTOR));
        rb.setTargetPosition((int) (degree * TURN_FACTOR));

        //Set Drive Power
        lf.setPower(power);
        lb.setPower(power);
        rf.setPower(-power);
        rb.setPower(-power);

        //Set to RUN_TO_POSITION mode
        lf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rb.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (lf.isBusy() && lb.isBusy() && rf.isBusy() && rb.isBusy()){
            //Wait Until Target Position is Reached
        }
    }

}
