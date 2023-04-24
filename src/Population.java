import java.util.LinkedList;
import java.util.Random;

public class Population 
{
    // calculate time(start)
    long startTime = System.nanoTime();
    
    // Creating random object for creating a random number
    Random rnd = new Random();
    
    // This array will contain all require characters
    private final char[] allChars = addAllChars();
    
    // =======================================================================
    // BU KISIM İÇİN(91 ADET ASCII KARAKTERI GIRDI OLARAK ALINMASI) 
    // HOCADAN İZİN ALINDI
    // =======================================================================
    
    // Adding chars to allChars list
    private char[] addAllChars(){
        char[] allCharsx = new char[91];
        
        for(int i=32; i<123; i++){
            allCharsx[i-32] = (char)i;
        }
        
        return allCharsx;
    }
    
    
    
    // Constant chromosome length
    private final int CHROMOSOME_LENGTH = 17;
    
    // Constant target text
    private final String targetSentence = "ChatGPT and GPT-4";
    
    // Creating Linkedlist to represent population
    LinkedList<String> population = new LinkedList();
    
    
    // Constructor
    public Population(int popSize){
        // Population creating by specified size
        for(int i=0; i<popSize; i++){
            // creating new chromosome
            String chromosome = createChromosome();
            // chromosome which created adding population
            population.add(chromosome);       
        }   
    }
    
    
    
    // Chromosome(Indiviual) creating function
    private String createChromosome(){
        
        // Initializing new chromosome
        String chromosome = "";
        
        // This string representing our character to selected by
        // random number in allChars list
        
        for(int a=0; a<CHROMOSOME_LENGTH; a++){

            // choosing random number
            int random = rnd.nextInt(90);
        
            // chromosome filling
            chromosome += allChars[random];
        }
        
        return chromosome;
    }
    
    
    
    
    // This method prints all population elements to console 
    // Optional
    public void getPopulation(){
        for(int i=0; i<population.size(); i++){
            System.out.print(population.get(i));
            System.out.println("");
        }
    }
    
    
    
    
    // Calculate fitness score with chromosome value(string) parameter
    public int fitness(String chromosome){
        
        int fitness = 0;
        for(int i=0; i<CHROMOSOME_LENGTH; i++){
            //difference ascii table index of current chromosome and target sentence        
            fitness += Math.abs((int)chromosome.charAt(i) - (int) targetSentence.charAt(i));
        }
        
        return fitness;
    }
    
    
    
    
    // Fitness score of all elements keeps in a list
    public int[] allFitness(){
        int[] results = new int[population.size()];
        
        for(int i=0; i<population.size(); i++){
            results[i] = fitness(population.get(i));
        }
        
        return results;
    }
    
    
    
    // calculating average fitness score of all population members
    public int popAverage(){
        int result = 0;
        int[] results = allFitness();
        
        for(int i=0; i<results.length; i++){
            result += results[i];
        }
        
        result /= results.length;
        
        return result;
        
    }
    
    
    
    // Find fittest chromosome on population
    public String fittestChromosome(){
        
        // fittest socre initializing with first chromosomes fitness score
        int fittestScore = fitness(population.get(0));
        // fittest chromosomes index in population
        int fittestIndex = 0;
        
        int[] results = allFitness();
        
        for(int i=1; i<results.length; i++){
            if(fittestScore < results[i]){
                fittestScore = results[i];
                fittestIndex = i;
            }
        }
        
        String fittestChromosome = population.get(fittestIndex);
        return fittestChromosome;
    }
    
    
    
    // Find fittest chromosomes index on population
    public int fittestChromosomeIndex(){
        
        // fittest socre initializing with first chromosomes fitness score
        int fittestScore = fitness(population.get(0));
        // fittest chromosomes index in population
        int fittestIndex = 0;
        
        int[] results = allFitness();
        
        for(int i=1; i<results.length; i++){
            if(fittestScore < results[i]){
                fittestScore = results[i];
                fittestIndex = i;
            }
        }
        
        return fittestIndex;
    }
    
    
    
    // Find chromosome has worst fitness score
    // Optional
    private String worstFitChromosome(){
        
        int max = fitness(population.get(0));
        int[] results = allFitness();
        int c = 0;
        
        for(int i=0; i<results.length; i++){
            if(max > results[i]){
                max = results[i];
                c = i;
            }
        }
        
        String worstFitChromosome = population.get(c);
        return worstFitChromosome;
        
    }
    
    
    
    // Create a new Linkedlist refers new population
    // Choose best chromosomes(calculating average of population and which 
    // chromosomes's score is smaller than average it will be one of bests) 
    // for adding to new population
    // size of new population will be equal with previous population(generation)
    // child of best chromosomes with created crossover 
    // will fill remain of new population
    
    
    public void selection(){
        
        // creating new population
        LinkedList<String> newPopulation = new LinkedList();
        
        int average = popAverage();

        int[] fitnessScores = allFitness();

        // best chromosomes adding to new population
        
        /////////////
        // ELITIZM //
        /////////////
        for(int i=0; i<population.size(); i++){

            if(fitnessScores[i] < average){
                newPopulation.add(population.get(i));
            }
        }
        
        // target case
        // when all chromosomes equal to each other it will throw an exception
        if(newPopulation.isEmpty()){
            
            // calculate time(end time)
            long endTime = System.nanoTime();
            // convert time nanosecond to milisecond
            int time = (int)((endTime - startTime)/100000);
            
            // Some outputs
            System.out.println("Gecen Zaman = " + time + " milisaniye");
            System.out.println("");
            System.out.println("Populasyon hedefe ulasti !");
            
        }
        
        // to keep population's size unchanged
        int newChildNumber = population.size() - newPopulation.size();
        
        
        // best members child's adding to new population with crossover
        for(int a=0; a< newChildNumber; a++){
            
            // selecting a random chromosome in population
            int random1 = rnd.nextInt(newPopulation.size());
            
            // selecting another random chromosome in population
            int random2 = rnd.nextInt(newPopulation.size());
            
            // selecting random index for fill new child
            int random3 = rnd.nextInt(CHROMOSOME_LENGTH);
            
            // new child initialize
            String newChild = "";
            
            /////////////////
            // CROSS-OVER ///
            /////////////////

            // filling new child's first part
            for(int x=0; x<random3; x++){
                newChild += newPopulation.get(random1).charAt(x);
            }
            
            // filling new child's second part
            for(int y=random3; y<CHROMOSOME_LENGTH; y++){
                newChild += newPopulation.get(random2).charAt(y);
            }
            
            newPopulation.add(newChild);
            
        }
        
        // population refers to new population in every iteration 
        population = newPopulation;
        
    }
    
    
    
    // Mutate a gene according to mutation number
    public void mutation(){
        
        // determining mutation number
        int random = rnd.nextInt(population.size());
        
        // İşlemin görülmesi açısından bir kromozomun
        // mutasyon geçirmesi garanti edildi.
        for(int i=0; i<population.size(); i++){
            // random indexinde bulunan elemanın random sırasındaki karakteri, tüm karakterlerin 
            // bulunduğu listeden random sırasındaki karakter ile değiştirilir.
            if(i == random){
                // for selecting randomth character in selected chromosome
                int random2 = rnd.nextInt(CHROMOSOME_LENGTH);
                int random3 = rnd.nextInt(CHROMOSOME_LENGTH);
                
                String mutation = population.get(i).replace(population.get(i).charAt(random2), allChars[random3]);
                population.set(random, mutation);
            }
            
        }
    }
    
}
