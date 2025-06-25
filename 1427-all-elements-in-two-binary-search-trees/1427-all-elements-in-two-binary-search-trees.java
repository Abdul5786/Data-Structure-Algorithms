class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inOrder(root1, list1);
        inOrder(root2, list2);

        List<Integer> res = new ArrayList<>();
        int i=0, j=0;
        while(i<list1.size() && j<list2.size()) {
            if(list1.get(i) < list2.get(j)) {
                res.add(list1.get(i++));
            } else {
                res.add(list2.get(j++));
            }
        }
        while(i<list1.size()) res.add(list1.get(i++));
        while(j<list2.size()) res.add(list2.get(j++));
        return res;
    }
    void inOrder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}