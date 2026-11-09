package com.payment.template;

/**
 * Lớp chứa phương thức {@code main} dùng để chạy minh họa và kiểm thử chương trình.
 */
public class Main {

    /**
     * Phương thức khởi chạy chương trình, thử nghiệm 2 kịch bản thanh toán khác nhau.
     * 
     * @param args Tham số dòng lệnh (không sử dụng)
     */
    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println("         HỆ THỐNG XỬ LÝ THANH TOÁN ĐƠN HÀNG (TEMPLATE METHOD)");
        System.out.println("============================================================\n");

        // Kịch bản 1: Thanh toán bằng Thẻ tín dụng
        System.out.println("--- KỊCH BẢN 1: THANH TOÁN QUA THẺ TÍN DỤNG ---");
        PaymentProcessor creditCard = new CreditCardPayment("4123456789012345");
        creditCard.processPayment(1500000);

        // Kịch bản 2: Thanh toán bằng Ví MoMo
        System.out.println("--- KỊCH BẢN 2: THANH TOÁN QUA VÍ MOMO ---");
        PaymentProcessor momo = new MomoPayment("0987654321");
        momo.processPayment(350000);
    }
}