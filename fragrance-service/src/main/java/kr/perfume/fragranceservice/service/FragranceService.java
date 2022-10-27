package kr.perfume.fragranceservice.service;

import kr.perfume.api.core.fragrance.FragranceDto;
import kr.perfume.fragranceservice.persistence.Fragrance;
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

    public FragranceDto saveFragrance(FragranceDto fragranceDto) {
        Fragrance savedFragrance = fragranceRepository.save(new Fragrance(fragranceDto));
        return savedFragrance.toDto();
    }

    public FragranceDto getFragranceById(Long id) {
        return fragranceRepository.findById(id).map(Fragrance::toDto).orElse(null);
    }

    public Page<FragranceDto> getAllFragrances(String fragranceName, String fragranceDesc, Pageable pageable) {
        return null;
    }
}
