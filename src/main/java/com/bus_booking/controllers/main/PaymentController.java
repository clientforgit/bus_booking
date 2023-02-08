package com.bus_booking.controllers.main;

import com.liqpay.LiqPay;
import com.bus_booking.LiqPayProperties;
import com.bus_booking.entities.JourneyStop;
import com.bus_booking.entities.Ticket;
import com.bus_booking.models.PaymentModel;
import com.bus_booking.services.JourneyStopsService;
import com.bus_booking.services.PaymentAliasGenerator;
import com.bus_booking.services.TicketsService;
import com.bus_booking.ui.UiDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PaymentController {

    private final JourneyStopsService journeyStopsService;
    private final TicketsService ticketsService;
    private final PaymentAliasGenerator paymentAliasGenerator;

    public PaymentController(JourneyStopsService journeyStopsService,
                             TicketsService ticketsService,
                             PaymentAliasGenerator paymentAliasGenerator) {
        this.journeyStopsService = journeyStopsService;
        this.ticketsService = ticketsService;
        this.paymentAliasGenerator = paymentAliasGenerator;
    }

    @PostMapping("/payment")
    public PaymentModel payment(@RequestParam int journeyId,
                                @RequestParam int stopIdFrom,
                                @RequestParam int stopIdTo,
                                @RequestParam String name,
                                @RequestParam String surname,
                                @RequestParam int seatNumber,
                                @RequestParam String email,
                                @RequestParam String phone) {
        String alias = paymentAliasGenerator.getAlias();

        Ticket ticket = ticketsService.createInPendingStorage(
                alias,
                surname,
                name,
                phone,
                email,
                journeyId,
                seatNumber,
                stopIdFrom,
                stopIdTo
        );

        JourneyStop from = journeyStopsService.getByIds(journeyId, stopIdFrom);
        JourneyStop to = journeyStopsService.getByIds(journeyId, stopIdTo);

        UiDateTime departureDateTime = new UiDateTime(from.getTimestamp());
        UiDateTime arrivalDateTime = new UiDateTime(to.getTimestamp());

        String description =
                "Квиток на автобус, " +
                        name + " " + surname + ", " +
                        from.getCityName() + " - " + to.getCityName() + ", " +
                        departureDateTime.getStringDate();

        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setFromCityName(from.getCityName());
        paymentModel.setToCityName(to.getCityName());
        paymentModel.setFullName(name + " " + surname);
        paymentModel.setEmail(email);
        paymentModel.setPhone(phone);
        paymentModel.setSeatNumber(seatNumber);
        paymentModel.setDepartureDateTime(departureDateTime.toString());
        paymentModel.setArrivalDateTime(arrivalDateTime.toString());
        paymentModel.setPaymentButtonHtml(generatePaymentButton(
                alias,
                ticket.getPrice(),
                description
        ));

        return paymentModel;
    }

    private String generatePaymentButton(String alias, int price, String description) {
        Map<String, String> params = new HashMap<>();
        params.put("action", "pay");
        params.put("amount", String.valueOf(price));
        params.put("currency", "UAH");
        params.put("description", description);
        params.put("version", LiqPay.API_VERSION);
        params.put("result_url", LiqPayProperties.SERVER_URL);
        params.put("server_url", LiqPayProperties.SERVER_URL + "/liqPayResponse");
        LiqPay liqpay = new LiqPay(LiqPayProperties.PUBLIC_KEY, LiqPayProperties.PRIVATE_KEY);
        return liqpay.cnb_form(params);
    }
}