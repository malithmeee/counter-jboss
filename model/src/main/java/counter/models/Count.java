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
package counter.models;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
@Table(name="count")
public class Count implements Serializable {

    private Long id;
    private Integer count;
    private Date requestTime;

    public Count() {
    }

    public Count(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Count(Date requestTime, Integer count) {
        this.requestTime = requestTime;
        this.count = count;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
