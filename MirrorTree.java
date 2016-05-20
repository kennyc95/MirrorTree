
/*You will fill in the code into the template shown below.
preord produces the 0/1 string from the binary tree.
toString outputs, on two lines, the 0/1 string from tree and the 0/1 string from mirror.
clone clones a binary tree.
mirrorTree(t) creates the mirrored tree corresponding to t. It can do this by modifying the tree (hence the call to clone in the constructor). It should run in time linear in the number of nodes in the tree.
 It is possible to write this code in the classic binary tree style, with a single call to the left subtree, a single call to the right subtree, and no loops, just the recursion.*/
 //Kenny Chen
 //V00825715
public class MirrorTree {

   public BT tree, mirror; // A tree and its mirror

   private char[] a;       // 0/1 array for tree
   private int k;          // used by build()

   MirrorTree( String s ) {
      a = s.toCharArray();
      k = -1;
      tree = build();
      mirror = mirrorTree( clone( tree ) );
   }

   BT build() { return( a[++k] == '0' ? null : new BT( build(), build() )); }
  
   public String preord ( BT t ) {
      if(t == null){
         return "0";
      }
      else{
         return "1" + preord(t.L) + preord(t.R);
      } 
   } 
   
   public String toString() {
      String treeString = preord(tree);
      String mirrorString = preord(mirror);
      
      return treeString + "\n" + mirrorString;
   }

    
   public BT clone( BT t ) {
      BT temp;
      if(t==null ){
         return t;
      }
      else{
         temp = new BT(clone(t.L),clone(t.R));
         
      }
      return temp;
      
   } // FILL IN THE CODE.

   public BT mirrorTree( BT t ) {
     if(t== null){
         return t;
      }
      
      else if(t.L != null){
         t.L = mirrorTree(t.L);
         
      }
          BT holder = mirrorTree(t.R);
          if(holder == null){
            return t;
          }
          BT temp = holder;
         while(holder.R != null){
            holder = holder.R;
         }
         t.R = null;
         holder.R = t;
         return temp;
      
   } // FILL IN THE CODE.
   // YOU CAN OMIT MAIN OR NOT. USE IT FOR TESTING.

   public static void main ( String[] args ) {
      MirrorTree mt = new MirrorTree( args[0] );
     System.out.println( mt+"\ntree and mirror" );
      System.out.println( new MirrorTree( mt.preord( mt.mirror ) ) ); // sanity check
   }
}
class BT {
  BT L; BT R;
  BT( BT l, BT r ) { L = l; R = r; }
}
