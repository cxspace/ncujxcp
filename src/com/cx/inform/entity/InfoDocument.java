package com.cx.inform.entity;

import java.io.Serializable;

/**
 * Created by liujie on 2017/2/24.
 */
public class InfoDocument implements Serializable{

    private InfoDocumentId infoDocumentId;

    public InfoDocumentId getInfoDocumentId() {
        return infoDocumentId;
    }

    public void setInfoDocumentId(InfoDocumentId infoDocumentId) {
        this.infoDocumentId = infoDocumentId;
    }

    public InfoDocument(InfoDocumentId infoDocumentId) {
        this.infoDocumentId = infoDocumentId;
    }

    public InfoDocument() {
    }

}
