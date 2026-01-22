package lld;
//high level shouldnt directly interact with the low modeuls 
class MySQLDatabase{
public void saveToSql(String data){
    System.out.println("the sql will save"+data);
}
}
class MongodbDatabase{
public void saveToMongo(String data){
    System.out.println("the mongo will save "+data);
}
}
class User{
private MySQLDatabase sql=new MySQLDatabase();
private MongodbDatabase db=new MongodbDatabase();
public void storeToSql(String data){
sql.saveToSql(data);
}
public void storeToMongo(String data){
    db.saveToMongo(data);
}
}
public class DIP{
    public static void main(String args[]){
User user=new User();
user.storeToSql("hello");
user.storeToMongo("heuyy");
    }
}