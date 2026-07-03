package com.portfolio.backend.controller;

import com.portfolio.backend.model.AboutMe;
import com.portfolio.backend.service.AboutMeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/about")
public class AboutMeController {

    private final AboutMeService aboutMeService;

    public AboutMeController(AboutMeService aboutMeService) {
        this.aboutMeService = aboutMeService;
    }

    @GetMapping
    public ResponseEntity<List<AboutMe>> getAll() {
        return ResponseEntity.ok(aboutMeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AboutMe> getById(@PathVariable Long id) {
        AboutMe aboutMe = aboutMeService.getById(id);
        return aboutMe != null ? ResponseEntity.ok(aboutMe) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AboutMe> create(@RequestBody AboutMe aboutMe) {
        return ResponseEntity.ok(aboutMeService.save(aboutMe));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AboutMe> update(@PathVariable Long id, @RequestBody AboutMe aboutMe) {
        aboutMe.setId(id);
        return ResponseEntity.ok(aboutMeService.save(aboutMe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        aboutMeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
