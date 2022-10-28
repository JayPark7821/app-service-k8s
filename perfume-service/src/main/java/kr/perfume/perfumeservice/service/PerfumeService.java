package kr.perfume.perfumeservice.service;

import kr.perfume.api.core.perfume.BaseItemDto;
import kr.perfume.api.core.perfume.perfume.PerfumeDto;
import kr.perfume.perfumeservice.persistence.Perfume;
import kr.perfume.perfumeservice.repository.PerfumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PerfumeService {

    private final PerfumeRepository perfumeRepository;

    public PerfumeDto savePerfume(BaseItemDto perfumeDto) {
        Perfume savedPerfume = perfumeRepository.save(new Perfume(perfumeDto));
        return savedPerfume.toDto();
    }

    public PerfumeDto getPerfumeById(Long id) {
        return perfumeRepository.findById(id).map(Perfume::toDto).orElse(null);
    }

}
