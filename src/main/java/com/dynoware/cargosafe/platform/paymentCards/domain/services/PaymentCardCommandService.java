package com.dynoware.cargosafe.platform.paymentCards.domain.services;

import com.dynoware.cargosafe.platform.paymentCards.domain.model.commands.CreatePaymentCardCommand;

public interface PaymentCardCommandService {
    void handle(CreatePaymentCardCommand command);
}
