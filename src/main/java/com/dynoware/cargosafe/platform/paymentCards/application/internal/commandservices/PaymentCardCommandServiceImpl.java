package com.dynoware.cargosafe.platform.paymentCards.application.internal.commandservices;

import com.dynoware.cargosafe.platform.paymentCards.domain.model.commands.CreatePaymentCardCommand;
import com.dynoware.cargosafe.platform.paymentCards.domain.model.entities.PaymentCard;
import com.dynoware.cargosafe.platform.paymentCards.domain.services.PaymentCardCommandService;
import com.dynoware.cargosafe.platform.paymentCards.infrastructure.persistence.jpa.repositories.PaymentCardRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentCardCommandServiceImpl implements PaymentCardCommandService {
    private final PaymentCardRepository repository;

    public PaymentCardCommandServiceImpl(PaymentCardRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(CreatePaymentCardCommand command) {
        var paymentCard = new PaymentCard(command);
        try {
            repository.save(paymentCard);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving the card: %s".formatted(e.getMessage()));
        }
    }
}
