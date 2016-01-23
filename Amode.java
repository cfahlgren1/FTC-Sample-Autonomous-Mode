package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorController;


  /*Programmed by Caleb Fahlgren
    FTC Autonomous Robot Program
	Please Do NOT edit without letting me know
    Used thru 2015/2016 Academic Year */


public class AmodeL extends LinearOpMode{
    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor motorArm;
    Servo claw;


    double clawPosition;
    double clawDelta = 0.01;

    public void runOpMode() throws InterruptedException {

        // Gets left and right motors from the configuration file
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");
        claw = hardwareMap.servo.get("servo_1");
        motorArm = hardwareMap.dcMotor.get("motorArm");


        motorRight.setDirection(DcMotor.Direction.REVERSE);

        // Motors are set to run without encoders
        motorLeft.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        motorRight.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);

        // Variable showing that the claw position starts at 0.5
        clawPosition = 0;

        // Will keep the claw closed during Autonomous
        clawPosition -= clawDelta;

        motorArm.setPower(0.2);

        sleep(2000);

        motorArm.setPower(0);


        // Drive in reverse for 4 seconds at half speed
        motorLeft.setPower(-0.5);
        motorRight.setPower(-0.5);

        sleep(6000);

        motorLeft.setPower(0);
        motorRight.setPower(0);

    }
}