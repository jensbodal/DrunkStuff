package drunkstuff;

/**
 *
 * @author jensb
 */
public class BAC_Calculator {

    private Person person;
    private double BAC;
    private DistributionRatio ratio;
    
    BAC_Calculator(Person person) {
        this.person = person;
        this.BAC = (alcoholAbsorbed() - alcoholMetabolized());
    }
    
    public double getBAC() {
        if (BAC < 0) {
            BAC = 0;
        }
        return BAC;
    }
    
    private double alcoholAbsorbed() {
        double numberOfDrinks = person.getNumberOfDrinks();
        double weight = person.getWeight();
        
        if (person.getGender().equals(DistributionRatio.MALE.getGender())) {
            ratio = DistributionRatio.MALE;
        }
        else {
            ratio = DistributionRatio.FEMALE;
        }
        return (3.701 * numberOfDrinks) / (weight * ratio.getRatio());
    }
    
    private double alcoholMetabolized() {
        return 0.015 * person.getHoursSinceFirstDrink();
    }
    
    private enum DistributionRatio {
        MALE ("MALE", 0.73),
        FEMALE ("FEMALE", 0.66);
        
        String gender;
        double ratio;
        DistributionRatio(String gender, double ratio) {
            this.gender = gender;
            this.ratio = ratio;
        }
        String getGender() {
            return gender;
        }
        double getRatio() {
            return ratio;
        }
    }
}
