import java.util.InputMismatchException;
import java.util.Scanner;

public class KnapSackFractional {
    void swap(String arr[], int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void SortProfit(String name[], int weight[], int profit[]) {
        for (int round = 0; round < profit.length - 1; round++) {
            int maxIndex = round;
            for (int i = round + 1; i < profit.length; i++) {
                if (profit[i] > profit[maxIndex]) {
                    maxIndex = i;
                }
            }
            swap(profit, round, maxIndex);
            swap(name, round, maxIndex);
            swap(weight, round, maxIndex);
        }
        // for(int i=0;i<profit.length;i++){
        // System.out.println(profit[i]+" "+name[i]+" "+weight[i]);
        // }
    }

    public double findCost(int profit[], int weight[], String name[], int capacity) {
        double calProfit[] = new double[profit.length];
        int calweight[] = new int[weight.length];
        String calname[] = new String[name.length];
        int tempCap = capacity;
        double ans = 0;
        int i = 0;
        System.out.println("Total Quantity of fractional product: "+weight.length);
        if (capacity > 0 && weight.length!=0) {

            while (tempCap >= 0) {
                if (weight[i] > tempCap) {
                    calweight[i] = tempCap;
                    double tempprofit = (double) profit[i] * tempCap / (double) weight[i];
                    calProfit[i] = tempprofit;
                    calname[i] = name[i];
                    tempCap -= tempCap;
                } else {
                    calProfit[i] = profit[i];
                    calname[i] = name[i];
                    calweight[i] = weight[i];
                    tempCap -= weight[i];
                    System.out.println(tempCap);
                }
                i++;
                if (i >= profit.length)
                    break;
            }
            for (int j = 0; j < profit.length; j++) {
                ans += calProfit[j];

                System.out.println(calname[j]+ " -- " + "PROFIT= "+ calProfit[j] +" WEIGHT= " + calweight[j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Enter quantity: ");
            int qty = sc.nextInt();
            System.out.println("Enter capacity of bag:");
            int cap = sc.nextInt();
            String name[] = new String[qty];
            int weight[] = new int[qty];
            int profit[] = new int[qty];
            System.out.println("Enter Name , weight & profit of products");
            for (int i = 0; i < qty; i++) {
                name[i] = sc.next();
                weight[i] = sc.nextInt();
                profit[i] = sc.nextInt();
            }
            new KnapSackFractional().SortProfit(name, weight, profit);
            System.out.println(new KnapSackFractional().findCost(profit, weight, name, cap));
        } catch (InputMismatchException e) {
            System.out.println("Wrong type input");
        } catch (Exception e) {
            System.out.println("Something Went wrong: " + e);
        }

        sc.close();

    }

}
