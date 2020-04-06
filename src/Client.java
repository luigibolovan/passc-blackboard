import blackboards.Blackboard;

public class Client {

    public static void main(String[] args){
        FurnitureFactory myFactory = new FurnitureFactory(new Blackboard());
        myFactory.order();
    }
}
