package com.teachapp.people;

import com.teachapp.utilities.Constant;
import com.teachapp.utilities.Input;

import javax.swing.*;

public abstract class Employee extends Person {
    Contract contract;
    double salary;

    // CONSTRUCTOR
    public Employee(String name) {
        super(name);
    }

    public void employeeInformations() {
        String message = "Nome - " + getName() +
                "\nRegime de pagamento - " + contract.getPaymentScheme() +
                "\nSalário - R$" + getSalary();
        JOptionPane.showMessageDialog(null,
                message,
                Constant.APP_NAME,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public Contract getContract() {
        return contract;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary() {
        int paymentScheme = getContract().getPaymentSchemeID();
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
        salary = inputDouble;
    }
}
