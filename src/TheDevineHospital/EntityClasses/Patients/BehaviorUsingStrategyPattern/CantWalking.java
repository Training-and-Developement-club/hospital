package TheDevineHospital.EntityClasses.Patients.BehaviorUsingStrategyPattern;

public class CantWalking implements WalkingBehavior{
    @Override
    public void walking() {
        System.out.println("Больные ноги не позволяют ходить");
    }
}
