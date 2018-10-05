package antelopes.kinoxp.controllers;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class FileController {
    @GetMapping("/movies/image/upload/{id}")
    public String uploadImage(Model model, @PathVariable("id")String id){
        try{
            int ID = Integer.parseInt(id);
            model.addAttribute("movieID", ID);
            return "movies/uploadMoviePoster";
        }catch (Exception ex){
            // reroute somewhere else
            return "";
        }
    }

    @PostMapping("/movies/image/upload")
    public String uploadFile(@RequestParam("movieID")String movieID, @RequestParam("image")MultipartFile image){
        if(!image.isEmpty()){
            try{
                BufferedImage src = ImageIO.read(new ByteArrayInputStream(image.getBytes()));
                File destination = new File("files/poster-" + movieID + ".png");
                ImageIO.write(src, "png", destination);
            } catch (IOException ex){
                // Do something about the error
            }
        } else {
            //do something if the file is empty
        }
        return "";
    }

    @GetMapping(value = "/movies/poster/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(@PathVariable("id")String id, HttpServletResponse response){
        try{
            int movieID = Integer.parseInt(id);
            StringBuilder str = new StringBuilder();
            str.append("src/main/resources/static/posters/poster-");
            str.append(movieID);
            str.append(".png");
            FileSystemResource imgFile = new FileSystemResource(str.toString());
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
        } catch (FileNotFoundException ex){
            // Include message here
        } catch (IOException ex){
            // Include message here
        }
    }

    // returns image path to use in thymeleaf
    public String getImagePath(int id){
        StringBuilder str = new StringBuilder();
        str.append("src/main/resources/static/posters/poster-");
        str.append(id);
        str.append(".png");
        FileSystemResource imgFile = new FileSystemResource(str.toString());
        if(!imgFile.exists()){
            return null;
        }

        str = new StringBuilder();
        str.append("poster-").append(id).append(".png");
        return str.toString();
    }
}