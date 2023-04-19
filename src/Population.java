import java.util.LinkedList;
import java.util.Random;

public class Population 
{
    
    // Creating random object for creating a random number
    Random rnd = new Random();
    
    // This array will contain all require characters
    char[] allChars = addAllChars();
    
    // Creating linkedlist
    // Linkedlist to create will represent our population
    LinkedList<String> population = new LinkedList();
    
    private final int CHROMOSOME_LENGTH = 17;
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
    
    
    // Chromosome(Indiviual) creating function
    private String createChromosome(){
        
        // creating random number
        int random = rnd.nextInt(90);
        
        // Initializing new chromosome
        String chromosome = "";
        
        // This string representing our character to selected by
        // random number in allChars list
        
        // Determining chromosome lenght to 17
        for(int a=0; a<CHROMOSOME_LENGTH; a++){
            
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
    
    
    // This method prints all population elements to console 
    // Optional
    public void getPopulation(){
        for(int i=0; i<population.size(); i++){
            System.out.print(population.get(i));
            System.out.println("");
        }
    }
    
    
    // Fitness score calculate with chromosome value(string) function 
    private int fitness(String chromosome){
        
        int fitness = 0;
        for(int i=0; i<CHROMOSOME_LENGTH; i++){
            fitness += Math.abs((int)chromosome.charAt(i) - (int) targetSentence.charAt(i));
        }
        
        return fitness;
    }
    
    
    // Fitness score of all elements
    private int[] allFitness(){
        int[] results = new int[population.size()];
        
        for(int i=0; i<population.size(); i++){
            results[i] = fitness(population.get(i));
        }
        
        return results;
    }
    
    
    
//    public String fittestChromosome(){
//        int fittestChromosomeScore = fitness(population.get(0));
//        String fittestChromosome = population.get(0);
//        
//        for(int i=0; i<population.size(); i++){
//            if(fitness(population.get(i)) < fittestChromosomeScore){
//                fittestChromosomeScore = fitness(population.get(i));
//                fittestChromosome = population.get(i);
//            }
//        }
//        return fittestChromosome;
//    }
    
    
    // Find fittest chromosome on linkedlist
    public String fittestChromosome(){
        
        int min = fitness(population.get(0));
        int a = 0;
        int[] results = allFitness();
        
        for(int i=0; i<results.length; i++){
            if(min > results[i]){
                min = results[i];
                a = i;
            }
        }
        
        String fittestChromosome = population.get(a);
        return fittestChromosome;
    }
    
    // Find second fittest chromosome in linkedlist
    private String secondFittestChromosome(){
        
        int[] tempArray = allFitness();
        
        int min = fitness(population.get(0));
        int[] results = allFitness();
        int a = 0;
        
        for(int i=0; i<results.length; i++){
            if(min < results[i]){
                min = results[i];
                a = i;
            }
        }
        
        tempArray[a] = Integer.MAX_VALUE;
        
        int minx = Integer.MAX_VALUE;
        int[] resultsx = tempArray;
        int b = 0;
        
        for(int i=0; i<resultsx.length; i++){
            if(minx<resultsx[i]){
                minx = resultsx[i];
                b = i;
            }
        }
        
        String secondFittestChromosome = population.get(b);
        return secondFittestChromosome;
        
    }
    
    
    // Find chromosome has worst fitness score
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
    
    
    
    // Selects 2 chromosome
    private Population selection(Population population){
        
        
        
        
        return population;
    }
    
    // =======================================================================
    // SEÇİLİM YÖNTEMİ OLARAK SABİT DURUM YÖNTEMİ KULLANILDI.
    //
    // EN YÜKSEK UYGUNLUK DEĞERİNE SAHİP K2 ROMOZOMDAN ÇOCUK ÜRETİLEREK
    // EN DÜŞÜK UYGUNLUK DEĞERİNE SAHİP BİREY İLE YER DEĞİŞTİRİLİR.
    // =======================================================================

    
    // Crossing-over process for 2 chromosome
    // Uses selection function
    public void crossover(Population population){
        
        // Require variables and their assingnes
        String fittestChromosome = fittestChromosome();
        String secondFittestChromosome = secondFittestChromosome();
        String worstFitChromosome = worstFitChromosome();
        
        // new child chromosome initializing with empty
        String newChildChromosome = "";
        
        
        // CROSS-OVER PROCESS
        // Determining a random number between 0-17
        int random = rnd.nextInt(CHROMOSOME_LENGTH);
        
        // Fittest chromosomes first random number characters assigns to
        // new child chromosome
        for(int i=0; i<random; i++){
            newChildChromosome += fittestChromosome.charAt(i);
        }
        
        // Second fittest chromosomes last random number characters assigns to
        // new child chromosome
        for(int i=random; i<CHROMOSOME_LENGTH; i++){
            newChildChromosome += secondFittestChromosome.charAt(i);
        }
        
        // Find worst fit elements index in linkedlist
        int k = population.population.indexOf(worstFitChromosome);
        
        // Insert new child chromosome to linkedlist
        population.population.set(k, newChildChromosome);
        
        
    }
    
    // According to mutation number it will mutate a gene
    public void mutation(Population population){
        
        // determining mutation number
        int random = rnd.nextInt(population.population.size());
        
        for(int i=0; i<population.population.size(); i++){
            // random indexinde bulunan elemanın random sırasındaki karakteri, tüm karakterlerin 
            // bulunduğu listeden random sırasındaki karakter ile değiştirilir.
            if(i == random){
                // for selecting randomth character in selected chromosome
                int random2 = rnd.nextInt(CHROMOSOME_LENGTH);
                int random3 = rnd.nextInt(CHROMOSOME_LENGTH);
                
                String mutation = population.population.get(i).replace(population.population.get(i).charAt(random2), allChars[random3]);
                population.population.set(random, mutation);
            }
            
        }
    }
    
}
