package facebook.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/clone-graph/

// 133

public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return clone(map, node);
    }
    public UndirectedGraphNode clone(Map<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node, clone);
        for (UndirectedGraphNode neighbor: node.neighbors) {
            clone.neighbors.add(clone(map, neighbor));
        }
        return clone;
    }
    
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
