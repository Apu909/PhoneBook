package phonebook;

public class NrFix extends NrTel{
    private String nr_tel_fix;
    
    public NrFix(String nr_tel_fix){
        super(nr_tel_fix);
    }
    
    public void setNrFix(String nr_tel_fix){
        if(nr_tel_fix != null)
        this.nr_tel_fix = nr_tel_fix;
    }
    
    public void validareNumar(){
        if(nr_tel_fix == null || this.nr_tel_fix.substring(0,2)!="02" || this.nr_tel_fix.substring(0,2)!="03" )
            System.out.println("Numar invalid. Numarul de telefon fix trebuie sa inceapa cu '02' sau '03'.");
    }

    @Override
    public int compareTo(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
