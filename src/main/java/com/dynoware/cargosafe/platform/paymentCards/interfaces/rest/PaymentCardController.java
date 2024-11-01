package com.dynoware.cargosafe.platform.paymentCards.interfaces.rest;

import com.dynoware.cargosafe.platform.paymentCards.domain.model.commands.CreatePaymentCardCommand;
import com.dynoware.cargosafe.platform.paymentCards.domain.services.PaymentCardCommandService;
import com.dynoware.cargosafe.platform.paymentCards.interfaces.rest.resources.CreatePaymentCardResource;
import com.dynoware.cargosafe.platform.paymentCards.interfaces.rest.transform.CreatePaymentCardCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/payment-card", produces = APPLICATION_JSON_VALUE)
@Tag(name = "CouPayment Card", description = "Available Payment Card Endpoints")
public class PaymentCardController {

    private final PaymentCardCommandService paymentCardCommandService;

    public PaymentCardController(PaymentCardCommandService paymentCardCommandService) {
        this.paymentCardCommandService = paymentCardCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a payment card", description = "Create a payment card")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Payment Card created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public void createPaymentCard(@RequestBody CreatePaymentCardResource resource) {
        var createPaymentCardCommand = CreatePaymentCardCommandFromResourceAssembler.toCommandFromResource(resource);
        paymentCardCommandService.handle(createPaymentCardCommand);
    }
}
