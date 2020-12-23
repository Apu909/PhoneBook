package phonebook;

import java.time.LocalDate;

public class Contact {
    private String nume;
    private String prenume;
    LocalDate data_nasterii;
    NrTel          nr_tel;
    
    
    public Contact(String nume, String prenume, LocalDate data_nasterii, NrTel nr_tel){
        this.nume          = nume;
        this.prenume       = prenume;
        this.data_nasterii = data_nasterii;
        this.nr_tel        = nr_tel;
    }
    
    public Contact(String nume, String prenume, LocalDate data_nasterii){
        this.nume          = nume;
        this.prenume       = prenume;
        this.data_nasterii = data_nasterii;
        this.nr_tel        = new NrFix("0000000000");
    }
    
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        if(getClass()!=obj.getClass()){
            return false;
        }
        final Contact other = (Contact) obj;
        return (other.nume.equalsIgnoreCase(this.nume) && 
                other.prenume.equalsIgnoreCase(this.prenume) &&
                other.data_nasterii == this.data_nasterii &&
                other.nr_tel == this.nr_tel
                );
        }
    
    
    public void setProperties(Contact persoana){
        nume = persoana.nume;
        prenume = persoana.prenume;
        data_nasterii = persoana.data_nasterii;
        nr_tel = persoana.nr_tel;
        
    }
    
    public void setNume(){
        this.nume = nume;
    }
    
    public String getNume(){
        return nume;
    }
    
    public void setPrenume(){
        this.prenume = prenume;
    }
    
    public String getPrenume(){
        return prenume;
    }
    
    public void setDataNasterii(){
        this.data_nasterii = data_nasterii;
    }
    
    public LocalDate getDataNasterii(){
        return data_nasterii;
    }
    
    public void setNrTel(){
        this.nr_tel = nr_tel;
    }
    
    public NrTel getNrTel(){
        return nr_tel;
    }
    
    @Override
    public String toString(){
        return "Contact{ " + "nume: " + nume + ", prenume: " + prenume + ", data nasterii: " + data_nasterii + ", " + nr_tel + "}";
    }
}
