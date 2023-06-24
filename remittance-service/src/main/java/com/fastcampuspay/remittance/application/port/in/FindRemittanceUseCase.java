package com.fastcampuspay.remittance.application.port.in;


import com.fastcampuspay.remittance.domain.RemittanceRequest;

import java.util.List;

public interface FindRemittanceUseCase {
    List<RemittanceRequest> findRemittanceHistory(FindRemittanceCommand command);
}
