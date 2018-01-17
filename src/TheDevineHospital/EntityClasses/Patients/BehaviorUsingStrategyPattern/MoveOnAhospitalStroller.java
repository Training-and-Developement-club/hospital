package TheDevineHospital.EntityClasses.Patients.BehaviorUsingStrategyPattern;

public class MoveOnAhospitalStroller implements WalkingBehavior {
    @Override
    public void walking() {
        System.out.println("Передвигаюсь с помощью больничной коляски");
    }
}
