package com.cx.advice.entity;

import com.cx.inform.entity.InfoDocumentId;

import java.io.Serializable;

/**
 * Created by liujie on 2017/2/24.
 */
public class AdviceDocument implements Serializable{

    private AdviceDocumentId adviceDocumentId;

    public AdviceDocumentId getAdviceDocumentId() {
        return adviceDocumentId;
    }

    public void setAdviceDocumentId(AdviceDocumentId adviceDocumentId) {
        this.adviceDocumentId = adviceDocumentId;
    }

    public AdviceDocument(AdviceDocumentId adviceDocumentId) {
        this.adviceDocumentId = adviceDocumentId;
    }

    public AdviceDocument() {
    }
}
