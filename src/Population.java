import java.util.LinkedList;
import java.util.Random;

public class Population 
{
    
    // Creating random object for creating a random number
    private Random rnd = new Random();
    
    // This array will contain all require characters
    char[] allChars = addAllChars();
    
    // Creating linkedlist
    // Linkedlist to create will represent our population
    private LinkedList<String> population = new LinkedList();
    
    private final int chromosomeLength = 17;
    private final String targetSentence = "ChatGPT and GPT-4";
    
    
    
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
    
    // Adding chars to allChars list
    private char[] addAllChars(){
        char[] allCharsx = new char[91];
        
        for(int i=32; i<123; i++){
            allCharsx[i-32] = (char)i;
        }
        
        return allCharsx;
    }
    
    // Chromosome(Indiviual) creating function
    private String createChromosome(){
        
        // creating random number
        int random = rnd.nextInt(90);
        
        // Initializing new chromosome
        String chromosome = "";
        
        // This string representing our character to selected by
        // random number in allChars list
        
        // Determining chromosome lenght to 17
        for(int a=0; a<chromosomeLength; a++){
            
            // if chromosome contains selected character process will canceled
            // and creating new random number and character
            while(chromosome.contains(String.valueOf(allChars[random]))){
                random = rnd.nextInt(90);
            }
            // else case
            // character adding chromosome
            chromosome += allChars[random];
        }
        
        return chromosome;
    }
    
    
    public void getPopulation(){
        for(int i=0; i<population.size(); i++){
            System.out.print(population.get(i));
            System.out.println("");
        }
    }
    
    
    
    private int fitness(int chroIndex){
        
        int fitness = 0;
        for(int i=0; i<chromosomeLength; i++){
            fitness += Math.abs((int)population.get(chroIndex).charAt(i) - (int) targetSentence.charAt(i));
        }
        
        return fitness;
    }
    
    
    
    public void fitnessChromosome(){
        int fitnessChromosomeScore = fitness(0);
        String fitnessChromosome = population.get(0);
        
        for(int i=0; i<population.size(); i++){
            if(fitness(i) < fitnessChromosomeScore){
                fitnessChromosomeScore = fitness(i);
                fitnessChromosome = population.get(i);
            }
        }
        System.out.println(fitnessChromosome);
    }
    
    // will add
    public void crossOver(){
        
    }
    
}
