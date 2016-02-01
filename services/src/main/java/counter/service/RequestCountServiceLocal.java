package counter.service;
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

import javax.ejb.*;
import javax.ws.rs.*;

@Local
public interface RequestCountServiceLocal {

    int getRequestCount();

    @POST
    @Path("/getCount")
    @Produces({"application/xml","application/json"})
    @Consumes({"application/xml","application/json"})
    int getCount();

}
