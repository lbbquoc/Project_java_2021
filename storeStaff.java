package employee;

public class storeStaff extends Employee {
    private int typeOfStaff; // 1. full-time ______ 2 . part-time
    private int numWorkingDays; // number of working days of 1 month

    public storeStaff(int id, String name, int loaiNV, int idCompany)
    {
        super(id, name, loaiNV, idCompany);
    }
    //setter:
    public void setTypeStaff(int type)
    {
        this.typeOfStaff = type;
    }

    public void setNumWorkingDays(int day)
    {
        this.numWorkingDays = day;
    }

    // getter:

    public int getTypeStaff()
    {
        return this.typeOfStaff;
    }

    public int getNumWorkingDays()
    {
        return this.numWorkingDays;
    }


    public int calSalary()
    {
        return this.geteSalary() * this.getNumWorkingDays();
    }
    

}
