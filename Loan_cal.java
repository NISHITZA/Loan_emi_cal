import java.io.*;
import java.util.*;


class Loan_cal
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int choice_flag = 0;
        ArrayList<Integer> loan_list = new ArrayList<Integer>();
        int loan_choice = 0;
        while(choice_flag==1){
            System.out.println("Menu");
            System.out.println("1.Loan");
            System.out.println("2.EMI calculator based on load");
            System.out.println("3.Exit");
            System.out.println("Please enter your choice");
            
            try{
                int choice = sc.nextInt();
                switch(choice){
                    case 1: System.out.println("Select Loan Option");
                            System.out.println("1.Home Loan");
                            System.out.println("2.Car Loan");
                            System.out.println("Enter the loan option");
                            loan_choice = sc.nextInt();
                            break;
                    case 2: System.out.println("EMI calculation");
                            if(loan_choice==0){
                                System.out.println("Please select the loan option first");
                                continue;
                            }
                            System.out.println("Enter the Loan Amount");
                            int amount = sc.nextInt();
                            loan_list.add(amount);

                            int monthly_income = sc.nextInt();
                            ArrayList<Integer> monthly_expense = new ArrayList<Integer>();

                            int expense_flag = 1;
                            while(expense_flag==1){
                                System.out.println("Enter your monthly expenses \n");
                                int expense = sc.nextInt();
                                monthly_expense.add(expense);
                                
                                System.out.println("Do you have other expenses ? Y/N ");
                                String n = sc.nextLine();
                                if(n=="Y" && n=="y"){
                                    expense_flag=0;
                                }
                            }
                            int total_expense = 0;
                            Iterator itr=monthly_expense.iterator();  
                            while(itr.hasNext()){
                                System.out.println(itr.next());
                            }
                            

                            break;
                    case 3: System.out.println("Exit option selection");
                            choice_flag=0;
                            break;
                    default:System.out.println("Please enter a correct option");
                    }
            }
            catch(Exception e){
                System.out.println("Please enter the correct choice");
            }

        }
        sc.close();
    }
}
