package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public abstract class RobotMain19888 extends LinearOpMode {
    final double DRIVE_FACTOR = 1.0;

    protected DcMotor m1;
    protected DcMotor m2;
    protected DcMotor m3;
    protected DcMotor m4;

    public void ROBOT_INITIALIZE() throws InterruptedException {
        m1 = hardwareMap.dcMotor.get("motor1");
        m2 = hardwareMap.dcMotor.get("motor2");
        m3 = hardwareMap.dcMotor.get("motor3");
        m4 = hardwareMap.dcMotor.get("motor4");

        m1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        m2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        m3.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        m4.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        m1.setDirection(DcMotor.Direction.REVERSE);
        m2.setDirection(DcMotor.Direction.REVERSE);
    }

    public void MoveV(double inch, double power) {
        int ticks = (int) (inch * DRIVE_FACTOR);

        m1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        m1.setTargetPosition(m1.getCurrentPosition() - ticks);
        m3.setTargetPosition(m3.getCurrentPosition() - ticks);

        m1.setPower(power);
        m3.setPower(power);

        m1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m3.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (m1.isBusy() && m2.isBusy()) {
            telemetry.addData("m1", -m1.getCurrentPosition());
            telemetry.addData("m3", -m3.getCurrentPosition());
            telemetry.update();
        }

        sleep(200);
    }

    public void MoveH(double inch, double power) {
        int ticks = (int) (inch * DRIVE_FACTOR);

        m2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        m2.setTargetPosition(m1.getCurrentPosition() - ticks);
        m4.setTargetPosition(m3.getCurrentPosition() - ticks);

        m2.setPower(power);
        m4.setPower(power);

        m2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m4.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (m2.isBusy() && m4.isBusy()) {
            telemetry.addData("m2", -m2.getCurrentPosition());
            telemetry.addData("m4", -m4.getCurrentPosition());
            telemetry.update();
        }

        sleep(200);
    }

//    public void ForwardTele() {
//        motorLeft.setPower(-gamepad2.right_stick_x*2);
//        motorRight.setPower(-gamepad2.right_stick_x*2);
//    }
//
//    public void TurnTele() {
//        motorLeft.setPower(gamepad2.left_stick_y*2);
//        motorRight.setPower(-gamepad2.left_stick_y*2);
//    }
}
