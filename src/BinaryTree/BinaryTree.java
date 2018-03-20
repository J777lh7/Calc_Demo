package BinaryTree;
import java.util.ArrayList;  
public class BinaryTree   
{  
      
    private TreeNode root;  //�������ĸ��ڵ�
    private int num;  //������
    private ArrayList<TreeNode> opeList = new ArrayList<TreeNode>();  
    //��ȡ�������Ľ�����
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
      
//��ȡ���յı��ʽ��������CalAndVal()��������� 
 
    public String toString(){  
        String str = root.toString();  
        str = str.substring(1, str.length()-1);  
        return str;  
    }  
      
//���㲢��֤���ʽ 
  
    public String CalAndVal(){  
        return root.getResult();  
    }  
      
//��������������(����)  
 
    public int getDeep(){  
        int i = this.num;  
        int deep = 2;  
        while(i/2 > 0){  
            deep++;  
            i /= 2;  
        }  
        return deep;  
    }  
      
//���ɶ����� 
 
    public void createBTree(){  
        TreeNode lchild, rchild, lnode, rnode;  
        //��ֻ��һ���ڽ�㣬����������Ϊһ�������ҽ������Ϊ��һ�������������ڵ�Ϊ�������
        if(num == 1){  
            lchild = new TreeNode(String.valueOf(Ran.getNumber(100)), null, null);  
            rchild = new TreeNode(String.valueOf(Ran.getNumber(100)), null, null);  
            root = new TreeNode(String.valueOf(Ran.getOperator()), lchild, rchild);  
        }  
        //��ֹһ���������������ڵ����һ���������֮������ҽ������Ϊ����������Щ�ڵ�����ҽڵ�����Ϊ���֡�������Ҷ�ӵĽڵ㰴������������ɵõ���ʽ
        else{  
            int num1 = 0;  
            int n = getDeep() - 3;  
            boolean[] place = Ran.getChildPlace(num);  //�õ��ڵ��λ��
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
