package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Joystick;


public class teleOp extends Command {
    double leftPowerRaw;
    double rightPowerRaw;

    Drivetrain dt;
    Joystick joystick;


  /** Creates a new Encoder. */
  public teleOp(Joystick js){
    joystick = js;
     leftPowerRaw = joystick.getRawAxis(1);
     rightPowerRaw = joystick.getRawAxis(4);
  }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    dt.tankDrive(0,0); 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    dt.tankDrive(leftPowerRaw,rightPowerRaw);
  }
   
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    dt.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}


