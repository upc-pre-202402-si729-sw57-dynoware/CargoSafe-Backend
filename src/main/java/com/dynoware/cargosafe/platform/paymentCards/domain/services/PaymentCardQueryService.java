package com.dynoware.cargosafe.platform.paymentCards.domain.services;

import com.dynoware.cargosafe.platform.paymentCards.domain.model.entities.PaymentCard;
import com.dynoware.cargosafe.platform.paymentCards.domain.model.queries.GetPaymentCardByIdQuery;

import java.util.Optional;

public interface PaymentCardQueryService {
    Optional<PaymentCard> handle(GetPaymentCardByIdQuery query);
}
