import java.util.ArrayList;
import java.util.List;

public class SILab2 {

    public static List<String> function(List<String> list) {  //start
        if (list.size() <= 0) {  //part1
            throw new IllegalArgumentException("List length should be greater than 0"); // part1.1
        }
        int n = list.size(); //part2.1
        int rootOfN = (int) Math.sqrt(n); //part2.2
        if (rootOfN * rootOfN  != n) { //part 3
            throw new IllegalArgumentException("List length should be a perfect square"); //part 3.1
        }
        List<String> numMines = new ArrayList<>(); //part4
        for (int i = 0 /*i=0*/; i < n/* i<n */; i++ /* i++ */) { // for loop
            if (!list.get(i).equals("#")) { // part 5
                int num = 0; //part5.1
                if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) || (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ) { //part6
                    if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) && (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ) { //part6.1
                        num += 2; //part 6.2
                    }
                    else {
                        num  += 1; //part 6.3
                    }
                }
                if (i - rootOfN >= 0 && list.get(i - rootOfN).equals("#")){ //part 7
                    num++; //part 7.1
                }
                if (i + rootOfN < n && list.get(i + rootOfN).equals("#")){ //part 8
                    num++; //part 8.1
                }
                numMines.add(String.valueOf(num)); // part 9
            }
            else {
                numMines.add(list.get(i)); //part 10
            }
        }
        return numMines; //11
    }
} //end
