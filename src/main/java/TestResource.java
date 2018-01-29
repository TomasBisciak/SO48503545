

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.inject.Vetoed;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by Tomas Bisciak on 24/1/2018.
 */
@Path("/test")
//@Stateless
public class TestResource {

    @PersistenceContext(unitName = "pu")
    private EntityManager entityManager;

    @GET
    @Path("/dbtest")
    public Response testDb() {
        System.out.println("DBG Invocation of dbtest");
        Person person=new Person("tomas","bisciak");
        entityManager.persist(person); //ALWAYS NULL
        System.out.println("Persisted");
        Person retrievedEntity= entityManager.find(Person.class,1);
        System.out.println("Retrieved entity:"+retrievedEntity);
        return Response.status(Response.Status.OK).build();
    }

}
