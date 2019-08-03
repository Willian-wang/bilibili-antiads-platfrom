package com.heiyu.bilibiliantiadsplatfrom.Domain;

import com.heiyu.bilibiliantiadsplatfrom.Common.IdGenerator;

import java.sql.Timestamp;

/**
 * @ClassName: BasicEntity
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 16:38 2019/7/20
 * @Version: 1.0
 **/

public class BasicEntity {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isRemove() {
        return remove;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }

    public static void setBasicInf(BasicEntity basicInf){
        basicInf.setCreateTime(new java.sql.Timestamp(System.currentTimeMillis()));
        basicInf.setUpdateTime(new java.sql.Timestamp(System.currentTimeMillis()));
        basicInf.setId(IdGenerator.getId());
        basicInf.setRemove(false);
    }

    private Long id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private boolean remove;

}
