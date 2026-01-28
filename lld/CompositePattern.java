package lld;
import java.util.ArrayList;
import java.util.List;

interface FileSystemItem {
    void ls();            
    void openAll();      
    int getSize();                  
    FileSystemItem cd(String name); 
    String getName();
    boolean isFolder();
}
class File implements FileSystemItem {
    private String name;
    private int size;

    public File(String n, int s) {
        name = n;
        size = s;
    }
 @Override
    public void ls() {
        System.out.println(name);
    }
    @Override
    public void openAll() {
        System.out.println(name);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public FileSystemItem cd(String name) {
        return null;
    }

        @Override
    public boolean isFolder() {
        return false;
    }

      @Override
    public String getName() {
        return name;
    }


}

class Folder implements FileSystemItem {
    private String name;
    private List<FileSystemItem> children;
  public Folder(String n) {
        name = n;
        children = new ArrayList<>();
    }
    public void add(FileSystemItem item) {
        children.add(item);
    }
     @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isFolder() {
        return true;
    }
     @Override
    public void ls() {
  for (FileSystemItem child : children) {
            if (child.isFolder()) {
                System.out.println(child.getName());
            } else {
                System.out.println(child.getName());
            }
        }
    }

     @Override
    public void openAll() {
for (FileSystemItem child : children) {
            child.openAll();
        }
    }
     @Override
       public FileSystemItem cd(String target) {
 for (FileSystemItem child : children) {
            if (child.isFolder() && child.getName().equals(target)) {
                return child;
            }
        }
        return null;
       }
       @Override
       public int getSize(){
 int total = 0;
        for (FileSystemItem child : children) {
            total += child.getSize();
        }
        return total;
       }

}
public class CompositePattern {
    public static void main(String[] args) {

 Folder root = new Folder("root");
        root.add(new File("file1.txt", 1));
        root.add(new File("file2.txt", 1));

        Folder docs = new Folder("docs");
        docs.add(new File("resume.pdf", 1));
        docs.add(new File("notes.txt", 1));
        root.add(docs);

        Folder images = new Folder("images");
        images.add(new File("photo.jpg", 1));
        root.add(images);

        root.ls();

        docs.ls();

        root.openAll();

        FileSystemItem cwd = root.cd("docs");
        if (cwd != null) {
            cwd.ls();
        } else {
            System.out.println("\nCould not cd into docs\n");
        }

        System.out.println(root.getSize());
    }
}