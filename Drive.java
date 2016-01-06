import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor

public class ExampleDriveForwareAndTurn extends LinearOpMode{

	DcMotor motorLeft;
	DcMotor motorRight;

public void runOpMode() throws InteruptedException {

	motorRight = hardwareMap.dcMotor.get("motorLeft");
        motorLeft = hardwareMap.dcMotor.get("motorRight");

	rightMotor.setDirection(DcMotor.Direction.REVERSE);

	
	
	leftMotor.setPower(0.5);
	rightMotor.setPower(0.5);

	sleep(4000);

	leftMotor.setPower(0.5);
	rightMotor.setPower(0);
	
	sleep(1000)


	leftMotor.setPower(0.5);
	rightMotor.setPower(0.5)

	sleep(3000)

}
}
