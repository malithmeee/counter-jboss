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
package counter.ejb.message;

import counter.ejb.persistent.*;

import javax.annotation.*;
import javax.ejb.*;
import javax.jms.*;
import java.util.*;

@MessageDriven(
        name = "CountMessageHandler",
        activationConfig = {
                @ActivationConfigProperty( propertyName = "destinationType",
                        propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty( propertyName = "destination",
                        propertyValue ="queue/CountQueue")
        }
)
public class CountMessageBean implements MessageListener {

    @Resource
    private MessageDrivenContext mdctx;

    @EJB
    private RequestCountPersistenceBeanRemote requestCountPersistenceBeanRemote;

    @Override
    public void onMessage(Message message) {
        TextMessage objectMessage = (TextMessage) message;
        try {
            String data = objectMessage.getText();
            System.out.println("Found date request on queue : " + data);
            requestCountPersistenceBeanRemote.addRequestCount(new Date());
        } catch (JMSException e) {
            e.printStackTrace();
            mdctx.setRollbackOnly();
        }
    }
}
