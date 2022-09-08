package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

public abstract class MainStuff extends LinearOpMode {
    protected DcMotor motorLeft;
    protected DcMotor motorRight;

    public void ROBOT_INITIALIZE() throws InterruptedException {
        motorLeft = hardwareMap.dcMotor.get("motor1");
        motorRight = hardwareMap.dcMotor.get("motor2");
    }

    public void Forward(double inch, double power) {
        int ticks = (int)inch;

        motorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorLeft.setTargetPosition(motorLeft.getCurrentPosition() - ticks);
        motorRight.setTargetPosition(motorLeft.getCurrentPosition() - ticks);

        motorLeft.setPower(power);
        motorRight.setPower(power);

        motorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (motorLeft.isBusy() && motorRight.isBusy()) {}

        sleep(200);
    }

    public void Turn(double angle, double power) {

    }

    public void ForwardTele() {
        motorLeft.setPower(-gamepad2.right_stick_x*2);
        motorRight.setPower(-gamepad2.right_stick_x*2);
    }

    public void TurnTele() {
        motorLeft.setPower(gamepad2.left_stick_y*2);
        motorRight.setPower(-gamepad2.left_stick_y*2);
    }
}
