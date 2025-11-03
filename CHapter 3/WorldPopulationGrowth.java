public class WorldPopulationGrowth {
    public static void main(String[] args) {
        double currentPopulation = 8100000000.0; // 8.1 billion
        double growthRate = 0.0088; // 0.88%
        
        System.out.printf("%-6s %-20s %-20s%n", "Year", "Projected Population", "Annual Increase");
        
        double population = currentPopulation;
        int yearDoubled = -1;
        double target = currentPopulation * 2;
        
        for (int year = 1; year <= 75; year++) {
            double increase = population * growthRate;
            population += increase;
            
            System.out.printf("%-6d %-20.0f %-20.0f%n", year, population, increase);
            
            if (population >= target && yearDoubled == -1)
                yearDoubled = year;
        }

        if (yearDoubled != -1)
            System.out.println("\nPopulation would double in " + yearDoubled + " years.");
        else
            System.out.println("\nPopulation did not double within 75 years.");
    }
}
