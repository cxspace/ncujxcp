package com.cx.dynamic.entity;

import com.cx.inform.entity.InfoDocumentId;

import java.io.Serializable;

/**
 * Created by liujie on 2017/2/24.
 */
public class DynamicDocument implements Serializable{

    private DynamicDocumentId dynamicDocumentId;

    public DynamicDocumentId getDynamicDocumentId() {
        return dynamicDocumentId;
    }

    public void setDynamicDocumentId(DynamicDocumentId dynamicDocumentId) {
        this.dynamicDocumentId = dynamicDocumentId;
    }

    public DynamicDocument(DynamicDocumentId dynamicDocumentId) {
        this.dynamicDocumentId = dynamicDocumentId;
    }

    public DynamicDocument() {
    }
}
