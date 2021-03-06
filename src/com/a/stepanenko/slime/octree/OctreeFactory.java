package com.a.stepanenko.slime.octree;

import com.a.stepanenko.slime.Cube;
import com.a.stepanenko.slime.Dot;
import org.apache.log4j.Logger;

import java.util.ArrayList;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 15.05.2015.
 */
public class OctreeFactory {
    static final short MAX_DEEP_LEVEL = 5; //TODO: tweak this value.
    private static final Logger log = Logger.getLogger(OctreeFactory.class);

    public static Octree makeOctree(ArrayList<Dot> vertices, String fileName) throws Exception {
        Octree result = new Octree();
        Cube surroundingCube = getSurroundingCube(vertices);
        ArrayList<Polygon> polygons = new ArrayList<>();

        for (int i = 0; i < vertices.size() / 3; i++) {
            polygons.add(new Polygon(new Dot[]{vertices.get(3 * i), vertices.get(3 * i + 1), vertices.get(3 * i + 2)}));
        }

        Node rootNode = new Node(Node.Type.GRAY, null, MAX_DEEP_LEVEL, surroundingCube.getCubeCenter(), ((float) surroundingCube.edgeLength));

        result.setRoot(rootNode);
        ArrayList<Node> pool = new ArrayList<>();
        pool.add(rootNode);
        ArrayList<Node> toRemovePool = new ArrayList<>();
        ArrayList<Node> newPool = new ArrayList<>();

        while (!pool.isEmpty()) {
            pool.parallelStream().forEach(node -> {
                try {
                    generateChildNodes(polygons, node, newPool);
                    toRemovePool.add(node);
                } catch (Exception e) {
                    log.error(e);
                }
            });
            pool.removeAll(toRemovePool);
            toRemovePool.clear();
            pool.addAll(newPool);
            newPool.clear();
        }
        result.setFileName(fileName);
        return result;
    }

    private static void generateChildNodes(ArrayList<Polygon> polygons, Node parentNode, ArrayList<Node> pool) throws Exception {
        if (parentNode.getType() == Node.Type.GRAY && parentNode.getDeepLevel() >= 0) {
            ArrayList<Node> nodes = new ArrayList<>();
            parentNode.setChildNodes(nodes);
            for (short i = 0; i < 8; i++) {
                Dot center = calculateNodeCenter(parentNode, i);
                float length = parentNode.length / 2;
                Node.Type type = getNodeType(polygons, center, length);
                if (type == Node.Type.GRAY && parentNode.getDeepLevel() == 1)
                    type = Node.Type.BLACK;
                nodes.add(new Node(type,
                        parentNode,
                        (short) (parentNode.getDeepLevel() - 1),
                        center,
                        length));
            }
            nodes.parallelStream().filter(node -> node.getType() == Node.Type.GRAY).forEach(node1 -> {
                synchronized (pool) {
                    if (node1 != null) pool.add(node1);
                }
            });

        }
    }

    public static Cube getSurroundingCube(ArrayList<Dot> in_vertexes) {
        ArrayList<Dot> vertexes = new ArrayList<>(in_vertexes);
        Double xMin, xMax, yMin, yMax, zMin, zMax;
        vertexes.sort((o1, o2) -> o1.x.compareTo(o2.x));
        xMin = vertexes.get(0).x;
        xMax = vertexes.get(vertexes.size() - 1).x;
        vertexes.sort(((o1, o2) -> o1.y.compareTo(o2.y)));
        yMin = vertexes.get(0).y;
        yMax = vertexes.get(vertexes.size() - 1).y;
        vertexes.sort(((o1, o2) -> o1.z.compareTo(o2.z)));
        zMin = vertexes.get(0).z;
        zMax = vertexes.get(vertexes.size() - 1).z;

        return new Cube((new Dot(xMax, yMax, zMax)),
                new Dot(xMin, yMin, zMin));
    }

    public static Node.Type getNodeType(ArrayList<Polygon> polygons, Dot center, float length) {
        float[] boxhalfsize = {length / 2, length / 2, length / 2,};
        float[] dotAsFloat = center.getDotAsFloat();
        if (polygons.parallelStream().anyMatch(polygon -> TriangleCubeOverlapTester.triBoxOverlap(dotAsFloat, boxhalfsize, polygon.getDotsAsFloat())))
                return Node.Type.GRAY;
        return Node.Type.WHITE;
    }

    public static Dot calculateNodeCenter(Node parent, short number) throws Exception {
        Dot parentCenter = parent.center;
        float shift = parent.length / 4;
        switch (number) {
            case (0):
                return new Dot(parentCenter.x - shift, parentCenter.y - shift, parentCenter.z + shift);
            case (1):
                return new Dot(parentCenter.x + shift, parentCenter.y - shift, parentCenter.z + shift);
            case (2):
                return new Dot(parentCenter.x - shift, parentCenter.y + shift, parentCenter.z + shift);
            case (3):
                return new Dot(parentCenter.x + shift, parentCenter.y + shift, parentCenter.z + shift);
            case (4):
                return new Dot(parentCenter.x - shift, parentCenter.y - shift, parentCenter.z - shift);
            case (5):
                return new Dot(parentCenter.x + shift, parentCenter.y - shift, parentCenter.z - shift);
            case (6):
                return new Dot(parentCenter.x - shift, parentCenter.y + shift, parentCenter.z - shift);
            case (7):
                return new Dot(parentCenter.x + shift, parentCenter.y + shift, parentCenter.z - shift);
            default:
                throw new Exception("Wrong node number. Must be from 0 to 7");
        }
    }

    public static ArrayList<Node> getNodesAsArrayList(Octree octree) {
        ArrayList<Node> nodes = new ArrayList<>();

        nodes.add(octree.getRoot());

        int previousIterationArraySize = 0;

        while (previousIterationArraySize != nodes.size()) {
            int tmp = previousIterationArraySize;

            previousIterationArraySize = nodes.size();

            for (int i = tmp; i < previousIterationArraySize; i++) {
                Node localNode = nodes.get(i);
                nodes.addAll(localNode.getChildNodes() == null ? new ArrayList<>() : localNode.getChildNodes());
            }
        }
        return nodes;
    }
}
