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
package counter.service.impl;

import counter.ejb.persistent.*;
import counter.service.*;

import javax.ejb.*;

@Stateless
public class RequestCountService implements RequestCountServiceLocal {

    @EJB
    private RequestCountPersistenceBeanRemote requestCountPersistenceBeanRemote;

    @Override
    public int getRequestCount() {
        return requestCountPersistenceBeanRemote.getRequestCount();
    }

    @Override
    public int getCount() {
        return getRequestCount();
    }
}
