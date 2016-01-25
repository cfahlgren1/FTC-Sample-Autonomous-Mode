package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorController;

  /*Programmed by Caleb Fahlgren
    FTC Autonomous Robot Program
	Please DO NOT edit without letting me know..
    Used thru 2015/2016 Academic Year!
    NXT touch sensors are used in this program*/


public class AmodeL extends LinearOpMode{
	//Defining the variables
    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor motorArm;
    Servo claw;
    int runAMode;
    TouchSensor touchSensorLeft;
    TouchSensor touchSensorRight;
    
    double clawPosition;
    double clawDelta = 0.01;

    public void runOpMode() throws InterruptedException {

        // Gets motors and servos from the configuration file
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");
        claw = hardwareMap.servo.get("servo_1");
        motorArm = hardwareMap.dcMotor.get("motorArm");
		touchSensorLeft = hardwareMap.touchSensor.get("touchSensorL");
		touchSensorRight = hardwareMap.touchSensor.get("touchSensorRight");


        motorRight.setDirection(DcMotor.Direction.REVERSE);

        // Motors are set to run without encoders
        motorLeft.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        motorRight.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);

        // Variable showing that the claw position starts at 0
        clawPosition = 0;

        // Will keep the claw closed during Autonomous
        clawPosition -= clawDelta;      
        

	for (runAMode=0; runAMode<2000; runAMode++){
		motorArm.setPower(0.2);
	}
	motorArm.setPower(0);

	for (runAMode=0; runAMode<6000; runAMode++){
		motorLeft.setPower(-0.5);
		motorRight.setPower(-0.5);		
	}
	for (runAMode=0; runAMode<2500; runAMode++){
		motorLeft.setPower(0.5);
		motorRight.setPower(-0.5);
	}
	while (true){
		if(touchSensorLeft.isPressed){
			motorLeft.setPower(0);
			motorRight.setPower(0);			
		}
		else if(touchSensorRight.isPressed){
			motorLeft.setPower(0);
			motorRight.setPower(0);
		}
		else{
			motorLeft.setPower(-0.5);
			motorRight.setPower(-0.5);
		}
	for (runAMode=0; runAMode<1500; runAMode++){
		motorArm.setPower(0.2);
			}	
		}
	}
}
