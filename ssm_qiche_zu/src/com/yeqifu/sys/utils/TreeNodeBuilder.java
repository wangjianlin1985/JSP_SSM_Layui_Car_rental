// 
// 
// 

package com.yeqifu.sys.utils;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class TreeNodeBuilder
{
    public static List<TreeNode> builder(final List<TreeNode> nodes, final Integer topPid) {
        final List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        for (final TreeNode n1 : nodes) {
            if (n1.getPid() == topPid) {
                treeNodes.add(n1);
            }
            for (final TreeNode n2 : nodes) {
                if (n2.getPid() == n1.getId()) {
                    n1.getChildren().add(n2);
                }
            }
        }
        return treeNodes;
    }
}
