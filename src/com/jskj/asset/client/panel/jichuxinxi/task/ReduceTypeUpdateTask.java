/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jskj.asset.client.panel.jichuxinxi.task;

import com.jskj.asset.client.bean.entity.ReduceTypetb;
import com.jskj.asset.client.constants.Constants;
import com.jskj.asset.client.layout.BaseTask;
import com.jskj.asset.client.util.BeanFactory;
import org.apache.log4j.Logger;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author huiqi
 */
public class ReduceTypeUpdateTask extends BaseTask{
    private static final Logger logger = Logger.getLogger(ReduceTypeUpdateTask.class);
    public final static int ENTITY_SAVE = 0;
    public final static int ENTITY_UPDATE = 1;
    public final static int ENTITY_DELETE = 2;
    private final String ADD_URI = Constants.HTTP + Constants.APPID + "reduceType/add";
    private final String UPD_URI = Constants.HTTP + Constants.APPID + "reduceType/update";
    private final String delete_URI = Constants.HTTP + Constants.APPID + "reduceType/delete";
    
    private final ReduceTypetb reduceType;
    private final int actionType;

    public ReduceTypeUpdateTask(ReduceTypetb reduceType, int actionType) {
        this.reduceType = reduceType;
        this.actionType = actionType;
    }
    
    

    @Override
    public Object doBackgrounp() {
         try {
            if (actionType == ENTITY_SAVE) {
                restTemplate.postForObject(ADD_URI, reduceType, ReduceTypetb.class);
            } else if (actionType == ENTITY_UPDATE) {
                restTemplate.postForObject(UPD_URI, reduceType, ReduceTypetb.class);
            } else if (actionType == ENTITY_DELETE) {
                restTemplate.postForLocation(delete_URI + "/" + reduceType.getReducetypeId(),null);
            }
        } catch (RestClientException e) {
            logger.error(e);
            return e;
        }

        return STATUS_OK;
    }

    @Override
    public void onSucceeded(Object object) {
    }
    
}
