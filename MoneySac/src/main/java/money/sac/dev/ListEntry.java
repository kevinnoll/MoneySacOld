package money.sac.dev;

/**
 * Created by Kev1n on 05.10.13.
 */
public class ListEntry {
    private String desc;
    private boolean isIncome;
    private double amount;

    public ListEntry(String desc, double amount, boolean isIncome) {
        this.isIncome = isIncome;
        this.desc = desc;
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public boolean getIsIncome() {
        return isIncome;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setIsIncome(boolean isIncome) {
        this.isIncome = isIncome;
    }
}
