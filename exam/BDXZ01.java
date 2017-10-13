package exam;


public class BDXZ01
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int findfence(int numHouse, int[][] coordinateList)
    {
        if(coordinateList.length < 5) return coordinateList.length;
        int[][] points = {
                {Integer.MAX_VALUE, 0},
                {Integer.MIN_VALUE, 0},
                {0, Integer.MIN_VALUE},
                {0, Integer.MAX_VALUE}
        };
        for(int i=0; i<coordinateList.length; i++) {
            if(coordinateList[i][0] < points[0][0]) points[0] = coordinateList[i];
            else if(coordinateList[i][0] > points[1][0]) points[1] = coordinateList[i];
            if(coordinateList[i][1] > points[2][1]) points[2] = coordinateList[i];
            else if(coordinateList[i][1] < points[3][1]) points[3] = coordinateList[i];
        }

        return 0;
    }
    // METHOD SIGNATURE ENDS
}
