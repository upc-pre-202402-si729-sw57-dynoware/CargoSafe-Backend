package com.dynoware.cargosafe.platform.paymentCards.interfaces.rest.transform;

import com.dynoware.cargosafe.platform.paymentCards.domain.model.entities.PaymentCard;
import com.dynoware.cargosafe.platform.paymentCards.interfaces.rest.resources.PaymentCardResource;

public class PaymentCardResourceFromEntityAssembler {
    public static PaymentCardResource toResourceFromEntity(PaymentCard entity) {
        return new PaymentCardResource(entity.getId(), entity.getCardNumber(), entity.getExpiryDate(), entity.getSecurityCode());
    }
}
