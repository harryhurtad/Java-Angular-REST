/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsademo.ws;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import wsademo.remote.ReporteBeanRemote;
import wsademo.ws.util.HeaderResponseUtil;
import wsademo.ws.util.InitialContextUtil;
import wsademo.ws.util.WSAMessage;

/**
 * REST Web Service
 *
 * @author nestorarevalo
 */
@Path("/reporte")
public class ReporteResource {

    public static final String JNDI_REMOTE_BEAN = "ReporteBean#wsademo.remote.ReporteBeanRemote";

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ReportResource
     */
    public ReporteResource() {
    }

    /**
     * Retrieves representation of an instance of wsademo.ws.ReporteResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object
        Object result;
        try {
            result = ((ReporteBeanRemote) InitialContextUtil.lookup(JNDI_REMOTE_BEAN)).find();
        } catch (Exception ex) {
            result = new WSAMessage("error", ex.getMessage());
            Logger.getLogger(EntidadResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return HeaderResponseUtil.ok(result);
    }

    /**
     * PUT method for updating or creating an instance of ReporteResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
