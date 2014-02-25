package drunkstuff;

/**
 *
 * @author jensb
 */
public class Person implements abs {
    
    private final String FEMALE = "FEMALE";
    private final String MALE = "MALE";
    private final double MINIMUM_AGE = 12;
    
    private double numberOfDrinks;
    private double weight;
    private double hours; // likely moved 
    private String gender;
    private double age;
    private Legality legality;
    private double legalBAC;
    private double BAC;
    private BAC_Calculator calc;
    
    public Person() {
        setGender("Male");
        setWeight(this.weight);
        setAge(this.age);
        setNumberOfDrinks(this.numberOfDrinks);
        setHoursSinceLastDrink(this.hours);
    }   
    
    public Person(String gender, double weight, double age, 
            double drinks, double hours) {
        setGender(gender);
        setWeight(weight);
        setAge(age);
        setNumberOfDrinks(drinks);
        setHoursSinceLastDrink(hours);
        calc = new BAC_Calculator(this);
        setBAC();
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
            weight = 0;
        }
        this.weight = weight;
    }
    
    private void setAge(double age) {
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
    
    private void setBAC() {
        this.BAC = calc.getBAC();
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
        return BAC;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public String getGender() {
        return gender;
    }
    
    public double getAge() {
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
        
        private final double AGE;
        private final double LEGAL_BAC;
        
        Legality(double AGE, double LEGAL_BAC) {
            this.AGE = AGE;
            this.LEGAL_BAC = LEGAL_BAC;
        }
        
        public double getLegalBAC() {
            return LEGAL_BAC;
        }
    }

}
