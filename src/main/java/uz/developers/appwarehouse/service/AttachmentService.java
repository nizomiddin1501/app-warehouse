package uz.developers.appwarehouse.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.developers.appwarehouse.entity.Attachment;
import uz.developers.appwarehouse.payload.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface AttachmentService {

    //get
    Result getFile(Integer id, HttpServletResponse response) throws IOException;

    //post
    Result uploadPhoto(MultipartHttpServletRequest request) throws IOException;





}
