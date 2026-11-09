package com.payment.template;

/**
 * Lớp triển khai quy trình thanh toán bằng Thẻ tín dụng (Visa/Mastercard).
 */
public class CreditCardPayment extends PaymentProcessor {

    /** Số thẻ tín dụng của khách hàng */
    private String cardNumber;

    /**
     * Khởi tạo đối tượng thanh toán thẻ tín dụng với số thẻ tương ứng.
     * 
     * @param cardNumber Chuỗi chứa số thẻ tín dụng (ví dụ: "4123456789012345")
     */
    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Thực hiện kết nối cổng Visa/Mastercard và trừ tiền tài khoản thẻ.
     * 
     * @param amount Số tiền trừ vào tài khoản thẻ
     */
    @Override
    protected void executePayment(double amount) {
        String last4Digits = cardNumber.substring(cardNumber.length() - 4);
        System.out.println("[Credit Card] Kết nối cổng thanh toán quốc tế Visa/Mastercard...");
        System.out.println("[Credit Card] Trừ " + String.format("%,.0f", amount) + " VNĐ từ thẻ số: ****-****-****-" + last4Digits);
    }

    /**
     * Áp dụng ưu đãi hoàn tiền dành riêng cho giao dịch thẻ tín dụng.
     */
    @Override
    protected void applyDiscount() {
        System.out.println("[Credit Card] Hoàn tiền 2% giá trị giao dịch vào tài khoản thẻ.");
    }
}