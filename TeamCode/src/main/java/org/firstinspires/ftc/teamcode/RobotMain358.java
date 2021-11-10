package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;

public abstract class RobotMain358 extends LinearOpMode {
    protected DcMotor lf;
    protected DcMotor lb;
    protected DcMotor rf;
    protected DcMotor rb;
    protected CRServo carouselServo;
    protected CRServo slideServo;

    public double driveFactor = 1; //for TeleOp
    public long lastTime = System.currentTimeMillis();
    public int timeElapsed = 2000; // this is in milliseconds

    final double FORWARD_DRIVE_FACTOR = 1;
    final double TURN_DRIVE_FACTOR = 1;

    public void initialize() throws InterruptedException{
        lf = hardwareMap.dcMotor.get("lf");
        lb = hardwareMap.dcMotor.get("lb");
        rf = hardwareMap.dcMotor.get("rf");
        rb = hardwareMap.dcMotor.get("rb");

        carouselServo = hardwareMap.crservo.get("carouselServo");
        slideServo = hardwareMap.crservo.get("slideServo");

        lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        rf.setDirection(DcMotor.Direction.REVERSE);
        rb.setDirection(DcMotor.Direction.REVERSE);
    }

    // TeleOp Switch Drive
    public double switchDrive(double df){
        if (df == 0.3) {
            return 0.7;
        }
        else if (df == 0.7){
            return 1;
        }
        else if (df == 1){
            return 0.3;
        }
        return df;
    }

    public void forward (int GO_DISTANCE){
        //Reset Encoders
        lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Set Target Position
        lf.setTargetPosition((int) ((lf.getCurrentPosition() + GO_DISTANCE) * FORWARD_DRIVE_FACTOR));
        lb.setTargetPosition((int) ((lf.getCurrentPosition() + GO_DISTANCE) * FORWARD_DRIVE_FACTOR));
        rf.setTargetPosition((int) ((lf.getCurrentPosition() + GO_DISTANCE) * FORWARD_DRIVE_FACTOR));
        rb.setTargetPosition((int) ((lf.getCurrentPosition() + GO_DISTANCE) * FORWARD_DRIVE_FACTOR));

        //Set Drive Power
        lf.setPower(1);
        lb.setPower(1);
        rf.setPower(1);
        rb.setPower(1);

        //Set to RUN_TO_POSITION mode
        lf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rb.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (lf.isBusy() && lb.isBusy() && rf.isBusy() && rb.isBusy()){
            //Wait Until Target Position is Reached
        }
    }

    public void turn (int GO_DISTANCE){
        //Reset Encoders
        lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Set Target Position
        lf.setTargetPosition((int) ((lf.getCurrentPosition() + GO_DISTANCE) * TURN_DRIVE_FACTOR));
        lb.setTargetPosition((int) ((lf.getCurrentPosition() + GO_DISTANCE) * TURN_DRIVE_FACTOR));
        rf.setTargetPosition((int) ((lf.getCurrentPosition() + GO_DISTANCE) * TURN_DRIVE_FACTOR));
        rb.setTargetPosition((int) ((lf.getCurrentPosition() + GO_DISTANCE) * TURN_DRIVE_FACTOR));

        //Set Drive Power
        lf.setPower(1);
        lb.setPower(1);
        rf.setPower(-1);
        rb.setPower(-1);

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
