package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jean
 * Date: 11/16/13
 * Time: 3:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Vertex {

    private String name;

    private List<Edge> edges = new ArrayList<Edge>();

    private boolean visited;

    private int dist;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void connectTo(Vertex target, int distance) {
        edges.add(new Edge(target, distance));
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public int getDist() {
        return dist;
    }

    public boolean isVisited() {
        return visited;
    }


}
