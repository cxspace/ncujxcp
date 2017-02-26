package com.cx.advice.entity;

import com.cx.advice_doc.entity.AdviceDoc;
import com.cx.inform_doc.entity.InfoDoc;

import java.io.Serializable;

/**
 * Created by liujie on 2017/2/24.
 */
public class AdviceDocumentId implements Serializable{

    private String advice_id;

    private AdviceDoc adviceDoc;

    public String getAdvice_id() {
        return advice_id;
    }

    public void setAdvice_id(String advice_id) {
        this.advice_id = advice_id;
    }

    public AdviceDoc getAdviceDoc() {
        return adviceDoc;
    }

    public void setAdviceDoc(AdviceDoc adviceDoc) {
        this.adviceDoc = adviceDoc;
    }

    public AdviceDocumentId(String advice_id, AdviceDoc adviceDoc) {
        this.advice_id = advice_id;
        this.adviceDoc = adviceDoc;
    }

    public AdviceDocumentId() {
    }
}
