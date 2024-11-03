package com.dynoware.cargosafe.platform.paymentCards.domain.services;

import com.dynoware.cargosafe.platform.paymentCards.domain.model.commands.CreatePaymentCardCommand;
import com.dynoware.cargosafe.platform.paymentCards.domain.model.commands.DeletePaymentCardCommand;

public interface PaymentCardCommandService {
    void handle(CreatePaymentCardCommand command);
    void handle(DeletePaymentCardCommand command);
}
