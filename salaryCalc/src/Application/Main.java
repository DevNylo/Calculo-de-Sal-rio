package Application;

import Entities.Department;
import Entities.HourContract;
import Entities.Worker;
import Enums.WorkLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        Department department = new Department();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter department name: ");
        String departmentName = input.nextLine();

        System.out.println("Enter worker data: ");

        System.out.println("Name:");
        String workerName = input.nextLine();

        System.out.println("Level:");
        String workerLevel = input.nextLine();

        System.out.println("Base salary:");
        double workerSalary = input.nextDouble();

        Worker worker = new Worker(workerName, WorkLevel.valueOf(workerLevel), workerSalary, new Department(departmentName) );

        System.out.println("How many contracts to this worker?");
        int n = input.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.println("Enter contract #"+i+" data");
            System.out.println("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(input.next());

            System.out.println("Valor per hour:");
            double valuePerHour = input.nextDouble();

            System.out.println("Duration (hours):");
            int hours = input.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);

        }
        System.out.println();

        System.out.println("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = input.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: "+worker.getName());
        System.out.println("Department: "+worker.getDepartment().getName());
        System.out.println("Income for "+monthAndYear+": "+String.format("%.2f",worker.income(year,month)));


        input.close();
    }
}