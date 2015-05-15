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
    public final float length;
    public final Dot center;
    private final Node parent;
    private ArrayList<Node> childNodes;
    private NodeType type;
    private short deepLevel;

    /**
     * @param _parent Node parent
     * //@param nodeIndex node number, n = [0..7]
     * @param deepLevel
     * @param _length  */

    public Node(NodeType nodeType, Node _parent,short deepLevel, Dot nodeCenter, float _length) throws Exception {
            this.parent = _parent;
            this.length = _length;
            this.center = nodeCenter;
            this.type = nodeType;
            this.deepLevel = deepLevel;
    }

    public NodeType getType() {
        return type;
    }

    public void setType(NodeType type) {
        this.type = type;
    }

    public ArrayList<Node> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(ArrayList<Node> childNodes) {
        this.childNodes = childNodes;
    }
    public int getNodeNumber(){
        if (childNodes==null)
            return 1;
        else return
                childNodes.parallelStream().
                        parallel().
                        mapToInt(Node::getNodeNumber).
                        reduce((left, right) -> left+right).
                        getAsInt();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Node{").
                append("length=").
                append(length).
                append(", center=").
                append(center).append(", parent=").
                append(parent).
                append(", number of childNodes = ").
                append(getNodeNumber()).
                append(", type=").
                append(type).
                append(", deepLevel=").
                append(deepLevel).
                append('}');
        return builder.toString();
    }

    public short getDeepLevel() {
        return deepLevel;
    }

    public enum NodeType {WHITE,BLACK,GRAY}
}
