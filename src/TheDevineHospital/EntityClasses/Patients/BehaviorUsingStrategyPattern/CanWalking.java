package TheDevineHospital.EntityClasses.Patients.BehaviorUsingStrategyPattern;

public class CanWalking implements WalkingBehavior{

    @Override
    public void walking() {
        System.out.println("Здоровые ноги позволяют ходить");
    }
}
