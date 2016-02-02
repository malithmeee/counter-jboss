/*
 *   (C) Copyright 1996-2016 hSenid Software International (Pvt) Limited.
 *   All Rights Reserved.
 *
 *   These materials are unpublished, proprietary, confidential source code of
 *   hSenid Software International (Pvt) Limited and constitute a TRADE SECRET
 *   of hSenid Software International (Pvt) Limited.
 *
 *   hSenid Software International (Pvt) Limited retains all title to and intellectual
 *   property rights in these materials.
 *
 */
package counter.web;

import counter.service.*;

import javax.annotation.*;
import javax.faces.bean.*;
import javax.naming.*;
import java.io.*;
import java.util.*;

@ManagedBean
@SessionScoped
public class RequestCountManagement {

    private String inputMessage = "";

    private InitialContext ctx;
    private RequestCountServiceLocal counterService;
    private Properties props;

    @PostConstruct
    public void init() {
        props = new Properties();
        try {
            props.load(Thread.currentThread().getContextClassLoader().getResource("jndi.properties").openStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
/*        Hashtable hashtable = new Hashtable();
        hashtable.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        hashtable.put(Context.PROVIDER_URL, "jnp://localhost:1099");
        hashtable.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");*/
        try {
            ctx = new InitialContext(props);
            counterService = (RequestCountServiceLocal) ctx.lookup("counter/RequestCountService/remote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        int count = counterService.getCount();
        System.out.println(count);
    }

    public int getCount() {
        int count = counterService.getCount();
        System.out.println(count);
        return count;
    }

    public String getInputMessage() {
        return inputMessage;
    }

    public void setInputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }
}

