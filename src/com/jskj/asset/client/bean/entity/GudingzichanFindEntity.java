/*
 * 2014 Chengdu JunChen Technology
 */

package com.jskj.asset.client.bean.entity;

import java.util.List;

/**
 *
 * @author tt
 */
public class GudingzichanFindEntity {
    
    private int count;
    
    private  List<Gudingzichantb> result;

    public int getCount() {
        return count;
    }

    public List<Gudingzichantb> getResult() {
        return result;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setResult(List<Gudingzichantb> result) {
        this.result = result;
    }
    
}