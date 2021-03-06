package com.radichev.workforyou.service.serviceImpl;

import com.radichev.workforyou.domain.entity.LanguageLevel;
import com.radichev.workforyou.exception.EntityNotFoundException;
import com.radichev.workforyou.model.dtos.LanguageDto.LanguageLevelDto;
import com.radichev.workforyou.repository.LanguageLevelRepository;
import com.radichev.workforyou.service.LanguageLevelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageLevelServiceImpl implements LanguageLevelService {
    private final LanguageLevelRepository languageLevelRepository;
    private final ModelMapper modelMapper;

    public LanguageLevelServiceImpl(LanguageLevelRepository languageLevelRepository, ModelMapper modelMapper) {
        this.languageLevelRepository = languageLevelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<LanguageLevelDto> findAllLanguageLevels() {
        return this.languageLevelRepository.findAll()
                .stream()
                .map(languageLevel -> this.modelMapper.map(languageLevel, LanguageLevelDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public LanguageLevel findLanguageLevelById(String languageLevelId) {
        return this.languageLevelRepository.findById(languageLevelId)
                .orElseThrow(() ->
                        new EntityNotFoundException(String.format("LanguageLevel not found with %s id.", languageLevelId)));
    }

    @Override
    public void initLanguageLevels() {
        if (this.languageLevelRepository.count() == 0) {
            this.languageLevelRepository.saveAndFlush(new LanguageLevel("Basic"));
            this.languageLevelRepository.saveAndFlush(new LanguageLevel("Conversational"));
            this.languageLevelRepository.saveAndFlush(new LanguageLevel("Fluent"));
            this.languageLevelRepository.saveAndFlush(new LanguageLevel("Native/Bilingual"));
        }
    }
}
