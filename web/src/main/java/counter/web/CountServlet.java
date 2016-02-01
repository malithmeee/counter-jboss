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

import javax.annotation.*;
import javax.jms.*;
import javax.jms.Queue;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CountServlet extends HttpServlet {

    @Resource(mappedName = "queue/CountQueue")
    private Queue queue;

    @Resource(mappedName = "java:/ConnectionFactory")
    private QueueConnectionFactory queueConnectionFactory;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QueueConnection queueConnection = null;
        try {
            System.out.println(queueConnectionFactory);
            queueConnection = queueConnectionFactory.createQueueConnection();
            queueConnection.start();
            QueueSession queueSession = queueConnection.createQueueSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            QueueSender sender = queueSession.createSender(queue);

            TextMessage msg = queueSession.createTextMessage();
            msg.setText(String.valueOf(new Date()));
            msg.setStringProperty("name", "CountServlet");
            sender.send(msg);
            System.out.println("Message sent Count sending to Queue");
        } catch (JMSException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (queueConnection != null) {
                    queueConnection.close();
                }
            } catch (JMSException e) { //ignore
            }
        }
    }

}
