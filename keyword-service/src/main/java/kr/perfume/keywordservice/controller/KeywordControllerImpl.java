package kr.perfume.keywordservice.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.perfume.api.core.perfume.keyword.KeywordController;
import kr.perfume.api.core.perfume.keyword.KeywordDto;
import kr.perfume.api.core.perfume.keyword.KeywordType;
import kr.perfume.keywordservice.service.KeywordService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/keyword")
public class KeywordControllerImpl implements KeywordController {

	private final KeywordService keywordService;

	@Override
	public KeywordDto getItemById(Long id) {
		return keywordService.getKeywordById(id);
	}

	@Override
	public KeywordDto saveItem(KeywordDto keywordDto) {
		return keywordService.saveKeyword(keywordDto);
	}

	@Override
	public Page<KeywordDto> searchKeywordsWithCondition(String keywordName, String keywordDesc, KeywordType keywordType,
		Pageable pageable) {
		return keywordService.searchKeywordsWithCondition(keywordName, keywordDesc, keywordType, pageable);
	}
}
