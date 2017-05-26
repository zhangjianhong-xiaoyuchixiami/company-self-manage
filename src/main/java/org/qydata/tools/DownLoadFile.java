package org.qydata.tools;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

/**
 * Created by jonhn on 2017/5/26.
 */
public class DownLoadFile {

    /**
     * 下载文件
     * @param byteFile
     * @param fileName
     * @return
     * @throws IOException
     */
    public static ResponseEntity<byte[]> downloadFile(byte [] byteFile,String fileName) throws IOException {
        String escapeFileName = new String(fileName.getBytes(), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment",escapeFileName+".xls");
        return new ResponseEntity<>(byteFile, headers, HttpStatus.CREATED);
    }

        /*response.reset();
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String("张建宏" .getBytes(), "iso-8859-1") + ".xls" );
        OutputStream out = response.getOutputStream();
        out.write(excelCode);
        out.flush();
        out.close();*/

}



