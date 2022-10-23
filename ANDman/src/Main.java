import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        byte numOftestCases= sc.nextByte();
        for (int _i = 0; _i < numOftestCases; _i++) {

        ArrayList<Node> nodes= new ArrayList<Node>();
            int size = sc.nextInt();

            //add weights and nodes
            for (int item = 0; item < size; item++) {
                Node _node = new Node(String.valueOf(item+1),sc.nextInt());
                nodes.add(_node);
            }
            //add destinations
            for (int item = 0; item < size-1; item++) {
               Node startNode = nodes.get(sc.nextByte()-1);
               Node endNode = nodes.get(sc.nextByte()-1);
               addDestinations(startNode,endNode);
            } 
            
            //add to graph
            
            Graph graph=new Graph();
            for (Node n:nodes
                 ) {
                graph.addNode(n);
            }
            
            
            //get shotest path
           int q =sc.nextInt();
//
//            System.out.println(nodes);
//            Graph sp= calculateShortestPathFromSource(graph,nodes.get(2));
//            sp.printNodes();
//            Node endNode =nodes.get(4);
//            long total=endNode.getValue();
//            String _a=endNode.getName();
//            for (Node _n: endNode.getShortestPath()
//            ) {
//                _a+=("->"+_n.getName());
//                total*=_n.getValue();
//            }
//            System.out.println(_a);

            for (int _q = 0; _q < q; _q++) {
                byte op =sc.nextByte();
                if(op==2){
                    Node _sn =nodes.get(sc.nextInt()-1);
                    Node _en =nodes.get(sc.nextInt()-1);
//                    System.out.print(sc.nextInt());
//                    System.out.print("--");
//                    System.out.println(sc.nextInt());
                        calcuateCost(graph,_sn,_en);

                }else{
                    int _sn =sc.nextInt();
                    int _val =sc.nextInt();
                    nodes.get(_sn).setValue(_val);

                }


            }


        }
    }

    public static void addDestinations(Node startNode,Node endNode){
        startNode.addDestination(endNode,1);
    }

    public static void calcuateCost(Graph graph,Node startNode,Node endNode){
       calculateShortestPathFromSource(graph,startNode);
        long total=endNode.getValue();
        for (Node _n: endNode.getShortestPath()
        ) {
            total*=_n.getValue();
        }
        System.out.println(total);
    }

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry< Node, Integer> adjacencyPair:
                    currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static Node getLowestDistanceNode(Set < Node > unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Node evaluationNode,
                                                 Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

}
