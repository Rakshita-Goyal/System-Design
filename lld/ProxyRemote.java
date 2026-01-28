package lld;
interface DataService{
void fetchData();
}
class RealDataService implements DataService {
public RealDataService() {
        System.out.println("[RealDataService] Initialized (simulating remote setup)");
    }
    public void fetchData(){
        System.out.println( "[RealDataService] Data from server");
    }
}
class Proxy implements DataService {
private RealDataService real;
public Proxy(){
    real=new RealDataService();
}
 @Override
    public void fetchData() {
        System.out.println("[Proxy] Connecting to remote service...");
         real.fetchData();
    }
}
public class ProxyRemote{
    public static void main(String args[]){
DataService service =new Proxy();
service.fetchData();
    }
}