package kr.perfume.fragranceservice.service;

import kr.perfume.api.core.fragrance.FragranceDto;
import kr.perfume.fragranceservice.persistence.Fragrance;
import kr.perfume.fragranceservice.repository.FragranceQueryRepository;
import kr.perfume.fragranceservice.repository.FragranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FragranceService {

    private final FragranceRepository fragranceRepository;
    private final FragranceQueryRepository fragranceQueryRepository;

    public FragranceDto saveFragrance(FragranceDto fragranceDto) {
        Fragrance savedFragrance = fragranceRepository.save(new Fragrance(fragranceDto));
        return savedFragrance.toDto();
    }

    public FragranceDto getFragranceById(Long id) {
        return fragranceRepository.findById(id).map(Fragrance::toDto).orElse(null);
    }

    public Page<FragranceDto> searchFragrancesWithCondition(String fragranceName, String fragranceDesc, Pageable pageable) {
        Page<Fragrance> fragrances = fragranceQueryRepository.searchFragrancesWithCondition(fragranceName, fragranceDesc, pageable);
        return fragrances.map(Fragrance::toDto);
    }
}
