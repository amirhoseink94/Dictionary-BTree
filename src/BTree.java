class BTree {
    public BTreeNode getRoot() {
        return root;
    }

    public void setRoot(BTreeNode root) {
        this.root = root;
    }

    private BTreeNode root;
    private int size;
    BTree(int size)
    {
        root=new BTreeNode(size);
        this.size=size;
    }
    void insert(Data d)
    {
        inserting(root,d);
    }
    private void inserting(BTreeNode where,Data d)
    {
        if(where.getChild().size()==0)
            where.getChild().add(null);
        int k=0;
        BTreeNode checking=null;
        while(k<where.getData().size()&&where.getData().get(k).compareTo(d)<0)
            k++;

        if(where.getChild().get(k)==null)
        {
            checking=where.insert(d,k);
        }
        else
            inserting(where.getChild().get(k), d);
        if(checking!=null)
            reStructure(checking);
    }
    private void reStructure(BTreeNode wrong)
    {
        Data middle=wrong.getData().get(wrong.getData().size()/2);
        if(wrong==root)
        {
            BTreeNode nb=wrong.split();
            BTreeNode lchild=new BTreeNode(size);
            BTreeNode rchild=new BTreeNode(size);
            lchild.setData(wrong.getData());
            lchild.setChild(wrong.getChild());


            rchild.setChild(nb.getChild());
            rchild.setData(nb.getData());
            wrong.getData().clear();
            wrong.getChild().clear();
            wrong.getData().add(middle);
            wrong.getChild().add(lchild);

            wrong.getChild().add(rchild);
            rchild.setFather(wrong);
            lchild.setFather(wrong);
            root=wrong;
        }
        else
        {

             int k=0;
            while(k<wrong.getFather().getData().size()&&wrong.getFather().getData().get(k).compareTo(middle)<0)
                k++;
            BTreeNode checking=wrong.getFather().insert(middle,k);
            BTreeNode nb=wrong.split();
            nb.setFather(wrong);


            wrong.getFather().getChild().set(k, nb);
            if(checking!=null) reStructure(checking);
        }
    }
    Data search(String word)
    {
        return searching(root,word);
    }
    private Data searching(BTreeNode where,String word)
    {
        int l=0,h=where.getData().size(),m=(h+l)/2;
        while(l<=h)
        {
            where.printNode();
            //System.out.println("middle is: "+where.getData().get(m).getData());
            if (h-l<=1&&m<where.getData().size()&&word.compareTo(where.getData().get(m).getData())!=0)
            {
                System.out.println("#1");
                if(word.compareTo(where.getData().get(m).getData())<0&&where.getChild().get(m)!=null){
                    System.out.println("#11");
                    return searching(where.getChild().get(m),word);
                }
                else if(word.compareTo(where.getData().get(m).getData())>0&&where.getChild().get(m+1)!=null) {
                    System.out.println("#12");
                    return searching(where.getChild().get(m+1),word);
                }
                else return null;
            }
            else if(m<where.getData().size()&&word.compareTo(where.getData().get(m).getData())<0)
            {
                System.out.println("#2");
                h=m-1;
                m=(h+l)/2;
            }
            else if(m<where.getData().size()&&word.compareTo(where.getData().get(m).getData())>0)
            {
                System.out.println("#3");
                l=m+1;
                m=(h+l)/2;
            }
            else if(m<where.getData().size()&&word.compareTo(where.getData().get(m).getData())==0) {
                System.out.println("#4");
                return where.getData().get(m);
            }
            else return null;
        }
        return null;
    }
}
