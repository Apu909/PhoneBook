package phonebook;

public class NrMobil extends NrTel{
    private String nr_tel_mobil;
    
    public NrMobil(String nr_tel_mobil){
        super(nr_tel_mobil);
    }
    
    public void validareNumar(){
        if(nr_tel_mobil == null || nr_tel_mobil.substring(0,2)!="07")
            System.out.println("Numar invalid. Numarul de telefon mobil trebuie sa inceapa cu '07'");
    }

    @Override
    public int compareTo(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
