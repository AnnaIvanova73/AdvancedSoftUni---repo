package L3_GenericScale;

public class Scale<E extends  Comparable<E>>{
    private E left;
    private E right;


    public Scale(E left, E right){
        this.left = left;
        this.right = right;
    }

    public E getHeavier(){

      if(this.left.compareTo(this.right) < 0){
          return right;
      }
      if( this.right.compareTo(this.left) > 0){
          return left;
      }
      return null;
    }
}
