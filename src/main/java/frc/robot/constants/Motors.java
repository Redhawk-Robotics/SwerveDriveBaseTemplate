// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/**
 * @Filename:Ports.java
 * @Purpose:This file contains the setting for motors
 * @Version:1.0
 * @Author: Giankyle Vallarta
 * @Date:11/30/22
 */

package frc.robot.constants;

import static com.revrobotics.CANSparkMax.IdleMode.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

 /*-
 * File containing all of the configurations that different motors require.
 *
 * Such configurations include:
 *  - If it is Inverted
 *  - The Idle Mode of the Motor
 *  - The Current Limit
 *  - The Open Loop Ramp Rate
 */

public interface Motors {
    
    public interface SwerveDrive{
        int CURRENT_LIMIT_AMPS = 40;//MAY CHANGE LATER
        IdleMode IDLE_MODE = kBrake;//Need to type the import static com.revrobotics.CANSparkMax.IdleMode.*;

        public interface FRONT_LEFT_MODULE{
        Config LeftModuleDrive = new Config(true, IDLE_MODE, CURRENT_LIMIT_AMPS);
        Config LeftModuleSteer = new Config(true, IDLE_MODE, CURRENT_LIMIT_AMPS);
        }
        public interface FRONT_RIGHT_MODULE{
        Config RightModuleDrive = new Config(true, IDLE_MODE, CURRENT_LIMIT_AMPS);
        Config RightModuleSteer = new Config(true, IDLE_MODE, CURRENT_LIMIT_AMPS);
        }
        public interface BACK_LEFT_MODULE{
        Config BackModuleDrive = new Config(true, IDLE_MODE, CURRENT_LIMIT_AMPS);
        Config BackModuleSteer = new Config(true, IDLE_MODE, CURRENT_LIMIT_AMPS);
        }
         public interface BACK_RIGHT_MODULE{
        Config BackModuleDrive = new Config(true, IDLE_MODE, CURRENT_LIMIT_AMPS);
        Config BackModuleSteer = new Config(true, IDLE_MODE, CURRENT_LIMIT_AMPS);
        }
        //NOT SURE IF ITS NECCESSARY FOR THIS MANY INTERFACES
    }

     /** Class to store all of the values a motor needs */
     public static class Config {
        public final boolean INVERTED;
        public final IdleMode IDLE_MODE;
        public final int CURRENT_LIMIT_AMPS;
        public final double OPEN_LOOP_RAMP_RATE;

        public Config(
                boolean inverted,
                IdleMode idleMode,
                int currentLimitAmps,
                double openLoopRampRate) {
            this.INVERTED = inverted;
            this.IDLE_MODE = idleMode;
            this.CURRENT_LIMIT_AMPS = currentLimitAmps;
            this.OPEN_LOOP_RAMP_RATE = openLoopRampRate;
        }

        public Config(boolean inverted, IdleMode idleMode, int currentLimitAmps) {
            this(inverted, idleMode, currentLimitAmps, 0.0);
        }

        public Config(boolean inverted, IdleMode idleMode) {
            this(inverted, idleMode, 80);
        }

        public void configure(CANSparkMax motor) {
            motor.setInverted(INVERTED);
            motor.setIdleMode(IDLE_MODE);
            motor.setSmartCurrentLimit(CURRENT_LIMIT_AMPS);
            motor.setOpenLoopRampRate(OPEN_LOOP_RAMP_RATE);
            motor.burnFlash();
        }
    }
}