
package frc.robot.subsystems;
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;






import edu.wpi.first.wpilibj2.command.Command;

public class Drivetrain extends SubsystemBase {
    WPI_TalonSRX leftDriveTalon;
  WPI_TalonSRX rightDriveTalon;
  private AHRS NavX = new AHRS(SPI.Port.kMXP);

    /** Creates a new ExampleSubsystem. */
    public Drivetrain() {
      leftDriveTalon = new WPI_TalonSRX(Constants.DriveTrainPorts.LeftDriveTalonPort);
      rightDriveTalon = new WPI_TalonSRX(Constants.DriveTrainPorts.RigthDriveTalonPort);
      leftDriveTalon.setNeutralMode(NeutralMode.Coast);
      rightDriveTalon.setNeutralMode(NeutralMode.Coast);
      rightDriveTalon.setInverted(true);
    }

    /**
     * Example command factory method.
     *
     * @return a command
     */
    public void tankDrive(double leftSpeed, double rightSpeed){
      leftDriveTalon.set(leftSpeed);
      rightDriveTalon.set(rightSpeed);
  }
    public double getAngle(){
      return NavX.getAngle();
    }
    public void reset(){
      NavX.reset();
    }



    /**
     * An example method querying a boolean state of the subsystem (for example, a digital sensor).
     *
     * @return value of some boolean subsystem state, such as a digital sensor.
     */

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
      SmartDashboard.putNumber("left Voltage", leftDriveTalon.getMotorOutputPercent());
      SmartDashboard.putNumber("right Voltage", rightDriveTalon.getMotorOutputPercent());
      SmartDashboard.putNumber("Angle", NavX.getAngle());
    }

    @Override
    public void simulationPeriodic() {
      // This method will be called once per scheduler run during simulation
    }
}
