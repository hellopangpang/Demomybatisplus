package com.jia.demo.generator.controller;

import com.jia.demo.common.BaseController;
import com.jia.demo.generator.entity.Fileinfo;
import com.jia.demo.generator.mapper.FileinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jiamj
 * @since 2019-02-13
 */
@RestController
@RequestMapping("/generator/fileinfo")
public class FileinfoController extends BaseController {

    private String basePath = "C:/home/file";

    @Autowired
    private FileinfoMapper mapper;

    /**
     * 文件上传
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload")
    public Object upload(@RequestParam("file") MultipartFile file) throws IOException {

        String fileName = file.getOriginalFilename();

        //同一个InfoId，不同类型的隔开
        String docPath = basePath + "/" + System.currentTimeMillis();
        String path = docPath + '/' + fileName;
        Fileinfo fileInfo = new Fileinfo();
        fileInfo.setFilename(fileName);
        fileInfo.setPath(path);

        File filePath = new File(docPath);
        File fileSource = new File(filePath, fileName);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        file.transferTo(fileSource);
        //上传文件
        mapper.insert(fileInfo);
        return fileInfo;
    }
}
