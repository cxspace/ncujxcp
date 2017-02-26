package com.cx.inform.dao;

import com.cx.core.dao.BaseDao;
import com.cx.inform.entity.Info;
import com.cx.inform.entity.InfoDocument;

import java.util.List;

/**
 * Created by liujie on 2017/2/25.
 */
public interface InfoDao extends BaseDao<Info> {


      //保存通知公告附件关系
      public void saveInfoDocument(InfoDocument infoDocument);

      public List<InfoDocument> getInfoDocumentsByInfoId(String infoId);

      public void deleteInfoDocumentByDocId(String doc_id);


}
