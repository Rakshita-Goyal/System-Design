//Leaf and group (composite) both follow the same interface
// Component (interface)
// Common interface for both single object and group.
// Leaf
// Single object (cannot contain others)
// Composite
// Group object (contains many components)
// Real-life examples
// File & Folder
// Employee & Department
// Shape & Group of Shapes
// Menu & Submenu
//Composite Design Pattern lets clients treat individual objects and compositions of objects uniformly by using a common interface.

package lld;
import java.lang.*;
import java.util.*;
interface FileSystem{
    void show();
}
//the leaf 
class File implements FileSystem{
    private String name;
    public File(String name){
        this.name=name;

    }
    @Override
    public void show(){
        System.out.println("file is "+name);
    }
}
//the composite one 
class Folder implements FileSystem{
    private String name;
    private List<FileSystem> items = new ArrayList<FileSystem>();
     public Folder(String name){
        this.name=name;
    }
    public void add(FileSystem item){
        items.add(item);
    }
    @Override
    public void show(){
        System.out.println("folder "+name);
        for(FileSystem item:items){
            item.show();
        }
    }
}
public class CompositeDesign{
    public static void main(String args[]){
        FileSystem file1=new File("file1");
        FileSystem file2=new File("file2");

        Folder folder1 =new Folder("folder1");
        folder1.add(file1);
        folder1.add(file2);
        folder1.show();

        Folder folder2=new Folder("folder2");
        folder2.add(folder1);
        folder2.show();
    }
}