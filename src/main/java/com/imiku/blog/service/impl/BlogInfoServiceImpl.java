package com.imiku.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imiku.blog.BlogVo;
import com.imiku.blog.dao.BlogInfoDao;
import com.imiku.blog.model.BlogInfo;
import com.imiku.blog.service.BlogInfoService;
import com.imiku.blog.utils.DateUtils;
import com.imiku.blog.utils.Toolkits;
import com.imiku.blog.utils.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Lenovo on 2017/3/29.
 */
@Service
public class BlogInfoServiceImpl implements BlogInfoService {

    private static final String jspStr = "<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>";

    @Resource
    private BlogInfoDao blogInfoDao;

    @Override
    public PageInfo<BlogInfo> list(BlogVo blogVo) {
        if(StringUtils.isBlank(blogVo.getBlogName())){
            blogVo.setBlogName(null);
        }
        PageHelper.startPage(blogVo.getPageNum(), 8);
        List<BlogInfo> list = blogInfoDao.list(blogVo.getBlogName(),blogVo.getBlogType());
        PageInfo<BlogInfo> page = new PageInfo<>(list, 8);
        return page;
    }

    @Override
    public void saveBlog(BlogVo blogVo) {
        BlogInfo blogInfo = new BlogInfo();
        String uuid = UUIDUtils.getUUID36();
        blogInfo.setBlogUuid(uuid);
        blogInfo.setBlogAuthor(blogVo.getBlogAuthor());
        blogInfo.setBlogTitle(blogVo.getBlogName());
        blogInfo.setTypeId(blogVo.getBlogType());
        blogInfo.setBlogCover(blogVo.getBlogCover());
        blogInfo.setCreateDate(new Date());
        blogInfo.setTopSwitch(1);
        blogInfo.setRecommendSwitch(1);
        blogInfo.setBlogAbstract(blogVo.getBlogAbstract());
        String date  = DateUtils.get8Date();
        String path = Toolkits.getPath() + "htm/"+ date + "/htm/";
        String filename = uuid + ".jsp";
        blogInfo.setBlogUrl("/upload/htm/"+ date + "/htm/" + uuid + ".jsp");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        file = new File(path + filename);
        FileWriter fw = null;
        try {
            OutputStreamWriter writerStream = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
            BufferedWriter bw = new BufferedWriter(writerStream);
            bw.write(jspStr  + blogVo.getContext());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        blogInfoDao.insert(blogInfo);
    }

    @Override
    public void updateRecommend(BlogVo blogVo) {
        BlogInfo blogInfo = blogInfoDao.selectByPrimaryKey(blogVo.getBlogId());
        blogInfo.setRecommendSwitch(blogVo.getRecommend());
        blogInfoDao.updateByPrimaryKey(blogInfo);
    }

    @Override
    public void updateTop(BlogVo blogVo) {
        BlogInfo blogInfo = blogInfoDao.selectByPrimaryKey(blogVo.getBlogId());
        blogInfo.setTopSwitch(blogVo.getTop());
        blogInfoDao.updateByPrimaryKey(blogInfo);
    }

    @Override
    public BlogVo toUpdateBlog(BlogVo blogVo) {
        BlogInfo blogInfo = blogInfoDao.selectByPrimaryKey(blogVo.getBlogId());
        blogVo.setBlogInfo(blogInfo);
        try{
            StringBuffer stringBuffer = new StringBuffer();
            String path = Toolkits.getPath().replace("upload/","");
            File file = new File(path + blogInfo.getBlogUrl());
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader read = new InputStreamReader(fileInputStream,"UTF-8");
            BufferedReader br = new BufferedReader(read);
            String lineTxt = null;
            while((lineTxt = br.readLine()) != null){
                stringBuffer.append(lineTxt);
            }
            blogVo.setContext(stringBuffer.toString().replace(jspStr,""));
            read.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return blogVo;
    }

    @Override
    public void updateBlog(BlogVo blogVo) {

    }


}
