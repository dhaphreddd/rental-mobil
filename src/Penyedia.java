import java.util.ArrayList;
import java.util.List;

class Penyedia extends User {
    private List<Mobil> mobil;
    public Penyedia(String username, String password) {
        super(username, password);
        mobil = new ArrayList<>();
    }
    public void addMobil(Mobil Mobil) { mobil.add(Mobil); }
    public void removeMobil(String model) { mobil.removeIf(Mobil -> Mobil.getModel().equals(model)); }
    public List<Mobil> getMobill() { return new ArrayList<>(mobil); }
    public Mobil getMobil(String model) {
        return mobil.stream().filter(Mobil -> Mobil.getModel().equals(model)).findFirst().orElse(null);
    }
    public void updateCar(String oldModel, String newModel, double newHarga) {
        Mobil Mobil = getMobil(oldModel);
        if (Mobil != null) {
            Mobil.setModel(newModel);
            Mobil.setHarga(newHarga);
        }
    }
}