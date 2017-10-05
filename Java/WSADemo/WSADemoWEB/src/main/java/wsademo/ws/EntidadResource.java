/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsademo.ws;

import wsademo.ws.util.WSAMessage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import wsademo.entity.Entidad;
import wsademo.remote.EntidadBeanRemote;
import wsademo.ws.util.HeaderResponseUtil;
import wsademo.ws.util.InitialContextUtil;

/**
 * REST Web Service
 *
 * @author fernando
 */
@Path("/entidad")
public class EntidadResource {

    public static final String JNDI_REMOTE_BEAN = "EntidadBean#wsademo.remote.EntidadBeanRemote";

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WsaResource
     */
    public EntidadResource() {
    }

    /**
     * Retrieves representation of an instance of wsademo.ws.EntidadResource
     *
     * @return an instance of javax.ws.rs.core.Response
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response find() {
        Object result;
        try {
            result = (List<Entidad>) ((EntidadBeanRemote) InitialContextUtil.lookup(JNDI_REMOTE_BEAN)).find();
        } catch (NamingException ex) {
            result = new WSAMessage("error", ex.getMessage());
            Logger.getLogger(EntidadResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return HeaderResponseUtil.ok(result);
    }

    /**
     *
     * @param id Identificador de entidad
     * @return an instance of javax.ws.rs.core.Response
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") Integer id) {
        Object result;
        try {
            result = ((EntidadBeanRemote) InitialContextUtil.lookup(JNDI_REMOTE_BEAN)).find(id);
        } catch (NamingException ex) {
            result = new WSAMessage("error", ex.getMessage());
            Logger.getLogger(EntidadResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return HeaderResponseUtil.ok(result);
    }

//    /**
//     * PUT method for updating or creating an instance of EntidadResource
//     *
//     * @param content representation for the resource
//     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }
}
