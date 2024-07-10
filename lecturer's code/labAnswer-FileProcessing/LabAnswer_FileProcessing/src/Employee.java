class Employee {
    private int employeeId;
    private String employeeName;
    private int workingDays;
    private double hourlyRate;
    private double salary;

    public Employee(int employeeId, String employeeName, int workingDays, double hourlyRate, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.workingDays = workingDays;
        this.hourlyRate = hourlyRate;
        this.salary = salary;
    }

    

    @Override
    public String toString() {
        return employeeId + "," + employeeName + "," + workingDays + "," + hourlyRate + "," + salary;
    }

    

    public void display() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + employeeName);
        System.out.println("Working Days: " + workingDays);
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Salary: " + salary);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getSalary() {
        return salary;
    }
    
}