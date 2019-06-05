/*
 * Carlos Steven Portilla Botero
 * 1015473300
 * Ing. Sistemas y telecomunicaciones 
 *   * 
 */
package resources;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ZooDog")
public class ZooDogService {

    private final static String HOST = "localhost";
    private final static int PORT = 27017;
    private DB mongo = null;

    public void Conectar() {

        try {
            MongoClient mongoClient = new MongoClient(HOST, PORT);
            mongo = mongoClient.getDB("ZooDog");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getDogs() {

        Conectar();
        ArrayList<String> array = new ArrayList<>();
        try {
            DBCollection coll = mongo.getCollection("Dogs");
            DBCursor cursor = coll.find();
            try {
                while (cursor.hasNext()) {
                    DBObject object = cursor.next();
                    System.out.println(object.toString());
                    array.add(object.toString());
                }
                return array.toString();
            } finally {
                cursor.close();
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return "There are no dogs registered in the database";
    }

    @GET
    @Path("/comment")
    @Produces({MediaType.APPLICATION_JSON})
    public String getComments() {
        Conectar();
        ArrayList<String> array = new ArrayList<>();
        try {
            DBCollection coll = mongo.getCollection("comments");
            DBCursor cursor = coll.find();
            try {
                while (cursor.hasNext()) {
                    DBObject object = cursor.next();
                    System.out.println(object.toString());
                    array.add(object.toString());
                }
                return array.toString();
            } finally {
                cursor.close();
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return "There are no comments";
    }

    @POST
    @Path("/comment")
    @Produces({MediaType.APPLICATION_JSON})
    public String setComments(String comment) {
        Conectar();
        try {
            DBCollection coll = mongo.getCollection("comments");
            DBObject query = new BasicDBObject("comment", comment);
            System.out.println(query.toString());
            coll.insert(query);
        } catch (Exception e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return "Inserted on database";
    }
}
