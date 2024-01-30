class Customer extends User {
    public Customer(String username, String password) {
        super(username, password);
    }

    public void sewaMobil(Mobil Mobil, int days) {
        double totalHarga = Mobil.getHarga() * days;
        System.out.println("Anda telah menyewa " + Mobil.getModel() + " selama " + days + " hari. Total harga: Rp. " + totalHarga);
    }
}