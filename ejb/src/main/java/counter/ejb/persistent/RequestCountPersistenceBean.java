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
package counter.ejb.persistent;

import counter.models.*;

import javax.ejb.*;
import javax.persistence.*;
import java.util.*;

@Stateless
public class RequestCountPersistenceBean implements RequestCountPersistenceBeanRemote {

    @PersistenceContext(unitName = "EjbComponentPU")
    private EntityManager  entityManager;

    @Override
    public void addRequestCount(Date date) {
        List<Count> counts = entityManager.createQuery("from Count").getResultList();
        if (counts != null && !counts.isEmpty()) {
            Count count = counts.get(0);
            count.setCount(count.getCount() + 1);
            count.setRequestTime(new Date());
            entityManager.merge(count);
        } else {
            entityManager.persist(new Count(date, 1));
        }
    }

    @Override
    public int getRequestCount() {
        List<Count> counts = entityManager.createQuery("from Count").getResultList();
        if (counts != null && !counts.isEmpty()) {
            return counts.get(0).getCount();
        }
        return 0;
    }
}
