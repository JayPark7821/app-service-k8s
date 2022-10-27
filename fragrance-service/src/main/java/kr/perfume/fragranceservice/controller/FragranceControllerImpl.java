package kr.perfume.fragranceservice.controller;

import kr.perfume.api.core.fragrance.FragranceController;
import kr.perfume.api.core.fragrance.FragranceDto;
import kr.perfume.fragranceservice.service.FragranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class FragranceControllerImpl implements FragranceController {

    private final FragranceService fragranceService;

    @Override
    public FragranceDto saveFragrance(FragranceDto fragranceDto) {
        return fragranceService.saveFragrance(fragranceDto);
    }

    @Override
    public FragranceDto getFragranceById(Long id) {
        return fragranceService.getFragranceById(id);
    }

    @Override
    public Page<FragranceDto> searchFragrancesWithCondition(String fragranceName, String fragranceDesc, Pageable pageable) {
        return fragranceService.searchFragrancesWithCondition(fragranceName, fragranceDesc, pageable);
    }
}
