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

    public static Octree makeOctree(ArrayList<Dot> vertices) throws Exception {
        Octree result = new Octree();
        Cube surroundingCube = getSurroundingCube(vertices);
        ArrayList<Polygon> polygons = new ArrayList<>();

        for (int i = 0; i < vertices.size() / 3; i++) {
            polygons.add(new Polygon(new Dot[]{vertices.get(3 * i), vertices.get(3 * i + 1), vertices.get(3 * i + 2)}));
        }

        Node rootNode = new Node(Node.Type.GRAY, null, MAX_DEEP_LEVEL, surroundingCube.getCubeCenter(), ((float) surroundingCube.edgeLength));
        result.setRoot(rootNode);
        generateChildNodes(polygons, rootNode);
        return result;
    }

    private static void generateChildNodes(ArrayList<Polygon> polygons, Node parentNode) throws Exception {
        if (parentNode.getType() == Node.Type.GRAY && parentNode.getDeepLevel() >= 0) {
            ArrayList<Node> nodes = new ArrayList<>();
            parentNode.setChildNodes(nodes);
            for (short i = 0; i < 8; i++) {
                Dot center = calculateNodeCenter(parentNode, i);
                float length = parentNode.length / 4;
                Node.Type type = getNodeType(polygons, center, length);
                if (type == Node.Type.GRAY && parentNode.getDeepLevel() == 1)
                    type = Node.Type.BLACK; // TODO important place. need testing.
                nodes.add(new Node(type,
                        parentNode,
                        (short) (parentNode.getDeepLevel() - 1),
                        center,
                        length));
            }
            nodes.parallelStream().filter(node -> node.getType() == Node.Type.GRAY).parallel().forEach(node1 -> {
                try {
                    generateChildNodes(polygons, node1);
                } catch (Exception e) {
                    log.error("Some exception when algorithm generate nodes.", e);
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
        for (Polygon polygon : polygons) {
            if (TriangleCubeOverlapTester.triBoxOverlap(center.getDotAsFloat(), new float[]{length / 2, length / 2, length / 2,}, polygon.getDotsAsFloat())) {
                return Node.Type.GRAY;
            }
        }

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
}
