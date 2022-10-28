package uz.developers.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.service.AttachmentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @GetMapping("/{id}")
    public Result getFileFromDB(@PathVariable Integer id, HttpServletResponse response) throws IOException {
      return attachmentService.getFile(id,response);
    }

    @PostMapping("/upload")
    public Result uploadPhoto(MultipartHttpServletRequest request) throws IOException {
        return attachmentService.uploadPhoto(request);
    }


}
