package kr.perfume.perfumeservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.perfume.api.core.perfume.perfume.PerfumeController;
import kr.perfume.api.core.perfume.perfume.PerfumeDto;
import kr.perfume.perfumeservice.service.PerfumeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/perfume")
public class PerfumeControllerImpl implements PerfumeController {

	private final PerfumeService perfumeService;

	@Override
	public PerfumeDto saveItem(BaseItemDto baseItemDto) {
		return perfumeService.savePerfume(baseItemDto);
	}

	@Override
	public PerfumeDto getItemById(Long id) {
		return perfumeService.getPerfumeById(id);
	}

}
