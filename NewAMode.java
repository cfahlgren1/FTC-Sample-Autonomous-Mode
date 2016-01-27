package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorController;

  /*Programmed by Caleb Fahlgren
    FTC Autonomous Robot Program
	Please DO NOT edit without letting me know..
    Used thru 2015/2016 Academic Year!
    NXT touch sensors and servos are used in this program*/


public class AmodeL extends LinearOpMode{
	//Defining the variables
    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor motorArm;   
    
    int runAMode;
    
    defining the variables as touch sensors
    TouchSensor touchSensorLeft;
    TouchSensor touchSensorRight;
    
    //defining the variables as servos
    Servo claw;
    Servo touchLeft;
    Servo touchRight;
    
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
		touchLeft = hardwareMap.touchSensor.get("touchServoLeft");
		touchRight = hardwareMap.touchSensor.get("touchServoRight");


        motorRight.setDirection(DcMotor.Direction.REVERSE);

        // Motors are set to run without encoders
        motorLeft.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        motorRight.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);

        // Variable showing that the claw position starts at 0
        clawPosition = 0;
	
        // Will keep the claw closed during Autonomous
        clawPosition -= clawDelta;
        
        //Defining the open position for the right and left servos        
        final double LEFT_UP_POSITION = 0.0;
        final double RIGHT_UP_POSITION = 0.0;
        
        //Defining the down position for the right and left servos
        final double RIGHT_DOWN_POSITION = 0.5;
        final double LEFT_DOWN_POSITION = 0.5;
        
        //Clipping the values so they do not exceed 0 or 1  
        touchRightPosition = Range.clip(touchRight, 0, 1);
        touchLeftPosition = Range.clip(touchLeft, 0, 1); 
        
        //Setting the position to the down position for both servos
        touchLeft.setPosition(LEFT_DOWN_POSITION);
        touchRight.setPosition(RIGHT_DOWN_POSITION);
        
		//Pull up the arm for 2000 milliseconds
		for (runAMode=0; runAMode<2000; runAMode++){
			motorArm.setPower(0.2);
		}
		motorArm.setPower(0);
		
		//Driving in reverse for 6000 milliseconds
		for (runAMode=0; runAMode<6000; runAMode++){
			motorLeft.setPower(-0.5);
			motorRight.setPower(-0.5);		
		}
		//Turning for 2500 seconds
		for (runAMode=0; runAMode<2500; runAMode++){
			motorLeft.setPower(0.5);
			motorRight.setPower(-0.5);
		}
		while (true){
			//if touch sensor is pressed drive forward for half a second then put the servos
			//back up then turn the motor power to 0
			if(touchSensorLeft.isPressed){
				motorLeft.setPower(0.5);
				motorRight.setPower(0. 5);
				sleep(500);
				touchRight.setPosition(RIGHT_UP_POSITION);
				touchLeft.setPosition(LEFT_UP_POSITION);
				motorLeft.setPower(0);
				motorRight.setPower(0);			
				}
			//if touch sensor is pressed drive forward for half a second then put the servos
			//back up then turn the motor power to 0
			else if(touchSensorRight.isPressed){
				motorLeft.setPower(0.5);
				motorRight.setPower(0.5);
				sleep(500);
				touchRight.setPosition(RIGHT_UP_POSITION);
				touchLeft.setPosition(LEFT_UP_POSITION);
				motorLeft.setPower(0);
				motorRight.setPower(0);	
				}
			//if the touch sensors are not pressed then keep driving with
			//the servos down
			else{
				motorLeft.setPower(-0.5);
				motorRight.setPower(-0.5);
				touchLeft.setPosition(LEFT_DOWN_POSITION);
				touchRight.setPosition(RIGHT_DOWN_POSITION);
				
				}
		//for 1500 milliseconds raise the arm
		for (runAMode=0; runAMode<1500; runAMode++){
			motorArm.setPower(0.2);
			touchRight.setPosition(RIGHT_UP_POSITION);
			touchLeft.setPosition(LEFT_UP_POSITION);
			}	
		}
	}
}
