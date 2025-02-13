package co.istad.lms.features.payment;

import co.istad.lms.features.payment.dto.PaymentRequest;
import co.istad.lms.features.payment.dto.PaymentResponse;
import org.springframework.data.domain.Page;

public interface PaymentService {

    PaymentResponse createPayment(PaymentRequest paymentRequest);

    Page<PaymentResponse> getPayments(int page, int limit);

    PaymentResponse getPaymentById(String uuid);

    PaymentResponse updatePayment(String uuid, PaymentRequest paymentRequest);

    PaymentResponse deletePayment(String uuid);

}
