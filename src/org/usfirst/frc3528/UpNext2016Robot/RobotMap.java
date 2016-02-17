package org.usfirst.frc3528.UpNext2016Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
	// Drivetrain
    public static CANTalon driveTrainfrontLeftMotor;
    public static CANTalon driveTrainfrontRightMotor;
    public static CANTalon driveTrainbackLeftMotor;
    public static CANTalon driveTrainbackRightMotor;
    public static ADXRS450_Gyro gyro;
    
    public static RobotDrive driveTraintankDrive;
    public static boolean driveWithSingleJoystick = false;
    public static boolean driveIsReversed = false;
    public static boolean isHighGear = false;
    
    
    // Arm
    public static VictorSP armDriveMotor;
    public static VictorSP intakeDriveMotor;
    public static Encoder armEncoder;
    public static DigitalInput armIn;
    public static DigitalInput armOut;
    
    public static boolean manualArmDrive = true;
    
    
    // Camera
    public static CameraServer server;
    
    
    
    //            ***CONSTANTS***
    
    
    // DriveTrain
    public static final int FRONT_LEFT_TALON = 1;
    public static final int BACK_LEFT_TALON = 3;
    public static final int FRONT_RIGHT_TALON = 2;
    public static final int BACK_RIGHT_TALON = 4;
    
    public static final int GYRO = 0;
    public static double SENSITIVITY = .5;
    
    // Arm
    
    public static final int ARM_MOTOR_VICTOR = 0;
    public static final int INTAKE_MOTOR_VICTOR = 1;
    public static final int ARM_ENCODER_A = 0;
    public static final int ARM_ENCODER_B = 1;
    public static final int ARM_IN = 2;
    public static final int ARM_OUT = 3;
    
    
    // Joystick Buttons
    
    public static final int A = 1;
    public static final int B = 2;
    public static final int X = 3;
    public static final int Y = 4;
    public static final int TRIGGER = 2;
    public static final int LEFT_TRIGGER = 5;
    public static final int RIGHT_TRIGGER = 6;
    public static final int BACK = 7;
    public static final int START = 8;
    
    
    public static final double JOYSTICK_RANGE_MAX = 1.0;
    public static final double JOYSTICK_RANGE_MIN = -1.0;
    public static final double JOYSTICK_DEADBAND_MAX = .1;
    public static final double JOYSTICK_DEADBAND_MIN = -.1;
    
    public static double JOYSTICK_SCALE = .75;
    public static double JOYSTICK_CURVE = 3;  // this is the exponent (such as square or cube)
    
    
    //                     ********** Wheels and Encoders and Distance Oh My **********
 	// Wheel Size
 	public static final double WHEEL_DIAMETER = 8.0;
 	
 	// Calculate Wheel Diameter
 	public static final double INCHES_PER_REV = Math.PI * WHEEL_DIAMETER;
 	
 	// Encoder Counts/Ticks per one revolution
 	public static final double COUNTS_PER_REV = 1440;//360;
 	
 	// Calculate how many inches are in one encoder count/tick
 	public static final double INCHES_PER_COUNT = INCHES_PER_REV / COUNTS_PER_REV;
 	
 	//                 ********** And they all lived happily ever after. The End. **********
    
 
 
 	/*
 	public static final double DRIVEFORWARDPOWER = 0.75;
	public static final double DRIVEFORWARDTIME = 8.0;
	public static final double DRIVEFORWARDFEET = 5.0;
	public static final double SHORTDRIVEFEET = 0.3;
 	*/
 	
 	

    public static void init() {
        
        driveTrainfrontLeftMotor = new CANTalon(FRONT_LEFT_TALON);
        driveTrainfrontLeftMotor.setInverted(true);
        LiveWindow.addActuator("DriveTrain", "frontLeftMotor", (CANTalon) driveTrainfrontLeftMotor);
        
        driveTrainfrontRightMotor = new CANTalon(FRONT_RIGHT_TALON);
        driveTrainfrontRightMotor.setInverted(true);
        LiveWindow.addActuator("DriveTrain", "frontRightMotor", (CANTalon) driveTrainfrontRightMotor);
        
        driveTrainbackLeftMotor = new CANTalon(BACK_LEFT_TALON);
        driveTrainbackLeftMotor.setInverted(true);
        LiveWindow.addActuator("DriveTrain", "backLeftMotor", (CANTalon) driveTrainbackLeftMotor);
        
        driveTrainbackRightMotor = new CANTalon(BACK_RIGHT_TALON);
        driveTrainbackRightMotor.setInverted(true);
        LiveWindow.addActuator("DriveTrain", "backRightMotor", (CANTalon) driveTrainbackRightMotor);
        
        driveTraintankDrive = new RobotDrive(driveTrainfrontLeftMotor, driveTrainbackLeftMotor,
              driveTrainfrontRightMotor, driveTrainbackRightMotor);
        
        gyro = new ADXRS450_Gyro();
        
        
        armDriveMotor = new VictorSP(ARM_MOTOR_VICTOR);
        intakeDriveMotor = new VictorSP(INTAKE_MOTOR_VICTOR);
        
        armEncoder = new Encoder(ARM_ENCODER_A, ARM_ENCODER_B);
        
        armIn = new DigitalInput(ARM_IN);
        armOut = new DigitalInput(ARM_OUT);
        
        driveTraintankDrive.setSafetyEnabled(false);
        driveTraintankDrive.setExpiration(0.1);
        driveTraintankDrive.setSensitivity(SENSITIVITY);
        driveTraintankDrive.setMaxOutput(1.0);
        
        armDriveMotor.setSafetyEnabled(false);
        
        
        server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam1");
        
    }
    
    
}
