package com.imiku.blog.controller;

import com.imiku.blog.utils.DateUtils;
import com.imiku.blog.utils.ResultUtils;
import com.imiku.blog.utils.Toolkits;
import com.imiku.blog.utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by TWCX on 2016/10/21.
 */
@RequestMapping("/uploadFile")
@Controller
public class DownloadController {

    @RequestMapping(value = "/img",method= RequestMethod.POST)
    @ResponseBody
    public String  fileUpload2(@RequestParam("myFileName") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        long  startTime=System.currentTimeMillis();
        System.out.println("fileName："+file.getOriginalFilename());
        String date  = DateUtils.get8Date();
        String path = Toolkits.getPath() + "htm/"+ date + "/htm/";
        File newFile1=new File(path);
        if(!newFile1.exists()){
            newFile1.mkdirs();
        }
        newFile1=new File(path + file.getOriginalFilename());
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile1);

        long  endTime=System.currentTimeMillis();
        System.out.println("方法二的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return  "/upload/htm/"+ date + "/htm/" + file.getOriginalFilename();
    }


    @RequestMapping(value = "/cover",method= RequestMethod.POST)
    @ResponseBody
    public String  cover(@RequestParam("myFileName") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        String uuid = UUIDUtils.getUUID36();
        String filename = uuid + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
        String date  = DateUtils.get8Date();
        String path = Toolkits.getPath() + "cover/" + date + "/" ;
        String name = path + filename;
        System.out.print(name);
        try{
            File filedir = new File(path,filename);
            if(!filedir.exists()){
                filedir.mkdirs();
            }
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(filedir);
        }catch (Exception e){
            e.printStackTrace();
        }
        String str = ResultUtils.getUploadResult("/upload/cover/" + date + "/" + filename,uuid);
        return str;
    }
}
