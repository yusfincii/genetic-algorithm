public class main 
{
    public static void main(String[] args) {
        
        Population population = new Population(10);
        
        population.getPopulation();
        
        System.out.println("------");
        
        int[] res = population.allFitness();
        
        for(int i=0; i<res.length; i++){
            System.out.print(res[i] + " - ");
        }
        
        System.out.println();
        System.out.println("-------");
        
        System.out.println(population.fittestChromosome());
        
        
//        int acc = 0;
//        
//        while(acc < 10000){
//            
//            population.crossover(population);
//            population.mutation(population);
//            System.out.println(acc + ".nesilde en uygun kromozom: "
//                    + population.fittestChromosome());
//            System.out.println("--------");
//            acc ++;
//            
//        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        Population population = new Population(100);
//        
//        // Can be shown all population members
//        // population.getPopulation();
//        
//        // System.out.println("--------");
//        
//        // Show fittest chromosome for first population case
//        population.fittestChromosome();
//        
//        System.out.println("--------");
//        
//        // First crossover transaction
//        population.crossover(population);
//        // Fittest chromosome after first crossover transaction
//        population.fittestChromosome();
//        
//        
//        System.out.println("--------");
//        // Second crossover transaction
//        population.crossover(population);
//        // Fittest chromosome after second crossover transaction
//        population.fittestChromosome();
//        
//        
//        System.out.println("--------");
//        // Third crossover transaction
//        population.crossover(population);
//        // Fittest chromosome after third crossover transaction
//        population.fittestChromosome();

        
    }
}
