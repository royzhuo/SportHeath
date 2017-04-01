package com.beStrong.controller;

import jdk.internal.util.xml.impl.Input;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by roy on 2017/3/30.
 */
@Controller
public class FileUploadController {
    public   String fileBaseUrl="D:/TempFile/";

    @RequestMapping(value = "/fileUpload",method = RequestMethod.POST)
    public String fileUpload(@RequestParam(value = "file1",required = false) MultipartFile file1,
                             @RequestParam(value = "desc",required = false) String desc, HttpServletRequest request) throws IOException {
        System.out.println("tempFile:"+request.getSession().getServletContext().getRealPath("tempFile"));
        String filePath=fileBaseUrl+desc+file1.getOriginalFilename();
     //   String filePath1=request.getSession().getServletContext().getRealPath("tempFile")+file1.getName();
        File tempFile=new File(fileBaseUrl);
        if (!tempFile.exists()){
            tempFile.mkdir();
        }
        File myFile=new File(filePath);
        long startTime=System.currentTimeMillis();
       // InputStream inputStream=null;
        FileInputStream fileInputStream=null;
        BufferedInputStream bis=null;
        OutputStream outputStream=null;
        BufferedOutputStream bos=null;
        int temp=0;
        long endTime=0;
        try {
            fileInputStream=(FileInputStream) file1.getInputStream();
            bis=new BufferedInputStream(fileInputStream);
            outputStream=new FileOutputStream(myFile);
            bos=new BufferedOutputStream(outputStream);
            while ((temp=bis.read())!=-1){
                bos.write(temp);
                bos.flush();
            }
endTime=System.currentTimeMillis();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bos!=null){
                bos.close();
            }
            if (outputStream!=null){
                outputStream.close();
            }
            if (fileInputStream!=null){
                fileInputStream.close();
            }
            if (bis!=null){
                bis.close();
            }
            System.out.println("开始时间："+startTime+"结束时间："+endTime+"耗时:"+(endTime-startTime));
        }


        return "success";
    }
}
