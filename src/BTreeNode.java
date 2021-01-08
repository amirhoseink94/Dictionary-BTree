import javafx.scene.control.PasswordField;

import java.util.ArrayList;

class BTreeNode {
    boolean isRoot;
    private int size;
    private ArrayList<Data> data;
    private ArrayList<BTreeNode> child;
    private BTreeNode father;
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public ArrayList<Data> getData() {
        return data;
    }
    public void setData(ArrayList<Data> data) {
        this.data =new ArrayList<Data>(data);
    }
    public ArrayList<BTreeNode> getChild() {
        return child;
    }
    public void setChild(ArrayList<BTreeNode> child) {
        this.child = new ArrayList<BTreeNode>(child);
    }
    public BTreeNode getFather() {
        return father;
    }
    public void setFather(BTreeNode father) {
        this.father = father;
    }
    BTreeNode(int n)
    {
        size=n;
        data=new ArrayList<Data>();
        child=new ArrayList<BTreeNode>();
        father=null;
        isRoot=true;
    }
    BTreeNode insert(Data d,int k)
    {
        data.add(k,d);
        child.add(k, null);
        if(data.size()>=size) return this;
        return null;
    }
    BTreeNode split()
    {
        BTreeNode nb=new BTreeNode(size);
        int cons=data.size()/2;
        while(data.size()>cons+1)
        {
            nb.getData().add(data.get(cons+1));
            data.remove(cons+1);
            nb.getChild().add(child.get(cons+1));
            child.remove(cons+1);
        }
        nb.getChild().add(child.get(cons+1));
        child.remove(cons+1);
        data.remove(cons);
        return nb;
    }
    void printNode()
    {
        for(int i=0;i<data.size();i++)
            System.out.println(data.get(i).getData()+"------"+data.get(i).getMean());
        System.out.println("////////*end of node*\\\\\\\\\\\\\\\\"+"  $$$"+data.size()+" /"+child.size());
    }

}
