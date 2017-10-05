/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsademo.remote;

import java.util.List;
import javax.ejb.Remote;
import wsademo.entity.Entidad;

/**
 *
 * @author fernando
 */
@Remote
public interface EntidadBeanRemote {

    List<Entidad> find();
    
    Entidad find(Integer id);
}
