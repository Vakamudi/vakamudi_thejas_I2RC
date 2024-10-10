// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class EncoderDrive extends Command {
  Drivetrain dt;
  double setPoint;
  /** Creates a new Encoder. */
  public EncoderDrive(Drivetrain dt, double setPoint ) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.dt=dt;
    this.setPoint=setPoint;
    addRequirements(dt);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    dt.tankDrive(0,0); 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    dt.tankDrive(0.8,0.8);
  }
   
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    dt.tankDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(dt.getMeters()>=setPoint){
      return true;
    }
    else return false;
  }
  
}
