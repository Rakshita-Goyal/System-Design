package lld;
interface Database{
    public void save(String data);
}
class MySQLDatabase implements Database{
@Override
public void save (String data){
    System.out.println("in the sql"+ data);
}
}
class MongodbDatabase implements Database{
@Override
public void save(String data){
    System.out.println("in tthe mongo"+data);
}
}
class User{
    private Database db;
    public User(Database db){
this.db=db;
    }
    public void store(String data){
        db.save(data);
    }
}
public class DIPfollowed{
    public static void main(String args[]){
        Database db=new MySQLDatabase();
User user=new User(db);
user.store("hello");

Database db1=new MongodbDatabase();
User us=new User(db1);
us.store("hey ");
    }
}