import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Pharmacy analgin = new Pharmacy("analgin");
        Pharmacy aspirin = new Pharmacy("aspirin");
        Pharmacy citrin = new Pharmacy("citrin");

        analgin
                .addComponent(new Penicillin("PenicillinH", 10, 100))
                .addComponent(new Water("WaterH", 20, 15))
                .addComponent(new Salt("SaltH", 50, 50));

        aspirin
                .addComponent(new Penicillin("PenicillinS", 5, 80))
                .addComponent(new Water("WaterS", 10, 10))
                .addComponent(new Salt("SaltS", 3, 300));
        citrin
                .addComponent(new Penicillin("PenicillinS", 25, 120))
                .addComponent(new Water("WaterS", 30, 25))
                .addComponent(new Salt("SaltS", 7, 70));

        List<Pharmacy> pharmacies = new ArrayList<>();
        pharmacies.add(analgin);
        pharmacies.add(aspirin);
        pharmacies.add(citrin);

        getPharmaciesSortedByInterPower(pharmacies);

        getPharmaciesSortedByTotalPower(pharmacies);

        getPharmaciesSortedByTotalWeight(pharmacies, new PharmacyComparator());

        final Sorter sorter = ph -> {
            Collections.sort(ph);
        };

        sorter.getPharmaciesSortedByInterPower(pharmacies);
        sorter.getPharmaciesSortedByTotalPower(pharmacies);
        sorter.getPharmaciesSortedByTotalWeight(pharmacies);
    }

    private static void getPharmaciesSortedByInterPower(List<Pharmacy> pharmacies) {
        Collections.sort(pharmacies);
        System.out.println(pharmacies);
    }

    private static void getPharmaciesSortedByTotalPower(List<Pharmacy> pharmacies) {
        pharmacies.sort((ph1, ph2) -> Integer.compare(ph1.getTotalPower(), ph2.getTotalPower()));
    }

    private static void getPharmaciesSortedByTotalWeight(List<Pharmacy> pharmacies, Comparator<Pharmacy> comparator) {
        pharmacies.sort(comparator);
    }
}
