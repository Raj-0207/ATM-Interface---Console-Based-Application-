public interface Bank {
    public  void viewMiniStatement();
    public double calcCurrentWithdraw(double amount);
    public double calcSavingWithdraw(double amount);
    public double calcCurrentDeposit(double amount);
    public double calcSavingDeposit(double amount);
    public void getCurrentWithdrawInput();
    public void getSavingWithdrawInput();
    public void getCurrentDepositInput();
    public void getSavingDepositInput();

}
