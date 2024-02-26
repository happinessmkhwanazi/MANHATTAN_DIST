import java.util.*;

public class Farthest{
    public static void main(String[] args){

        //Initialize Scanner object to read input from the console.
        Scanner input = new Scanner(System.in);

        //Enter the number of points
        System.out.println("Enter the num:");
        int n = input.nextInt();

        // Creates an ArrayList called "list" to store the coordinates of all the points
        List<String> list = new ArrayList<String>();


        input.nextLine();

        //Use a for-loop to "put" the coordinates in the list.
        for(int i=0; i<n; i++){
            String str = input.nextLine();
            list.add(str);
        }

        //Create variables that will be used to keep track of the maximum distance found and the points associated with it.
        double maxDist = Double.MIN_VALUE;
        String point1 = null, point2 = null;


        //Iterates through all pairs of points in the list and calculates the Manhattan distance between each pair using the MDist method.
        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){
                double currDist = MDist(list.get(i),list.get(j));
                if(currDist > maxDist){
                    maxDist = currDist;
                    point1 = list.get(i);
                    point2 = list.get(j);
                }
            }
        }

        //After completing the iteration, prints out the points point1 and point2, which represent the farthest pair of points based on Manhattan distance.
        System.out.println("Farthest pair of points:")
        System.out.println(point1);
        System.out.println(point2);
    }

    public static double MDist(String p1, String p2){

        //Manipulate the data in order to be able to perform the Manhattan Distance formula.
        String[] coords1 = p1.split(" ");
        String[] coords2 = p2.split(" ");

        int x1 = Integer.parseInt(coords1[0]);
        int y1 = Integer.parseInt(coords1[1]);
        int x2 = Integer.parseInt(coords2[0]);
        int y2 = Integer.parseInt(coords2[1]);

        //Formula for calculating Manhattan Distance.
        double dist = (Math.abs(x1 - x2) + Math.abs(y1 - y2));

        return dist;
    }
}
