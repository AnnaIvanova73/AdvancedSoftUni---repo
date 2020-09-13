package E2_Box;


public class Box<T> {
    private T data;

    public Box (T data){
        this.data = data;
    }


    @Override
    public String toString(){
        return this.data.getClass().getName() + ": " + this.data;

    }
}
