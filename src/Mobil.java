class Mobil {
    private String model;
    private double harga;

    public Mobil(String model, double harga) {
        this.model = model;
        this.harga = harga;
    }
    public String getModel() { return model; }
    public double getHarga() { return harga; }
    public void setModel(String model) { this.model = model; }
    public void setHarga(double harga) { this.harga = harga; }

    @Override
    public String toString() {
        return "Model: " + model + ", Harga/hari: Rp. " + harga;
    }
}