/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsademo.ws.util;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author nestorarevalo
 */
public class HeaderResponseUtil {

    public static Response ok(Object entity) {
        return Response.ok(entity, MediaType.APPLICATION_JSON).
                header("Access-Control-Allow-Origin", "*").
                header("Access-Control-Allow-Headers", "Authorization, Origin, X-Requested-With, Content-Type").
                header("Access-Control-Expose-Headers", "Location, Content-Disposition").
                header("Access-Control-Allow-Methods", "POST, PUT, GET, DELETE, HEAD, OPTIONS").build();
    }

}
