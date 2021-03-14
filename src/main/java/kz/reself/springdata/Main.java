package kz.reself.springdata;

import kz.reself.springdata.config.SpringConfig;
import kz.reself.springdata.controller.UserController;
import kz.reself.springdata.entity.EmployeeType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController userController = context.getBean("userController", UserController.class);
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Choose: \n" +
                    "1. Create employee \n" +
                    "2. Delete employee \n" +
                    "3. Update employee \n" +
                    "4. List of employee \n" +
                    "5. Find employee by name \n" +
                    "6. Reward salaried-commission employees \n" +
                    "7. 1.5 coef for Hourly Employees \n" +
                    "8. Change salary Commision and Salaried Commision employees \n" +
                    "0. exit");
            int choise = in.nextInt();
            switch (choise) {
                case 1:
                    System.out.println("Enter ID:");
                    int id = in.nextInt();
                    System.out.println("Full name of employee: ");
                    String fullName = in.next();
                    System.out.println("Enter salary:");
                    int salary = in.nextInt();
                    System.out.println("Enter hour rate:");
                    double hourRate = in.nextDouble();
                    System.out.println("Enter type of employee: \n1. Salaried; \n2. Hourly; \n3. Commision; \n4. Salaried commision; \nChoise: ");
                    int choise1 = in.nextInt();
                    EmployeeType employeeType = null;
                    switch (choise1) {
                        case 1:
                            employeeType = EmployeeType.SALARIED;
                            break;
                        case 2:
                            employeeType = EmployeeType.HOURLY;
                            break;
                        case 3:
                            employeeType = EmployeeType.COMMISION;
                            break;
                        case 4:
                            employeeType = EmployeeType.SALARIED_COMMISION;
                            break;
                    }

                    break;

                case 2:
                    userController.employeeList();
                    System.out.println("Enter id of employee:");
                    Long id1 = Long.valueOf(in.next());

                    userController.deleteEmployee(id1);
                    break;

                case 3:
                    userController.employeeList();
                    System.out.println("Enter ID of employee:");
                    Long id2 = in.nextLong();
                    userController.updateEmployee(id2);
                    break;

                case 4:
                    userController.employeeList();
                    break;

                case 5:
                    System.out.print("Name employee: ");
                    String name = in.next();
                    System.out.println(userController.findByName(name));
                    break;

                case 6:
                    userController.rewardSalariedCommissionEmployees(10);
                    break;

                case 7:
                    userController.salaryHourlyEmployees();
                    break;

                case 8:
                    userController.salaryCommisionAndSalariedCommision();
                    break;

                case 0:

                    return;
            }
        }
    }
}
