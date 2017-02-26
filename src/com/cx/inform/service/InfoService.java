package com.cx.inform.service;

import com.cx.core.service.BaseService;
import com.cx.inform.entity.Info;
import com.cx.inform.entity.InfoDocument;

import java.util.List;

/**
 * Created by liujie on 2017/2/25.
 */
public interface InfoService extends BaseService<Info> {

      public void saveInfoDocument(String infoId , String infoDocId);

      public List<InfoDocument> getInfoDocumentsByInfoId(String infoId);

      public void deleteInfoDocumentByDocId(String doc_id);

      public List<Info> findIndexInfo();


}
