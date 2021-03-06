package com.radichev.workforyou.repository;

import com.radichev.workforyou.domain.entity.LanguageLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageLevelRepository extends JpaRepository<LanguageLevel, String> {
}
