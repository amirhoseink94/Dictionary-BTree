import java.util.*;
import java.io.*;
import java.IOExeption;

public class Dictionary {
    public static void main(String[] args) throws IOExeption
    {
        /*BTree dic=new BTree(4);
        Data a=new Data("ali","hasan dady");
        Data b=new Data("door","dar");
        Data c=new Data("amirhosein","khar");
        Data d=new Data("homayon","?");
        dic.insert(a);
        dic.insert(b);
        dic.insert(c);
        dic.insert(d);
        dic.getRoot().printNode();
        dic.getRoot().getChild().get(0).printNode();
        dic.getRoot().getChild().get(1).printNode();
        Data ansewr=dic.search("door");
        if(ansewr!=null)
            System.out.println(ansewr.getMean());
        else
            System.out.println("nabod!");*/
        decoding decoder=new decoding();
        File file=new File("EXEL-DIC.csv");
        Scanner scan=new Scanner(file);

    }

}
