package com.a.stepanenko.slime.octree;

import com.a.stepanenko.slime.Dot;
import com.google.gson.annotations.Expose;
import org.apache.log4j.Logger;

import java.util.ArrayList;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 12.05.2015.
 */
public class Node {
    @Expose(serialize = false, deserialize = false)
    private static final Logger log = Logger.getLogger(Node.class);
    public final float length;
    public final Dot center;
    private final Node parent;
    @Expose(serialize = false, deserialize = false)
    private ArrayList<Node> childNodes;
    private Type type;
    private short deepLevel;

    /**
     * @param _parent Node parent
     * //@param nodeIndex node number, n = [0..7]
     * @param deepLevel
     * @param _length  */

    public Node(Type type, Node _parent, short deepLevel, Dot nodeCenter, float _length) {
            this.parent = _parent;
            this.length = _length;
            this.center = nodeCenter;
        this.type = type;
            this.deepLevel = deepLevel;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
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
        return "Node{" + "length=" + length + ", center=" + center + ", type=" + type + ", deepLevel=" + deepLevel + '}';
    }

    public short getDeepLevel() {
        return deepLevel;
    }

    public enum Type {WHITE, BLACK, GRAY}
}
