package kr.perfume.keywordservice.service;

import kr.perfume.api.core.fragrance.FragranceDto;
import kr.perfume.api.core.keyword.KeywordDto;
import kr.perfume.api.core.keyword.KeywordType;
import kr.perfume.keywordservice.persistence.Keyword;
import kr.perfume.keywordservice.repository.KeywordQueryRepository;
import kr.perfume.keywordservice.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class KeywordService {

    private final KeywordRepository keywordRepository;
    private final KeywordQueryRepository keywordQueryRepository;

    public KeywordDto saveKeyword(KeywordDto keywordDto) {
        Keyword savedKeyword = keywordRepository.save(new Keyword(keywordDto));
        return savedKeyword.toDto();
    }

    public KeywordDto getKeywordById(Long id) {
        return keywordRepository.findById(id).map(Keyword::toDto).orElse(null);
    }

    public Page<KeywordDto> searchKeywordsWithCondition(String keywordName, String keywordDesc, KeywordType keywordType, Pageable pageable) {
        Page<Keyword> keywords = keywordQueryRepository.searchKeywordsWithCondition(keywordName, keywordDesc, keywordType, pageable);
        return keywords.map(Keyword::toDto);
    }
}
