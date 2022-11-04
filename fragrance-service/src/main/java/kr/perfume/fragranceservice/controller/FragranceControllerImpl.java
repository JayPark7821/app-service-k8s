package kr.perfume.fragranceservice.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.perfume.api.core.perfume.fragrance.FragranceController;
import kr.perfume.api.core.perfume.fragrance.FragranceDto;
import kr.perfume.fragranceservice.service.FragranceService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fragrance")
public class FragranceControllerImpl implements FragranceController {

	private final FragranceService fragranceService;

	@Override
	public FragranceDto saveItem(BaseItemDto fragranceDto) {
		return fragranceService.saveFragrance(fragranceDto);
	}

	@Override
	public FragranceDto getItemById(Long id) {
		return fragranceService.getFragranceById(id);
	}

	@Override
	public Page<FragranceDto> searchFragrancesWithCondition(String fragranceName, String fragranceDesc,
		Pageable pageable) {
		return fragranceService.searchFragrancesWithCondition(fragranceName, fragranceDesc, pageable);
	}

}
