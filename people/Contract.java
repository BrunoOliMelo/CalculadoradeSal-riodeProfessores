package com.teachapp.people;

import com.teachapp.utilities.Input;

public class Contract {
    private String paymentScheme;
    private int paymentSchemeID;

    // CONSTRUCTOR
    public Contract (int paymentSchemeID) {
        this.paymentScheme = setPaymentScheme(paymentSchemeID);
        this.paymentSchemeID = paymentSchemeID;
    }

    public int getPaymentSchemeID() {
        return paymentSchemeID;
    }

    public void setPaymentSchemeID() {
        Object[] userOptions = {"CLT", "Horista", "PJ"};
        String message = "Alterar regime de pagamento";
        this.paymentSchemeID = Input.inputOption(userOptions, message);
        setPaymentScheme(paymentSchemeID);
    }

    public String getPaymentScheme() {
        return paymentScheme;
    }
    private String setPaymentScheme(int paymentSchemeID) {
        if (paymentSchemeID == 0) {
            paymentScheme = "CLT";
        } else if (paymentSchemeID == 1) {
            paymentScheme = "Horista";
        } else {
            paymentScheme = "PJ";
        }
        return paymentScheme;
    }
}