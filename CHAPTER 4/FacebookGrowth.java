public class FacebookGrowth {
    public static void main(String[] args) {
        // starting users (1 billion)
        double currentUsers = 1_000_000_000;
        
        // target numbers of users
        double target1 = 1_500_000_000;
        double target2 = 2_000_000_000;
        
        // monthly growth rate (4%)
        double growthRate = 0.04;
        
        // find how many months it takes to reach each goal
        int monthsTo1_5B = calculateMonths(currentUsers, target1, growthRate);
        int monthsTo2B = calculateMonths(currentUsers, target2, growthRate);
        
        // print the results
        System.out.printf("Facebook user growth projection (4%% monthly growth)%n");
        System.out.printf("Current users: %.1f billion%n", currentUsers / 1_000_000_000);
        System.out.printf("Months to reach 1.5 billion: %d months%n", monthsTo1_5B);
        System.out.printf("Months to reach 2.0 billion: %d months%n", monthsTo2B);
    }
    
    // method to calculate how many months it takes to reach a target number
    public static int calculateMonths(double current, double target, double rate) {
        int months = 0;       // keeps track of months
        double users = current; // current number of users
        
        // keep increasing users each month until we hit the target
        while (users < target) {
            users *= (1 + rate);
            months++;
        }
        
        return months; // return how many months it took
    }
}