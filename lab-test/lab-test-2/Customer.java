public class Customer {
    private String name;
    private String status;
    private int hours;
    private double charge;

    public Customer(String name, String status, int hours, double charge) {
        this.name=name;
        this.status=status;
        this.hours=hours;
        this.charge=charge;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status=status;
    }

    public int getHours() {
        return hours;
    }


    public void setHours(int hours) {
        this.hours=hours;

    }

    public double getCharge() {
        return charge;
    }

    public void setCharge() {
        this.charge=charge;
    }

}

