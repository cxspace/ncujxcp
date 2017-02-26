package com.cx.inform.entity;

import com.cx.inform_doc.entity.InfoDoc;
import java.io.Serializable;

/**
 * Created by liujie on 2017/2/24.
 */
public class InfoDocumentId implements Serializable{

    private String info_id;

    private InfoDoc infoDoc;

    public String getInfo_id() {
        return info_id;
    }

    public void setInfo_id(String info_id) {
        this.info_id = info_id;
    }

    public InfoDoc getInfoDoc() {
        return infoDoc;
    }

    public void setInfoDoc(InfoDoc infoDoc) {
        this.infoDoc = infoDoc;
    }

    public InfoDocumentId(String info_id, InfoDoc infoDoc) {
        this.info_id = info_id;
        this.infoDoc = infoDoc;
    }

    public InfoDocumentId() {

    }
}
