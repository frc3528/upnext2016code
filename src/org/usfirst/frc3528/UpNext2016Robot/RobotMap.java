package org.usfirst.frc3528.UpNext2016Robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.RobotDrive;
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
    public static AnalogGyro gyro;
    
    public static RobotDrive driveTraintankDrive;
    public static boolean driveWithSingleJoystick = false;
    
    
    // Arm
    public static VictorSP armDriveMotor;
    public static VictorSP intakeDriveMotor;
    
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
    
    
    // Joystick Buttons
    public static final int Y = 4;
    public static final int TRIGGER = 2;
    
    public static final int LEFT_TRIGGER = 5;
    public static final int RIGHT_TRIGGER = 6;
    
    public static final double JOYSTICK_RANGE_MAX = 1.0;
    public static final double JOYTICK_RANGE_MIN = -1.0;
    public static final double JOYTICK_SCALE = .75;
    public static final double JOYTICK_CURVE = 3;  // this is the exponent (such as square or cube)
    public static final double JOYSTICK_DEADBAND_MAX = .1;
    public static final double JOYSTICK_DEADBAND_MIN = -.1;
    
    
    
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
        LiveWindow.addActuator("DriveTrain", "frontLeftMotor", (CANTalon) driveTrainfrontLeftMotor);
        
        driveTrainfrontRightMotor = new CANTalon(FRONT_RIGHT_TALON);
        LiveWindow.addActuator("DriveTrain", "frontRightMotor", (CANTalon) driveTrainfrontRightMotor);
        
        driveTrainbackLeftMotor = new CANTalon(BACK_LEFT_TALON);
        LiveWindow.addActuator("DriveTrain", "backLeftMotor", (CANTalon) driveTrainbackLeftMotor);
        
        driveTrainbackRightMotor = new CANTalon(BACK_RIGHT_TALON);
        LiveWindow.addActuator("DriveTrain", "backRightMotor", (CANTalon) driveTrainbackRightMotor);
        
        driveTraintankDrive = new RobotDrive(driveTrainfrontLeftMotor, driveTrainbackLeftMotor,
              driveTrainfrontRightMotor, driveTrainbackRightMotor);
        
        gyro = new AnalogGyro(GYRO);
        
        
        armDriveMotor = new VictorSP(ARM_MOTOR_VICTOR);
        intakeDriveMotor = new VictorSP(INTAKE_MOTOR_VICTOR);
        
        
        
        driveTraintankDrive.setSafetyEnabled(true);
        driveTraintankDrive.setExpiration(0.1);
        driveTraintankDrive.setSensitivity(SENSITIVITY);
        driveTraintankDrive.setMaxOutput(1.0);
        
        
        
        server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam0");
        
    }
    
    
}
