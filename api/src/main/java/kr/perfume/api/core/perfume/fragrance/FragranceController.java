package kr.perfume.api.core.perfume.fragrance;

import kr.perfume.api.core.perfume.BaseItemController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;

public interface FragranceController extends BaseItemController {

    @GetMapping("/all")
    Page<FragranceDto> searchFragrancesWithCondition(String fragranceName, String fragranceDesc, Pageable pageable);

}
