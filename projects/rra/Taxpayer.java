package projects.rra;

public class Taxpayer {
    private int id;
    private String name;
    private double turnoverAmount;
    private double rate; // Predefined rate based on tax type
    private String taxType; // Should be "VAT" or "Income Tax"
    private int age;

    public Taxpayer(int id, String name, double turnoverAmount, double rate, String taxType, int age) {
        this.id = id;
        this.name = name;
        this.turnoverAmount = turnoverAmount;
        this.rate = rate;
        this.taxType = taxType;
        this.age = age;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getTurnoverAmount() {
        return turnoverAmount;
    }
    public double getRate() {
        return rate;
    }
    public String getTaxType() {
        return taxType;
    }
    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setTurnoverAmount(double turnoverAmount) {
        this.turnoverAmount = turnoverAmount;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Taxpayer ID: " + id +
               "\nName: " + name +
               "\nTurnover Amount: " + turnoverAmount +
               "\nTax Rate: " + rate +
               "\nTax Type: " + taxType +
               "\nAge: " + age;
    }
}
