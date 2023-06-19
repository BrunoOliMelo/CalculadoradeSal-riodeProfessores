package com.teachapp.utilities;

import javax.swing.*;

public class Input {
    public static double inputDouble(String message) {
        boolean validInput = false;
        double inputDouble = 0;
        String inputString;
        while (!validInput) {
            try {
                inputString = JOptionPane.showInputDialog(
                        null,
                        message,
                        Constant.APP_NAME,
                        JOptionPane.PLAIN_MESSAGE);
                if (inputString == null) {
                    return -1;
                } else if (inputString.trim().isEmpty()) {
                    Output.NULL_ERROR_MESSAGE();
                } else {
                    inputDouble = Integer.parseInt(inputString);
                    if (inputDouble < 0) {
                        Output.NEGATIVE_VALUE_ERROR_MESSAGE();
                    } else if (inputDouble == 0) {
                        Output.NULL_VALUE_ERROR_MESSAGE();
                    } else {
                        validInput = true;
                    }
                }
            } catch (NumberFormatException e) {
                Output.GENERAL_ERROR_MESSAGE();
            }
        }
        return inputDouble;
    }
    public static int inputInteger(String message) {
        boolean validInput = false;
        int inputInteger = 0;
        String inputString;
        while (!validInput) {
            try {
                inputString = JOptionPane.showInputDialog(
                        null,
                        message,
                        Constant.APP_NAME,
                        JOptionPane.PLAIN_MESSAGE);
                if (inputString == null) {
                    return -1;
                } else if (inputString.trim().isEmpty()) {
                    Output.NULL_ERROR_MESSAGE();
                } else {
                    inputInteger = Integer.parseInt(inputString);
                    validInput = true;
                }
            } catch (Exception e) {
                Output.GENERAL_ERROR_MESSAGE();
            }
        }
        return inputInteger;
    }
    public static int inputOption(Object[] userOption, String message) {
        return JOptionPane.showOptionDialog(
                null,
                message,
                Constant.APP_NAME,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                userOption,
                userOption[0]);
    }
    public static String inputString(String message) {
        boolean validInput = false;
        String inputString = null;
        while (!validInput) {
            try {
                inputString = JOptionPane.showInputDialog(
                        null,
                        message,
                        Constant.APP_NAME,
                        JOptionPane.PLAIN_MESSAGE);
                if (inputString == null) {
                    return null;
                } else if (inputString.trim().isEmpty()) {
                    Output.NULL_ERROR_MESSAGE();
                } else {
                    validInput = true;
                }
            } catch (Exception e) {
                Output.GENERAL_ERROR_MESSAGE();
            }
        }
        return inputString;
    }
}