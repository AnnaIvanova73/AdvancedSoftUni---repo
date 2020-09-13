package E1_Box;

public class Box<T> {
    private T data;

    public Box(T type) {
        this.data = type;
    }


    @Override

    public String toString (){
        return this.data.getClass().getName() + ": " + this.data;
    }

}
