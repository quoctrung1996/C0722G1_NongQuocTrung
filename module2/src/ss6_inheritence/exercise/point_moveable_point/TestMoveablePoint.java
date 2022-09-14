package ss6_inheritence.exercise.point_moveable_point;

public class TestMoveablePoint {
    public static void main(String[] args) {
        MoveablePoint moveablePoint=new MoveablePoint();
        System.out.println(moveablePoint);
        System.out.println(moveablePoint.move());
        MoveablePoint moveablePoint1=new MoveablePoint(1,2,3,4);
        System.out.println(moveablePoint1);
        System.out.println(moveablePoint1.move());
        System.out.println(moveablePoint1.move());
    }

}
