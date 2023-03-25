package fr.chadgpt.backend.service;

import fr.chadgpt.backend.model.entity.SiteUser;
import fr.chadgpt.backend.model.repository.SiteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteUserService {

    @Autowired
    SiteUserRepository siteUserRepository;

    public void save(SiteUser siteUser) {
        siteUserRepository.save(siteUser);
    }

}
