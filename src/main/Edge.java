package main;

/**
 * Created with IntelliJ IDEA.
 * User: jean
 * Date: 11/16/13
 * Time: 3:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Edge {

    private Vertex target;

    private int distance;

    public Edge(Vertex target, int distance) {
        this.target = target;
        this.distance = distance;
    }

    public Vertex getTarget() {
        return target;
    }

    public int getDistance() {
        return distance;
    }
}
