package phonebook;
import java.time.LocalDate;
import java.time.Month;
import java.time.LocalDate;
import java.util.Objects;
import UI.PhoneBookManager;

public class PhoneBook {
    
    public static void main(String[] args){
        NrFix nr_tel_fix = new NrFix("0286362839");
        Contact contact1 = new Contact("Popescu", "Adrian", LocalDate.of(2000, 1, 9), nr_tel_fix);
        NrMobil nr_tel_mobil = new NrMobil("0783927564");
        Contact contact2 = new Contact("Mihailescu", "Radu", LocalDate.of(2000, 8, 11), nr_tel_mobil);
        System.out.println(contact1);
        System.out.println(contact2);
        PhoneBookManager p = new PhoneBookManager();
        p.setVisible(true);
    }
    
}
