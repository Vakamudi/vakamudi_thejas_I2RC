package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
//import frc.robot.subsystems.RobotContainer;

public class PIDTurnCCW extends Command{
    double setPointAngle;
    Drivetrain dt;
    double kp = 0.7/90;
    PIDController controller = new PIDController(kp, 0,0);


    public PIDTurnCCW(Drivetrain dt , double setPointAngle){
        this.dt = dt;
        this.setPointAngle = setPointAngle;
        controller.setTolerance(5);
        addRequirements(dt);
    }
   
    @Override
    public void initialize(){
        dt.reset();
        dt.tankDrive(0,0.0);
    }
    @Override
    public void execute(){
        double output = controller.calculate(dt.getAngle(), setPointAngle);
        dt.tankDrive(-output, output);
    }
    @Override
    public void end(boolean interrupted){
        dt.tankDrive(0, 0);
    }
    public boolean isFinished(){
        return controller.atSetpoint();
    }
}
