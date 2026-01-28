package lld;
interface Image{
void display();
}
class RealImage implements Image {
private String filename;

    public RealImage(String file) {
        this.filename = file;
        System.out.println("[RealImage] Loading image from disk: " + filename);
    }

    @Override
    public void display() {
        System.out.println("[RealImage] Displaying " + filename);
    }
}
class Proxy implements Image{
private RealImage realImage;
private String filename;
 public Proxy(String file) {
        this.filename = file;
        this.realImage = null;
    }
 @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }

}

public class ProxyVirtual{
    public static void main(String args[]){
Image img=new Proxy("helooo");
img.display();
img.display();
    }
}