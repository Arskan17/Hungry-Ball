package classes;

public class Player {
    public int adjustXVelocity(String direction){
        if (direction.equals("right")){
            return 1;
        }
        if (direction.equals("left")){
            return -1;
        }
        return 0;
    }

    public int adjustYVelocity(String direction){
        if (direction.equals("up")){
            return -1;
        }
        if (direction.equals("down")){
            return 1;
        }
        return 0;
    }


}
