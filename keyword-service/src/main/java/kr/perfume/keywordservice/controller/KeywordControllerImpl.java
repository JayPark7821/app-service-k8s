package kr.perfume.keywordservice.controller;

import kr.perfume.api.core.keyword.KeywordController;
import kr.perfume.api.core.keyword.KeywordDto;
import kr.perfume.api.core.keyword.KeywordType;
import kr.perfume.keywordservice.service.KeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class KeywordControllerImpl implements KeywordController {

    private final KeywordService keywordService;

    @Override
    public KeywordDto saveKeyword(KeywordDto keywordDto) {
        return keywordService.saveKeyword(keywordDto);
    }

    @Override
    public KeywordDto getKeywordById(Long id) {
        return keywordService.getKeywordById(id);
    }

    @Override
    public Page<KeywordDto> searchKeywordsWithCondition(String keywordName, String keywordDesc, KeywordType keywordType, Pageable pageable) {
        return keywordService.searchKeywordsWithCondition(keywordName, keywordDesc, keywordType, pageable);
    }
}
