// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.geometry.Translation2d;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    /**
     * The left-to-right distance between the drivetrain wheels
     *
     * Should be measured from center to center.
     */
    public static final double DRIVETRAIN_TRACKWIDTH_METERS = .6; 
    /**
     * The front-to-back distance between the drivetrain wheels.
     *
     * Should be measured from center to center.
     */
    public static final double DRIVETRAIN_WHEELBASE_METERS = .6;

    public static final int FRONT_LEFT_MODULE_DRIVE_MOTOR = 2; 
    public static final int FRONT_LEFT_MODULE_STEER_MOTOR = 4; 
    public static final int FRONT_LEFT_MODULE_STEER_ENCODER = 0; 
    public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(185); // FIXME Measure and set front left steer offset

    public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 0; 
    public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 1;
    public static final int FRONT_RIGHT_MODULE_STEER_ENCODER = 3;
    public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(179);// FIXME Measure and set front right steer offset

    public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 7; 
    public static final int BACK_LEFT_MODULE_STEER_MOTOR = 3; 
    public static final int BACK_LEFT_MODULE_STEER_ENCODER = 1; 
    public static final double BACK_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(192);// FIXME Measure and set back left steer offset

    public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 5;
    public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 6; 
    public static final int BACK_RIGHT_MODULE_STEER_ENCODER = 2; 
    public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(170);

    public static final double k_TELEDRIVE_MAX_ACCELERATION = 3/2;
    public static final double k_TELEDRIVE_MAX_ANGULAR_ACCELERATION = 3/2;
    public static final double k_PHYSICAL_MAX_SPEED_METERS_PER_SECOND = DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND;
    public static final double k_PHYSICAL_MAX_ANGULAR_SPEED_RAD_PER_SECOND = DrivetrainSubsystem.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND;

    public static final SwerveDriveKinematics k_DRIVE_KINEMATICS = new SwerveDriveKinematics(
          // Front left
          new Translation2d(DRIVETRAIN_TRACKWIDTH_METERS / 2.0, DRIVETRAIN_WHEELBASE_METERS / 2.0),
          // Front right
          new Translation2d(DRIVETRAIN_TRACKWIDTH_METERS / 2.0, -DRIVETRAIN_WHEELBASE_METERS / 2.0),
          // Back left
          new Translation2d(-DRIVETRAIN_TRACKWIDTH_METERS / 2.0, DRIVETRAIN_WHEELBASE_METERS / 2.0),
          // Back right
          new Translation2d(-DRIVETRAIN_TRACKWIDTH_METERS / 2.0, -DRIVETRAIN_WHEELBASE_METERS / 2.0)
    );

    public static final class AutoConstants {
        public static final double k_MAX_SPEED_METERS_PER_SECOND = Constants.k_PHYSICAL_MAX_SPEED_METERS_PER_SECOND / 4;
        public static final double k_MAX_ANGULAR_SPEED_RADS_PER_SECOND = Constants.k_PHYSICAL_MAX_ANGULAR_SPEED_RAD_PER_SECOND / 10;
        public static final double k_MAX_ACCELERATION_METERS_PER_SECOND_SQ = 3;
        public static final double k_MAX_ANGULAR_ACCELERATION_RADS_PER_SECOND_SQ = Math.PI / 4;
        public static final double k_PX_CONTROLLER = 1.5;
        public static final double k_PY_CONTROLLER = 1.5;
        public static final double K_PTHETA_CONTROLLER = 3;
    
        public static final TrapezoidProfile.Constraints kThetaControllerConstraints = //
                new TrapezoidProfile.Constraints(
                        k_MAX_ANGULAR_SPEED_RADS_PER_SECOND,
                        k_MAX_ANGULAR_ACCELERATION_RADS_PER_SECOND_SQ);
    }
}


