package com.payment.template;

/**
 * Lớp triển khai quy trình thanh toán bằng Ví điện tử MoMo.
 */
public class MomoPayment extends PaymentProcessor {

    /** Số điện thoại đăng ký tài khoản ví MoMo */
    private String phoneNumber;

    /**
     * Khởi tạo đối tượng thanh toán ví MoMo với số điện thoại liên kết.
     * 
     * @param phoneNumber Số điện thoại ví MoMo (ví dụ: "0987654321")
     */
    public MomoPayment(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Tạo mã QR và trừ tiền từ tài khoản Ví MoMo.
     * 
     * @param amount Số tiền trừ từ ví
     */
    @Override
    protected void executePayment(double amount) {
        System.out.println("[MoMo] Khởi tạo mã QR thanh toán động...");
        System.out.println("[MoMo] Trừ " + String.format("%,.0f", amount) + " VNĐ từ Ví MoMo (SĐT: " + phoneNumber + ")");
    }

    /**
     * Áp dụng mã giảm giá áp dụng trực tiếp cho ví MoMo.
     */
    @Override
    protected void applyDiscount() {
        System.out.println("[MoMo] Áp dụng Voucher giảm giá 15.000 VNĐ từ MoMo.");
    }
}