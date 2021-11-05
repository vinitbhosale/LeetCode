/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    // Time Compleity O(N) N:number of points in the Rectangle and Space Complexity O(1)
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if(!sea.hasShips(topRight, bottomLeft)) return 0;
        
        if(topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) return 1;
        
        int midX = (topRight[0] + bottomLeft[0]) / 2;
        int midY = (topRight[1] + bottomLeft[1]) / 2;
        
        int TopLeft = countShips(sea, new int[]{midX, topRight[1]}, new int[]{bottomLeft[0], midY + 1});
        int TopRight = countShips(sea, topRight, new int[]{midX + 1, midY + 1});
        int BottomLeft = countShips(sea,new int[]{midX, midY},  bottomLeft);
        int BottomRight = countShips(sea, new int[]{topRight[0], midY}, new int[]{midX + 1, bottomLeft[1]});
        
        return TopLeft + TopRight + BottomLeft + BottomRight;
    }
}