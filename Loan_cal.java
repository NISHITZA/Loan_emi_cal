import java.io.*;
import java.util.*;


class Loan_cal
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int choice_flag = 1;
        ArrayList<Integer> loan_list = new ArrayList<Integer>();
        int loan_choice = 0;
        while(choice_flag==1){
            System.out.println("Menu");
            System.out.println("1.Loan");
            System.out.println("2.EMI calculator based on loan");
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

                    case 2: System.out.println("EMI calculation");
                            if(loan_choice==0){
                                System.out.println("Please select the loan option first");
                                continue;
                            }
                            System.out.println("Enter the Loan Amount");
                            int amount = sc.nextInt();
                            loan_list.add(amount);
                            System.out.println("Enter your monthly income");
                            int monthly_income = sc.nextInt();
                            ArrayList<Integer> monthly_expense = new ArrayList<Integer>();

                            int expense_flag = 1;
                            while(expense_flag==1){
                                System.out.println("Enter your monthly expenses");
                                int expense = sc.nextInt();
                                monthly_expense.add(expense);
                                
                                System.out.println("Do you have other expenses ?");
                                System.out.println("1.Yes");
                                System.out.println("2.No");
                                int n = sc.nextInt();
                                if(n==2)
                                    expense_flag=0;
                            }
                            int total_expense = 0;
                            
                            System.out.println("Enter the monthly EMI paid by you");
                            int monthly_emi = sc.nextInt();

                            Iterator<Integer> itr=monthly_expense.iterator();  
                            while(itr.hasNext()){ 
                                total_expense = total_expense + itr.next();
                            }

                            System.out.println("The total expense is "+(total_expense + monthly_emi));
                            double emi_possible_amount = 0.3*monthly_income;
                            double remaining_possible_amount = emi_possible_amount - monthly_emi;

                            if(remaining_possible_amount<amount){

                                System.out.println("EMI crosses 30% of monthly amount, thus new loan is not recommended");
                                choice_flag=0;
                                break;
                            }

                            int month_count =0;
                            double temp_value = amount;

                            while(temp_value>0){
                                temp_value = temp_value - remaining_possible_amount;
                                month_count++;
                            }
                            System.out.println("The EMI details");
                            System.out.println("EMI amount per month "+remaining_possible_amount);
                            System.out.println("Number of months EMI to be paid "+month_count);
                            break;
                            
                    case 3: System.out.println("Exit option selection");
                            choice_flag=0;
                            break;
                    default:System.out.println("Please enter a correct option");
                    }
            }
            catch(Exception e){
                System.out.println("Please enter the correct choice "+e);
                break;
            }
        }
        sc.close();
    }
}
