package TheDevineHospital.EntityClasses.Patients.BehaviorUsingStrategyPattern;

public class CantTalking implements TalkBehavior {
    @Override
    public void talk() {
        System.out.println("Из-за стоматита не могу говорить, увы ;(");
    }
}
