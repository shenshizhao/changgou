package com.changgou.goods.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhaowuting
 * @date 2022-04-02 15:52
 */
public class Goods implements Serializable {

    //一个spu
    private Spu spu;

    //多个sku
    private List<Sku> listSku;

    public Spu getSpu() {
        return spu;
    }

    public void setSpu(Spu spu) {
        this.spu = spu;
    }

    public List<Sku> getListSku() {
        return listSku;
    }

    public void setListSku(List<Sku> listSku) {
        this.listSku = listSku;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "spu=" + spu +
                ", listSku=" + listSku +
                '}';
    }
}
