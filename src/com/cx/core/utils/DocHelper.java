package com.cx.core.utils;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.util.UUID;

/**
 * Created by liujie on 2017/2/25.
 */
public class DocHelper {

//    public static void saveHeadImg(File headImg , User user , String headImgFileName){
//
//        try {
//
//            //处理头像上传
//            if (headImg != null){
//                //1.保存头像文件到指定目录
//                String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
//
//                String fileName = UUID.randomUUID().toString().replaceAll("-","")+headImgFileName.substring(headImgFileName.lastIndexOf("."));
//
//                FileUtils.copyFile(headImg,new File(filePath,fileName));
//
//                //设置好数据库中要存储的图像路径
//                user.setHead_img("user/"+fileName);
//
//                System.out.println(fileName);
//            }
//
//        }catch (Exception e){
//
//            e.printStackTrace();
//        }
//
//    }

}
