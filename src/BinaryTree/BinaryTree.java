package BinaryTree;
import java.util.ArrayList;  
public class BinaryTree   
{  
      
    private TreeNode root;  //二叉树的根节点
    private int num;  //结点个数
    private ArrayList<TreeNode> opeList = new ArrayList<TreeNode>();  
    //获取二叉树的结点个数
    public BinaryTree(int num){  
        this.num = num;  
    }  
      
    public int getNum(){  
        return num;  
    }  
      
    public void setNum(int num){  
        this.num = num;  
    }  
      
    public void setTreeNode(TreeNode root){  
        this.root = root;  
    }  
      
//获取最终的表达式，必须在CalAndVal()方法后调用 
 
    public String toString(){  
        String str = root.toString();  
        str = str.substring(1, str.length()-1);  
        return str;  
    }  
      
//计算并验证表达式 
  
    public String CalAndVal(){  
        return root.getResult();  
    }  
      
//计算二叉树的深度(层数)  
 
    public int getDeep(){  
        int i = this.num;  
        int deep = 2;  
        while(i/2 > 0){  
            deep++;  
            i /= 2;  
        }  
        return deep;  
    }  
      
//生成二叉树 
 
    public void createBTree(){  
        TreeNode lchild, rchild, lnode, rnode;  
        //若只有一个节结点，则将左结点设置为一个数，右结点设置为另一个操作数，根节点为运算符。
        if(num == 1){  
            lchild = new TreeNode(String.valueOf(Ran.getNumber(100)), null, null);  
            rchild = new TreeNode(String.valueOf(Ran.getNumber(100)), null, null);  
            root = new TreeNode(String.valueOf(Ran.getOperator()), lchild, rchild);  
        }  
        //不止一个结点的情况，则根节点产生一个运算符，之后的左右结点设置为操作数，这些节点的左右节点设置为数字。这样从叶子的节点按照中序遍历即可得到等式
        else{  
            int num1 = 0;  
            int n = getDeep() - 3;  
            boolean[] place = Ran.getChildPlace(num);  //得到节点的位置
            root = new TreeNode(String.valueOf(Ran.getOperator()), null, null);  
            opeList.add(root);  
              
            for(int i = 0; i < n; i++){  
                for(int j = 0; j < (int)Math.pow(2, i); j++, num1++){  
                    lchild = new TreeNode(String.valueOf(Ran.getOperator()), null, null);  
                    rchild = new TreeNode(String.valueOf(Ran.getOperator()), null, null);  
                    opeList.get(j + num1).setChild(lchild, rchild);  
                    opeList.add(lchild);  
                    opeList.add(rchild);  
                }  
            }  
              
            for(int i = 0; i < place.length; i++){  
                if(place[i]){  
                    lnode  = new TreeNode(String.valueOf(Ran.getNumber(100)), null, null);  
                    rnode  = new TreeNode(String.valueOf(Ran.getNumber(100)), null, null);  
                    if(i%2 == 0){  
                        lchild = new TreeNode(String.valueOf(Ran.getOperator()), lnode, rnode);  
                        opeList.add(lchild);  
                        opeList.get(num1).setLchild(lchild);  
                    }  
                    else{  
                        rchild = new TreeNode(String.valueOf(Ran.getOperator()), lnode, rnode);  
                        opeList.add(rchild);  
                        opeList.get(num1).setRchild(rchild);  
                    }  
                }  
                else{  
                    if(i%2 == 0){  
                        lchild = new TreeNode(String.valueOf(Ran.getNumber(100)), null, null);  
                        opeList.get(num1).setLchild(lchild);  
                    }  
                    else{  
                          
                        rchild = new TreeNode(String.valueOf(Ran.getNumber(100)), null, null);  
                        opeList.get(num1).setRchild(rchild);  
                    }  
                }  
                num1 = num1 + i%2;  
            }  
        }  
    }  
}  
