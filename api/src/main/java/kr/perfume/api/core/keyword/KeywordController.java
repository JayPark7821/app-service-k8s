package kr.perfume.api.core.keyword;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface KeywordController {

    @PostMapping
    KeywordDto saveKeyword(@RequestBody KeywordDto keywordDto);

    @GetMapping("/{id}")
    KeywordDto getKeywordById(@PathVariable("id") Long id);

    @GetMapping("/all")
    Page<KeywordDto> searchKeywordsWithCondition(String keywordName, String keywordDesc, KeywordType keywordType, Pageable pageable);

}
