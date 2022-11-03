package kr.perfume.api.core.perfume.perfume;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import kr.perfume.api.ApiResponse;
import kr.perfume.api.core.perfume.fragrance.FragranceDto;

public interface PerfumeController {

	@PostMapping
	ResponseEntity<ApiResponse<FragranceDto.FragranceResponse>> saveFragrance(
		@RequestBody @Valid FragranceDto.FragranceRequest request);

	@GetMapping("/{id}")
	ResponseEntity<ApiResponse<FragranceDto.FragranceResponse>> getFragrance(@PathVariable("id") Long id);

	@GetMapping("/all")
	ResponseEntity<ApiResponse<Page<FragranceDto.FragranceResponse>>> searchFragrancesWithCondition(
		String fragranceName, String fragranceDesc, Pageable pageable);

}
