/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsademo.remote;

import javax.ejb.Remote;
import wsademo.util.Reporte;

/**
 *
 * @author nestorarevalo
 */
@Remote
public interface ReporteBeanRemote {
    
    Reporte getReporte(int inicio) throws Exception;    
}
