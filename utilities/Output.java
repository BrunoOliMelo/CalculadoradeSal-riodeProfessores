package com.teachapp.utilities;

import javax.swing.*;

public class Output {
    public static void GENERAL_ERROR_MESSAGE() {
        JOptionPane.showMessageDialog(
                null,
                "Ocorreu um erro!",
                Constant.APP_NAME,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void OPTION_ERROR_MESSAGE() {
        JOptionPane.showMessageDialog(
                null,
                "Opção inválida!",
                Constant.APP_NAME,
                JOptionPane.ERROR_MESSAGE);
    }
    public static void NULL_ERROR_MESSAGE() {
        JOptionPane.showMessageDialog(
                null,
                "Proibido valores nulos!",
                Constant.APP_NAME,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void NO_PROFESSOR_ERROR_MESSAGE() {
        JOptionPane.showMessageDialog(
                null,
                "Sem professores registrados!",
                Constant.APP_NAME,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void CLOSE_APP_MESSAGE() {
        JOptionPane.showMessageDialog(
                null,
                "Obrigado por usar o " + Constant.APP_NAME + "!",
                Constant.APP_NAME,
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void NEGATIVE_VALUE_ERROR_MESSAGE() {
        JOptionPane.showMessageDialog(
                null,
                "Valor negativo não permitido!",
                Constant.APP_NAME,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void NULL_VALUE_ERROR_MESSAGE() {
        JOptionPane.showMessageDialog(
                null,
                "Valor nulo não permitido!",
                Constant.APP_NAME,
                JOptionPane.ERROR_MESSAGE);
    }
}