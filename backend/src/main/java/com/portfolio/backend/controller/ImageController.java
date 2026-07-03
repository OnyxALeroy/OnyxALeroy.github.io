package com.portfolio.backend.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @GetMapping("/api/images/{filename}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        Resource resource = new ClassPathResource("images/" + filename);
        if (!resource.exists()) {
            resource = new ClassPathResource("images/placeholder.svg");
        }

        String contentType = "application/octet-stream";
        if (filename.endsWith(".png")) contentType = MediaType.IMAGE_PNG_VALUE;
        else if (filename.endsWith(".jpg") || filename.endsWith(".jpeg")) contentType = MediaType.IMAGE_JPEG_VALUE;
        else if (filename.endsWith(".svg")) contentType = "image/svg+xml";
        else if (filename.endsWith(".webp")) contentType = MediaType.valueOf("image/webp").toString();

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(resource);
    }
}
