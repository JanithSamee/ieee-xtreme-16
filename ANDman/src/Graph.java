import java.util.HashSet;
import java.util.Set;

public class Graph {

    public Set<Node> getNodes() {
        return nodes;
    }

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public void printNodes() {
        for (Node n: nodes
             ) {
            System.out.println(n.getShortestPath());
        }
    }
}