package drunkstuff;

/**
 *
 * @author jensb
 */
public class Person implements abs {
    
    public static final String FEMALE = "FEMALE";
    public static final String MALE = "MALE";
    public static final int MINIMUM_AGE = 12;
    public static final double DEFAULT_WEIGHT = 150;
    public static final int DEFAULT_AGE = 21;
    public static final double DEFAULT_DRINKS = 7;
    public static final double DEFAULT_HOURS = 9;
    private double numberOfDrinks;
    private double weight;
    private double hours; // likely moved 
    private String gender;
    private int age;
    private Legality legality;
    private double legalBAC;
    private double BAC;
    private BAC_Calculator calc;
    
    public Person() {
        this(MALE, DEFAULT_WEIGHT, DEFAULT_AGE, DEFAULT_DRINKS, DEFAULT_HOURS);
    }   
    
    public Person(String gender, double weight, int age, 
            double drinks, double hours) {
        setGender(gender);
        setWeight(weight);
        setAge(age);
        setNumberOfDrinks(drinks);
        setHoursSinceLastDrink(hours);
        calc = new BAC_Calculator(this);
        BAC = calc.getBAC();
        setBAC(calc.getBAC());
    }
    
    private void setGender(String gender) {
        switch(gender.toUpperCase()) {
            case FEMALE: 
                this.gender = FEMALE;
                break;
            case MALE:
                this.gender = MALE;
                break;
        }
    }
    
    private void setNumberOfDrinks(double drinks) {
        if (drinks < 0) {
            drinks = 0;
        }
        this.numberOfDrinks = drinks;
    }
    
    private void setHoursSinceLastDrink(double hours) {
        if (hours < 0) {
            hours = 0;
        }
        this.hours = hours;
    }
    
    private void setWeight(double weight) {
        if (weight < 0) {
            weight = DEFAULT_WEIGHT;
        }
        this.weight = weight;
    }
    
    private void setAge(int age) {
        if (age < MINIMUM_AGE) {
            age = MINIMUM_AGE;
        }
        this.age = age;
        if (age <= Legality.MINOR.AGE) {
            this.legality = Legality.MINOR;
        }
        else {
            this.legality = Legality.ADULT;
        }
    }
    
    public String AmIDrunk() {
        if (BAC >= legality.getLegalBAC()) {
            return "yes";
        }
        else {
            return "no";
        }
    }
    
    private void setBAC(double BAC) {
        this.BAC = BAC;
    }
    
    public double getNumberOfDrinks() {
        return numberOfDrinks;
    }
    
    @Override
    public double missing() {
        return 0;
    }
    
    @Override
    public double getBAC() {
        return this.BAC;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public String getGender() {
        return gender;
    }
    
    public int getAge() {
        return age;
    }
    
    public double getLegalBAC() {
        return legalBAC;
    }
    
    public double getHoursSinceFirstDrink() {
        return hours;
    }
    
    private enum Legality {
        MINOR (20, 0.02),
        ADULT (21, 0.08);
        
        private final int AGE;
        private final double LEGAL_BAC;
        
        Legality(int AGE, double LEGAL_BAC) {
            this.AGE = AGE;
            this.LEGAL_BAC = LEGAL_BAC;
        }
        
        public double getLegalBAC() {
            return LEGAL_BAC;
        }
    }

}
