import greenfoot.*;

public class Edge {
    private Location locOne;
    private Location locTwo;
    private boolean isShown;

    public Edge(Location l1, Location l2) {
        locOne = l1;
        l1.addEdge(this);
        locTwo = l2;
        l2.addEdge(this);
        isShown = false;
    }
    
    public void show(World w) 
    {
        GreenfootImage bg = w.getBackground();
        bg.setColor( Color.ORANGE );
        bg.drawLine( locOne.getX(), locOne.getY(), 
                     locTwo.getX(), locTwo.getY() );
        isShown = true;
    }
    
    public double getDistance() {
        return Math.sqrt((Math.pow(locTwo.getX() - locOne.getX(), 2) + Math.pow(locTwo.getY() - locOne.getY(), 2)));
    }
    
    public int compareTo(Edge e) {
        return (int) (this.getDistance() - e.getDistance());
    }
    
    public Location getLocOne() {
        return locOne;
    }
    
    public Location getLocTwo() {
        return locTwo;
    }

    public boolean isShown() {
        return isShown;
    }

    public Location getOppositeSide(Location l) {
        if (getLocOne().equals(l)) {
            return getLocTwo();
        } else if (getLocTwo().equals(l)){
            return getLocOne();
        } else {
            return null;
        }
    }
}
