/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:07 AM
 * To change this template use File | Settings | File Templates.
 */

package rest;

import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceException;
import com.google.appengine.api.memcache.MemcacheServiceFactory;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import measuring.Array;


@Path("/sort")
public class SortService {


    /**
     * Creates a new instance of SortService
     */
    public SortService() {
    }

    /**
     * Retrieves representation of an instance of measuring.SortService
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Path("/{size}/")
    public String getText(@PathParam("size") String size) {
        Array array = new Array(Integer.parseInt(size));
        array.sort();
        return array.toString();
    }


    @GET
    @Path("/cached/{size}")
    @Produces("text/plain")
    public String cachedOperation(@PathParam("size") String size) {
        String cacheKey = size;
        Array result = null;

        try {
            MemcacheService memcache = MemcacheServiceFactory.getMemcacheService();
            if (memcache.contains(cacheKey)) {
                result = (Array) memcache.get(cacheKey);
                return result.getLastNumber();
            }
        } catch (MemcacheServiceException e) {
            e.printStackTrace();
        }

        result = new Array(Integer.parseInt(size));
        result.sort();

        try {
            MemcacheService memcache = MemcacheServiceFactory.getMemcacheService();
            memcache.put(cacheKey, result);
        } catch (MemcacheServiceException e) {
            e.printStackTrace();

        }
        return result.getLastNumber();
    }
}

