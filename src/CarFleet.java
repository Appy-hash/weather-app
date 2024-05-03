import java.util.*;

public class CarFleet {


    public static int carFleet(int target, int[] position, int[] speed) {
        Stack<Car> stack = new Stack<>();
        Car car;
        List<Car> carList = new ArrayList<>();
        for(int i = 0 ; i < position.length ; i++){
            car = new Car(position[i], speed[i]);
            carList.add(car);
        }

        Collections.sort(carList, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.pos - o2.pos;
            }
        });

        int i = carList.size() -1;
        while(i >= 0){
            if(stack.isEmpty()){
                stack.push(carList.get(i));
            }else{
                Car top = stack.peek();
                stack.push(carList.get(i));
                double time1 = (double)(target - carList.get(i).pos)/carList.get(i).speed;
                double time2 = (double) (target - top.pos)/top.speed;
                if( time1 <= time2){
                    stack.pop();
                }


            }
            i--;
        }
        return stack.size();

    }


    public static void main(String [] args){
        System.out.println(carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));
        System.out.println(carFleet(10, new int[]{3}, new int[]{3}));

        System.out.println(carFleet(100, new int[]{0,2,4}, new int[]{4,2,1}));

    }
}


class Car{

    int pos;
    int speed;

    Car(int pos , int speed){
        this.pos = pos;
        this.speed = speed;
    }


}
