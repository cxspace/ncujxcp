package com.cx.inform.service.impl;

import com.cx.core.service.impl.BaseServiceImpl;
import com.cx.inform.dao.InfoDao;
import com.cx.inform.entity.Info;
import com.cx.inform.entity.InfoDocument;
import com.cx.inform.entity.InfoDocumentId;
import com.cx.inform.service.InfoService;
import com.cx.inform_doc.entity.InfoDoc;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liujie on 2017/2/25.
 */


@Service("infoService")
public class InfoServiceImpl extends BaseServiceImpl<Info> implements InfoService {

    private InfoDao infoDao;

    @Resource
    public void setInfoDao(InfoDao infoDao) {

        super.setBaseDao(infoDao);

        this.infoDao = infoDao;
    }

    @Override
    public void saveInfoDocument(String infoId, String infoDocId) {
        infoDao.saveInfoDocument(new InfoDocument(new InfoDocumentId(infoId,new InfoDoc(infoDocId))));
    }

    @Override
    public List<InfoDocument> getInfoDocumentsByInfoId(String infoId) {
        return infoDao.getInfoDocumentsByInfoId(infoId);
    }

    @Override
    public void deleteInfoDocumentByDocId(String doc_id) {
        infoDao.deleteInfoDocumentByDocId(doc_id);
    }
}
