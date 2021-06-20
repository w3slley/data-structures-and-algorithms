class LibBTree {//used to read binary tree
    
   public static BTree<Integer> readIntTree(Scanner in) {
      BTree<Integer> t = new BTree<Integer>();
      t.setRoot(readIntNode(in));
      return t;
   }
   
   private static BTNode<Integer> readIntNode(Scanner in) {
      String s = in.next();
      System.out.println(s);
      if (s.equals("N")) return null;
      Integer value = Integer.parseInt(s);
      BTNode<Integer> left = readIntNode(in);
      BTNode<Integer> right = readIntNode(in);
      return new BTNode<Integer>(value, left, right);
   }
}
