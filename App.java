package com.teachapp;

import com.teachapp.people.Contract;
import com.teachapp.people.Professor;
import com.teachapp.utilities.Checker;
import com.teachapp.utilities.Constant;
import com.teachapp.utilities.Input;
import com.teachapp.utilities.Output;

import javax.swing.*;
import java.util.ArrayList;

public class App {
    static ArrayList<Professor> hiredProfessors;
    public static void main(String[] args) {
        hiredProfessors = new ArrayList<>();
        menu();
    }

    // MENU
    public static void menu() {
        Object[] userOption = {"Registrar", "Pesquisar", "Modificar", "Listar", "Sair"};
        String message = "Escolha uma operação";
        int userChoice = -1;
        while (userChoice != 4) {
            userChoice = Input.inputOption(userOption, message);

            switch (userChoice) {
                case -1 -> {
                    Output.CLOSE_APP_MESSAGE();
                    return;
                }
                case 0 -> hireProfessor();
                case 1 -> searchProfessor();
                case 2 -> modifyProfessor();
                case 3 -> listProfessors();
                case 4 -> Output.CLOSE_APP_MESSAGE();
                default -> Output.OPTION_ERROR_MESSAGE();
            }
        }
    }

    // MENU OPTIONS
    public static void hireProfessor() {
        String nameMessage = "Nome";
        String name = Input.inputString(nameMessage);
        if (Checker.stringVerify(name)) return;
        name = name.trim();

        Object[] userOption = {"CLT", "Horista", "PJ"};
        String paymentSchemeMessage = "Regime de pagamento";
        int paymentScheme = Input.inputOption(userOption, paymentSchemeMessage);
        if (Checker.integerVerify(paymentScheme)) return;

        double salary = inputSalary(paymentScheme);
        if (Checker.doubleVerify(salary)) return;

        Contract contract = new Contract(paymentScheme);
        Professor professor = new Professor(name, contract, salary);
        hiredProfessors.add(professor);
        professor.employeeInformations();
    }

    private static double inputSalary(int paymentScheme) {
        String message;
        double inputDouble;
        if (paymentScheme == 0) {
            message = "Salário mensal";
            inputDouble = Input.inputDouble(message);
        } else if (paymentScheme == 1) {
            message = "Horas trabalhadas";
            inputDouble = Input.inputDouble(message);
            message = "Valor da hora de trabalho";
            inputDouble *= Input.inputDouble(message);
        } else {
            message = "Valor do contrato";
            inputDouble = Input.inputDouble(message);
        }
        return inputDouble;
    }

    public static void searchProfessor() {
        if (hiredProfessors.size() > 0) {
            int professorID = getProfessorID();
            if (Checker.integerVerify(professorID)) return;

            Professor professor = findProfessor(professorID);

            if (professor != null) {
                professor.employeeInformations();
            } else {
                Output.GENERAL_ERROR_MESSAGE();
            }
        } else {
            Output.NO_PROFESSOR_ERROR_MESSAGE();
        }
    }

    public static void modifyProfessor() {
        if (hiredProfessors.size() > 0) {
            int professorID = getProfessorID();
            if (Checker.integerVerify(professorID)) return;

            Professor professor = findProfessor(professorID);

            if (professor != null) {
                Object[] userOption = {"Nome", "Regime de pagamento", "Salário"};
                String message = "Alterar informações";
                int userChoice = Input.inputOption(userOption, message);

                if (userChoice == 0) {
                    professor.setName();
                } else if (userChoice == 1) {
                    professor.getContract().setPaymentSchemeID();
                    professor.setSalary();
                } else {
                    professor.setSalary();
                }
                professor.employeeInformations();
            } else {
                Output.GENERAL_ERROR_MESSAGE();
            }
        } else {
            Output.NO_PROFESSOR_ERROR_MESSAGE();
        }
    }

    public static void listProfessors() {
        if (hiredProfessors.size() > 0) {
            StringBuilder message = new StringBuilder();

            for (Professor professor: hiredProfessors) {
                message.append(professor).append("\n");
            }

            JOptionPane.showMessageDialog(null,
                    message,
                    Constant.APP_NAME,
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            Output.NO_PROFESSOR_ERROR_MESSAGE();
        }
    }

    // UTILITIES
    public static Professor findProfessor(int professorID) {
        Professor professor = null;
        for (Professor i: hiredProfessors) {
            if (i.getProfessorID() == professorID) {
                professor = i;
            }
        }
        return professor;
    }
    public static int getProfessorID() {
        String message = "IP do professor";
        return Input.inputInteger(message);
    }
}