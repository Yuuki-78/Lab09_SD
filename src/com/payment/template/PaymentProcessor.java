package com.payment.template;

/**
 * Lớp trừu tượng định nghĩa khung quy trình xử lý thanh toán.
 * <p>
 * Áp dụng mẫu thiết kế Template Method để cố định thứ tự các bước xử lý đơn hàng,
 * đồng thời cho phép các lớp con tùy biến thao tác trừ tiền và áp dụng ưu đãi.
 * </p>
 * 
 * @author SinhVien
 * @version 1.0
 */
public abstract class PaymentProcessor {

    /**
     * PHƯƠNG THỨC KHUÔN MẪU (Template Method).
     * <p>
     * Định nghĩa thuật toán xử lý thanh toán theo thứ tự 4 bước cố định.
     * Phương thức này được đánh dấu {@code final} để ngăn các lớp con ghi đè
     * làm thay đổi quy trình chung.
     * </p>
     * 
     * @param amount Số tiền cần thanh toán (đơn vị: VNĐ)
     */
    public final void processPayment(double amount) {
        validateOrder(amount);
        executePayment(amount);
        applyDiscount();
        sendReceipt();
    }

    /**
     * Bước 1 (Cố định): Kiểm tra tính hợp lệ của đơn hàng và số tiền thanh toán.
     * 
     * @param amount Số tiền giao dịch
     * @throws IllegalArgumentException Nếu số tiền thanh toán nhỏ hơn hoặc bằng 0
     */
    private void validateOrder(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[LỖI] Số tiền thanh toán không hợp lệ!");
        }
        System.out.println("[Hệ thống] Đơn hàng hợp lệ. Số tiền giao dịch: " + String.format("%,.0f", amount) + " VNĐ");
    }

    /**
     * Bước 2 (Thay đổi): Thực hiện kết nối cổng thanh toán và trừ tiền.
     * <p>
     * Các lớp con bắt buộc phải cài đặt phương thức này theo từng kênh thanh toán cụ thể.
     * </p>
     * 
     * @param amount Số tiền thực hiện trừ từ tài khoản
     */
    protected abstract void executePayment(double amount);

    /**
     * Bước 3 (Thay đổi): Áp dụng chính sách khuyến mãi hoặc hoàn tiền tương ứng.
     */
    protected abstract void applyDiscount();

    /**
     * Bước 4 (Cố định): Lưu lịch sử giao dịch và xuất hóa đơn gửi cho khách hàng.
     */
    private void sendReceipt() {
        System.out.println("[Hệ thống] Đã lưu lịch sử giao dịch và gửi hóa đơn đến Email.");
        System.out.println("------------------------------------------------------------");
    }
}