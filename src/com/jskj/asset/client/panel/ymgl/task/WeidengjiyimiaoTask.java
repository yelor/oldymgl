/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jskj.asset.client.panel.ymgl.task;

import com.jskj.asset.client.bean.entity.YimiaoshenqingliebiaoEntity;
import com.jskj.asset.client.constants.Constants;
import com.jskj.asset.client.layout.AssetMessage;
import com.jskj.asset.client.layout.BaseTask;
import com.jskj.asset.client.layout.ws.CommFindEntity;
import org.apache.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientException;

/**
 *
 * @author tt
 */
public abstract class WeidengjiyimiaoTask extends BaseTask{

    public static final Logger logger = Logger.getLogger(WeidengjiyimiaoTask.class);
    private final String CX_URI = Constants.HTTP + Constants.APPID + "yimiao/weidengji";
    private String sql;
    private String type;
    
    public WeidengjiyimiaoTask(String sql,String type){
        super();
        this.sql = sql;
        this.type = type;
    }
    
    public WeidengjiyimiaoTask(String sql){
        this(sql,"");
    }
    
    @Override
    public Object doBackgrounp() {
        try{
            CommFindEntity<YimiaoshenqingliebiaoEntity> response = restTemplate.exchange(CX_URI + "?"+ 
                    "type=" + type + "&conditionSql=" + sql,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<CommFindEntity<YimiaoshenqingliebiaoEntity>>() {
                    }).getBody();
            return response;
        }catch (RestClientException e) {
            logger.error(e);
            return e;
        }
    }

    @Override
    public void onSucceeded(Object object) {
        if (object == null) {
            clientView.setStatus("response data is null", AssetMessage.ERROR_MESSAGE);
            return;
        }
        if (object instanceof Exception) {
            Exception e = (Exception) object;
            clientView.setStatus(e.getMessage(), AssetMessage.ERROR_MESSAGE);
            logger.error(e);
            return;
        }
        if (object instanceof CommFindEntity) {
            responseResult((CommFindEntity<YimiaoshenqingliebiaoEntity>) object);
        } else {
            clientView.setStatus("response data is not a valid object", AssetMessage.ERROR_MESSAGE);
        }
    }

    public abstract void responseResult(CommFindEntity<YimiaoshenqingliebiaoEntity> response);
}
