package TheDevineHospital.EntityClasses.Patients.BehaviorUsingStrategyPattern;

public class CanTalking implements TalkBehavior {
    @Override
    public void talk() {
        System.out.println("Могу разговаривать");
    }
}
