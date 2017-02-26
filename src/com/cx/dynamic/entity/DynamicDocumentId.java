package com.cx.dynamic.entity;

import com.cx.dynamic_doc.entity.DynamicDoc;

import java.io.Serializable;

/**
 * Created by liujie on 2017/2/26.
 */
public class DynamicDocumentId implements Serializable {

    private String dynamic_id;

    private DynamicDoc dynamicDoc;

    public String getDynamic_id() {
        return dynamic_id;
    }

    public void setDynamic_id(String dynamic_id) {
        this.dynamic_id = dynamic_id;
    }

    public DynamicDoc getDynamicDoc() {
        return dynamicDoc;
    }

    public void setDynamicDoc(DynamicDoc dynamicDoc) {
        this.dynamicDoc = dynamicDoc;
    }

    public DynamicDocumentId(String dynamic_id, DynamicDoc dynamicDoc) {
        this.dynamic_id = dynamic_id;
        this.dynamicDoc = dynamicDoc;
    }

    public DynamicDocumentId() {
    }
}
