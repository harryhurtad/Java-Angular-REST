/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsademo.ws.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author fernando
 */
public class InitialContextUtil {

    public static final String PROVIDER_URL = "t3://localhost:7001";
    public static final String INITIAL_CONTEXT_FACTORY = "weblogic.jndi.WLInitialContextFactory";
    
    private static InitialContext initial;

    public static InitialContext getInstance() throws NamingException {
        if (initial == null) {
            initial = new InitialContext();
            initial.addToEnvironment(InitialContext.PROVIDER_URL, PROVIDER_URL);
            initial.addToEnvironment(InitialContext.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
        }
        return initial;
    }

    public static Object lookup(String name) throws NamingException {
        return getInstance().lookup(name);
    }

}
