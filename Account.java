

import java.text.NumberFormat;
import javax.swing.JSpinner.NumberEditor;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;


public class Account {
    private static  long soTK;
    private static String tenTK;
    private static double soTien;
    private String trangThai;
    Scanner sc = new Scanner(System.in);

    public Account(){
        this(999999,"chua xac dinh",50);
    }

    public Account(long soTK, String tenTK, double soTien){
        super();
        this.soTK = soTK;
        this.tenTK = tenTK;
        this.soTien = soTien;
        this.trangThai = trangThai;
    }

    public long getSoTK() {
        return soTK;
    }
    public void setSoTK(long soTK) {
        if(soTK == 999999){
        this.soTK = soTK;
        System.out.println("so tai khoan khong hop le");
        }
        else{
            this.soTK = soTK;
            System.out.println("so tai khoan duoc cap nhat");
        }
    }
        

    public String getTenTK() {
        return tenTK;
    }
    public void setTenTK(String tenTK) {
        if(tenTK.isEmpty()){
            this.tenTK = tenTK;
            System.out.println("ten tai khoan khong hop le");
        }
        else{
            this.tenTK = tenTK;
            System.out.println("ten tai khoan da duoc cap nhat");
        }
    }


    public double getSoTien() {
        return soTien;
    }
    public void setSoTien(double soTien) {
        if(soTien < 50){
            this.soTien = soTien;
            System.out.println("so tien trong tai khoan khong hop le");
        }
        else{
            this.soTien = soTien;
            System.out.println("so tien cua ban da duoc cap nhat");
        }
    }


    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Account [soTK=" + soTK + ", tenTK=" + tenTK + ", soTien=" + soTien + ", trangThai=" + trangThai + "]";
    }

    Locale locale = new Locale("vi", "vn");
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    public NumberFormat getFormatter() {
        return formatter;
    }
    public void setFormatter(NumberFormat formatter) {
        this.formatter = formatter;
    }

    public double napTien() {
        double nap;
        System.out.print("nhap so tien ban can nap: ");
        nap = sc.nextDouble();
        if (nap >= 0) {
            soTien = nap + soTien;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(nap);
            System.out.println("ban vua nap " + str1 + " vao tai khoan.");
        } else {
            System.out.println("So tien nap khong hop le!");
        }
        return nap;
    }

    public double rutTien() {
        double phi = 5;
        double rut;
        System.out.print("nhap so tien can rut: ");
        rut = sc.nextDouble();
        if (rut <= (soTien - phi)) {
            soTien = soTien - (rut + phi);
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(rut);
            System.out.println("Ban vua rut " + str1 + "Đ tu tai khoan. Phi la $5.");
        } else {
            System.out.println("So tien muon rut khong hop le!");
            return rutTien();
        }
        return rut;
    }

    public double daoHan() {
        double laiSuat = 0.035;
        soTien = soTien + soTien * laiSuat;
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTien);
        System.out.println("Ban vua duoc " + str1 + " tu dao han 1 thang");
        return soTien;
    }

    void inTK() {
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTien);
        System.out.printf("%-10d %-20s %-20s \n", soTK, tenTK, str1);
    }
}


    class AccounTest {
    static Scanner sc = new Scanner(System.in);
    static void nhapTK(Account tk) {
        System.out.println("Nhap so tai khoan: ");
        tk.setSoTK(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhap ten tai khoan: ");
        tk.setTenTK(sc.nextLine());
        tk.setSoTien(50);
    }
    public static void main(String[] args) {
        Account a[] = null;
        int k, chon, n = 0;
        long s, d, c, f;
        boolean flag = true;
        do {
            System.out.println("MENU");
            System.out.println("1.Nhập thông tin của các khách hàng");
            System.out.println("2.Xuất danh sách thông tin của các khách hàng");
            System.out.println("3.Nạp tiền");
            System.out.println("4.Rút tiền");
            System.out.println("5.Đáo hạn");
            System.out.println("6.Chuyển khoản");
            System.out.println("**Số khác để thoát");
            System.out.println("Nhap lua chon cua ban");
            chon = sc.nextInt();
            switch (chon) {
                case 1:
                    System.out.println("Nhap so luong khach hang ban muon nhap: ");
                    n = sc.nextInt();
                    a = new Account[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("Khach hang so: " + (i+1));
                        a[i] = new Account();
                        nhapTK(a[i]);
                    }
                    break;
                case 2:
                    System.out.printf("%-10s %-20s %-20s\n", "So TK", "Ten TK", "So Tien");
                    for (int i = 0; i < n; i++) {
                        a[i].inTK();
                    }
                    break;
                case 3:
                    System.out.println("Nhap so tai khoan khach hang can nap tien: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            System.out.println("Ban chon tai khoan: " + d);
                            a[i].napTien();
                        } else {
                            System.out.println("");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nhap so tai khoan khach hang can rut tien: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            System.out.println("ban chon tai khoan: " + d);
                            a[i].rutTien();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Nhap so tai khoan khach hang can dao hang: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            System.out.println("Ban chon tai khoan: " + d);
                            a[i].daoHan();
                        } else {
                            System.out.println("");
                        }
                    }
                    break;
                case 6:
                    double chuyen,nhan,tienChuyen;
                    System.out.print("Nhap so tai khoan khach hang chuyen tien: ");
                    s = sc.nextLong();
                    System.out.print("Nhap so tai khoan khach hang nhan tien: ");
                    c = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            chuyen = a[i].getSoTien();
                            for (int j = 0; j < n; j++) {
                                f = a[j].getSoTK();
                                if (c == f) {
                                    nhan = a[j].getSoTien();
                                    System.out.println("Nhap so tien can chuyen");
                                    tienChuyen = sc.nextDouble();
                                    if (tienChuyen <= chuyen) {
                                        chuyen = chuyen - tienChuyen;
                                        nhan = nhan + tienChuyen;
                                        a[i].setSoTien(tienChuyen);
                                        a[j].setSoTien(nhan);
                                        System.out.println("Tai khoan so " + d + " vua chuyen: $" + tienChuyen);
                                        System.out.println("Tai khoan so " + f + " vua nhan: $" + tienChuyen);
                                    } else {
                                        System.out.println("So tien nhap khong hop le!");
                                    }
                                } else {
                                    System.out.println("");
                                }
                            }
                        } else {
                            System.out.println("");
                        }
                    }
                    break;
                default:
                    System.out.println("Tam biet");
                    flag = false;
                    break;
            }
        } while (flag);
    }
    }

