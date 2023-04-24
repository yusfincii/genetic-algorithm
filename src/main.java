public class main 
{
    public static void main(String[] args) {
        
        
        // population vreating with specified element number
        Population population = new Population(200);
        
        // print all elemets of population on console
        population.getPopulation();
        
        System.out.println("------");
        
        // all fitness scores
        int[] res = population.allFitness();
        
        System.out.println("");
        
        // print all fitness scores of population
        for(int i=0; i<res.length; i++){
            System.out.print(res[i] + " - ");
        }
        
        // Iteration count(generation count)
        for(int i=0; i<100; i++){
            
            // print generation
            System.out.println(i+1 + ". nesil");
            System.out.println("==========");
            
            // print fitness chromosomes name and score
            System.out.println();
            System.out.println("Fittest Chromosome and Fitness Score = " +
  population.fittestChromosome() + " - " + population.fitness(population.population.get(i)));
            
            System.out.println();
            System.out.println("-------");
            
            // print average fitness score of population
            System.out.println("Average: " + population.popAverage());
            
            System.out.println();
            System.out.println("-------");
            
            // selection process
            population.selection();
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
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
