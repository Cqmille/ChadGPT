package fr.chadgpt.backend.model.repository;

import fr.chadgpt.backend.model.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {
}
