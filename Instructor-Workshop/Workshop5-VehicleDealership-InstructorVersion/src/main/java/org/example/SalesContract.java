package org.example;

public class SalesContract extends Contract{
    private boolean isFinanced;

    public SalesContract(String date, String name, String email, Vehicle vehicle, boolean isFinanced) {
        super(date, name, email, vehicle);
        this.isFinanced = isFinanced;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
