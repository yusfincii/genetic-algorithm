import java.util.LinkedList;
import java.util.Random;

public class Population 
{
    // Creating random object for creating a random number
    Random rnd = new Random();
    
    // This array will contain all require characters
    char[] allChars = new char[91];
    
    // Creating linkedlist
    // Linkedlist to create will represent our population
    LinkedList<String> population = new LinkedList();
    
    
    // Adding chars to allChars list
    public void addAllChars(){
        for(int i=32; i<123; i++){
            allChars[i-32] = (char)i;
        }
    }
    
    // Chromosome(Indiviual) creating function
    private String createChromosome(){
        
        // creating random number
        int random = rnd.nextInt(90);
        
        // Initializing new chromosome
        String chromosome = "";
        
        // This string representing our character to selected by
        // random number in allChars list
        String x = String.valueOf(allChars[random]);
        
        // Determining chromosome lenght to 17
        for(int a=0; a<17; a++){
            
            // if chromosome contains selected character process will canceled
            // and creating new random number and character
            while(chromosome.contains(x)){
                random = rnd.nextInt(90);
            }
            // else case
            // character adding chromosome
            chromosome += allChars[random];
        }
        
        return chromosome;
    }
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
}
