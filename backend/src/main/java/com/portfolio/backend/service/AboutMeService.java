package com.portfolio.backend.service;

import com.portfolio.backend.model.AboutMe;
import com.portfolio.backend.repository.AboutMeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutMeService {

    private final AboutMeRepository aboutMeRepository;

    public AboutMeService(AboutMeRepository aboutMeRepository) {
        this.aboutMeRepository = aboutMeRepository;
    }

    public List<AboutMe> getAll() {
        return aboutMeRepository.findAll();
    }

    public AboutMe getById(Long id) {
        return aboutMeRepository.findById(id).orElse(null);
    }

    public AboutMe getFirst() {
        return aboutMeRepository.findAll().stream().findFirst().orElse(null);
    }

    public AboutMe save(AboutMe aboutMe) {
        return aboutMeRepository.save(aboutMe);
    }

    public void delete(Long id) {
        aboutMeRepository.deleteById(id);
    }
}
