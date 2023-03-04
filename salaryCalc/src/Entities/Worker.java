package Entities;
import Enums.WorkLevel;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

public class Worker {
    private String name;
    private WorkLevel level;
    private Double baseSalary;

    private Department department;
    private List<HourContract> contract = new ArrayList<>();

    public Worker(){}

    public Worker(String name, WorkLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    // GETTERS AND SETTERS...
    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public WorkLevel getLevel() {return level;}

    public void setLevel(WorkLevel level) {this.level = level;}

    public Double getBaseSalary() {return baseSalary;}

    public void setBaseSalary(Double baseSalary) {this.baseSalary = baseSalary;}

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContract() {
        return contract;
    }
// ...GETTERS AND SETTERS

    public void addContract(HourContract contract){
        this.contract.add(contract);
    }
    public void removeContract(HourContract contract){
        this.contract.remove(contract);
    }

    public Double income(Integer year, Integer month){
        double soma = baseSalary;
        Calendar cal = Calendar.getInstance();
        for(HourContract con : contract){
            cal.setTime(con.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);
            if(c_year == year && c_month == month) {
                soma += con.totalValue();
            }
        }
        return soma;
    }

}
