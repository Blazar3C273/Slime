package com.a.stepanenko.slime.octree;

import com.a.stepanenko.slime.Dot;
import org.apache.log4j.Logger;

import java.util.ArrayList;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 12.05.2015.
 */
public class Node {
    private static final Logger log = Logger.getLogger(Node.class);
    private static final short MAX_DEEP_LEVEL = 10; //TODO: tweak this value.
    public final float length;
    public final Dot center;
    private Node parent,node0, node1, node2, node3, node4, node5, node6, node7;
    private NodeType type;

    /**
     * @param parent Node parent
     * @param number node number, n = [0..7]
     * @param deep */
    public Node(NodeType nodeType, Node parent, short number, ArrayList<Dot> vertices, short deep) throws Exception {
        this.type = nodeType;
        this.length = parent.length / 2;
        this.center = calculateNodeCenter(parent,number);
        this.parent = parent;
//        if (getNodeType()==NodeType.GRAY && deep < MAX_DEEP_LEVEL){
//            //create sub module
//        }
    }

    private static NodeType getNodeType(ArrayList<Dot> vertices, Dot center,float length){
        //определить есть ли признак 1-вершины внутри
            //сортировать координаты и искать в диапазоне куба.
            //диапазон куба:center.x+-node.length,center.y+-node.length,center.z+-length
        //определить есть ли признак 2-пересекающие плоскость полигоны
            //попробовать найти точки пересечения грани полигона и плоскостей куба
                //решить систему уравнений

            return null;
    }

    private static Dot calculateNodeCenter(Node parent, short number) throws Exception {
        Dot parentCenter = parent.center;
        float shift = parent.length/4;
        switch (number){
            case (0):
                return new Dot(parentCenter.x-shift,parentCenter.y-shift,parentCenter.z+shift);
            case (1):
                return new Dot(parentCenter.x+shift,parentCenter.y-shift,parentCenter.z+shift);
            case (2):
                return new Dot(parentCenter.x-shift,parentCenter.y+shift,parentCenter.z+shift);
            case (3):
                return new Dot(parentCenter.x+shift,parentCenter.y+shift,parentCenter.z+shift);
            case (4):
                return new Dot(parentCenter.x-shift,parentCenter.y-shift,parentCenter.z-shift);
            case (5):
                return new Dot(parentCenter.x+shift,parentCenter.y-shift,parentCenter.z-shift);
            case (6):
                return new Dot(parentCenter.x-shift,parentCenter.y+shift,parentCenter.z-shift);
            case (7):
                return new Dot(parentCenter.x+shift,parentCenter.y+shift,parentCenter.z-shift);
            default:
                    throw new Exception("Wrong node number. Must be from 0 to 7");
        }
    }


    public NodeType getType() {
        return type;
    }

    public void setType(NodeType type) {
        this.type = type;
    }

    public enum NodeType {WHITE,BLACK,GRAY}
}
