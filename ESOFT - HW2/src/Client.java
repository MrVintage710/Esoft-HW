public class Client {

    //database instance, by default NoSQL
    public static Database db = new NoSQLDatabase();

    public static void main(String[] args) {
        //First we store as a NoSQL database
        db.store();

        //Second we change the database type and store again, this time using a different strategy.
        setStoreStrategy(new RelationalDatabase());
        db.store();

        //Rinse and repeat for the third strategy.
        setStoreStrategy(new GraphDatabase());
        db.store();
    }

    //This method changes the database type at runtime, and will say the type to log.
    public static void setStoreStrategy(Database database) {
        if(database instanceof NoSQLDatabase) {
            System.out.println("Switch Database to NoSQL.");
        } else if(database instanceof RelationalDatabase) {
            System.out.println("Switch Database to Relational.");
        } else if(database instanceof GraphDatabase) {
            System.out.println("Switch Database to Graph.");
        }
        Client.db = database;
    }
}

abstract class Database {

    //The method used when storing information
    public abstract void store();
}

class RelationalDatabase extends Database {

    @Override
    public void store() {
        tableStore();
    }

    public void tableStore() {
        System.out.println("Storing using the Relational strategy.");
    }
}

class NoSQLDatabase extends Database {

    @Override
    public void store() {
        documentStore();
    }

    public void documentStore() {
        System.out.println("Storing using the NoSQL strategy");
    }
}

class GraphDatabase extends Database {

    @Override
    public void store() {
        nodeStore();
    }

    public void nodeStore() {
        System.out.println("Storing using the Graph strategy");
    }
}
