import java.util.ArrayList;
import java.util.List;

public class demo {
    public static void main(String[] args) {

        /*
        когато работим с extend Comparator<L4_BookComparator.Book>, без дженерик за новия клас, Comparator се използва при чужди класов,Comparable при мой или
        такива, до които имам достъп;

        public int compareTo (L4_BookComparator.Book first, L4_BookComparator.Book second){
        if(first.getYear() > second.getYear){
            return 0;
            }else if (first.getYear() > second.getYear()){
            return 1;
            }else{
            return -1;
            }


        public int compareTo(L4_BookComparator.Book book) {
         return compareTo(this.getTitle(), this.getTitle())? -1 : ((this.getYear() == this.getYear())) ? 0 : 1;
           }
          x < y) ? - 1 : (( x = y) ? 0 : 1); х по - малко ли е от y. ako х е по-малко от y върни -1 иначе върни х равен ли е на y ?
           ако да върни 0, ако не 1

       private boolean compareTo(String title, String title1) {
       return title.equals(title1);
        }



//        if (first.getName().length() == second.getName().length()) {
//            if (first.getName().toUpperCase().charAt(0) == second.getName().toUpperCase().charAt(0)) {
//                return 0;
//            } else if (first.getName().toUpperCase().charAt(0) > second.getName().toUpperCase().charAt(0)) {
//                return 1;
//            }
//            return -1;
//        } else if (first.getName().length() - second.getName().length() > 0) {
//            return 1;
//        }
//        return -1;




         */

        List<String> asd = new ArrayList<>(5);
        asd.add("1");
        asd.add("1");
        asd.add("1");
        asd.add("1");
        asd.add("1");
        asd.add("1");
        asd.add("1");
        System.out.println(asd);
    }
}
