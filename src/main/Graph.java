package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jean
 * Date: 11/16/13
 * Time: 3:11 PM
 * To change this template use File | Settings | File Templates.
 */

public class Graph {

    private List<Vertex> vertices = new ArrayList<Vertex>();

    private Vertex destination;
    private Vertex departure;

    private Vertex currentVertex;

    private List<Vertex> temporaryList = new ArrayList<Vertex>();

    public Graph(Vertex... vertices) {
        this.vertices.addAll(Arrays.asList(vertices));
    }

    public void initGetDistance(String from, String to){


        for (Vertex vertex : vertices) {
            if ((vertex.getName()).equals(from)) {
                departure = vertex;
            }
            if ((vertex.getName()).equals(to)) {
                destination = vertex;
            }
            vertex.setDist(-1);
            vertex.setVisited(false);
        }

    }

    public void VertexWithSmallestDist(){

        int smallest = temporaryList.get(0).getDist();
        for (Vertex vertexInTemporaryList : temporaryList) {

            if ((vertexInTemporaryList.getDist()>=0) && (vertexInTemporaryList.getDist() <= smallest) && (!vertexInTemporaryList.isVisited())) {
                currentVertex = vertexInTemporaryList;
            }
        }
    }

    public void algorithmLoop(){
        for (int count = 0; count<currentVertex.getEdges().size(); count++)
        {
            int alt = currentVertex.getDist() + currentVertex.getEdges().get(count).getDistance();

            if (((alt < currentVertex.getEdges().get(count).getTarget().getDist()) || (currentVertex.getEdges().get(count).getTarget().getDist() == -1)) && (!currentVertex.getEdges().get(count).getTarget().isVisited()))
            {
                currentVertex.getEdges().get(count).getTarget().setDist(alt);
                temporaryList.add(currentVertex.getEdges().get(count).getTarget());
            }
        }
    }

    public int getDistance(String from, String to) {

        initGetDistance(from, to);

        if (!(destination == null) && !(departure == null))   //Check if Vertices exist
        {
            departure.setDist(0);
            temporaryList.add(departure);

            while (temporaryList.size() != 0)
            {

                VertexWithSmallestDist();
                if (currentVertex.equals(destination)){
                    return currentVertex.getDist();
                }
                temporaryList.remove(currentVertex);
                currentVertex.setVisited(true);

                algorithmLoop();

            }
            if (currentVertex.equals(destination))
            {
                return currentVertex.getDist();
            }
            else{
                return 0;
            }
        }
        else{
            return 0;
        }
    }
}
