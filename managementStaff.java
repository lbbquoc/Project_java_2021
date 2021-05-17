package employee;

public class managementStaff extends Employee {
    int idStore;
    private int numWorkingDays; // number of working days of 1 month

    public managementStaff(int id, String name, int loaiNV, int idCompany)
    {
        super(id, name, loaiNV, idCompany);
    }
    //setter:

    public void setNumWorkingDays(int day)
    {
        this.numWorkingDays = day;
    }

    public void setIDStore(int id)
    {
        this.idStore = id;
    }
    // getter:

    public int getNumWorkingDays()
    {
        return this.numWorkingDays;
    }

    public int getIDStore()
    {
        return this.idStore;
    }

    // override

    public int calSalary()
    {
        return this.geteSalary() * this.numWorkingDays;
    }
    

}
