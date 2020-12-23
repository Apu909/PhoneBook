package phonebook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import static phonebook.Criteriu_Ordonare.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Agenda {
    private List<Contact> listaContacte = new ArrayList<>();
    
    private Map<Criteriu_Ordonare, Comparator> mapLambdaComparatori = new HashMap<>();
    
    private void getContacte() throws Exception{
        Contact persoana1;
        NrTel nr_fix = new NrFix("0736483746");
        persoana1 = new Contact("sss", "sads", LocalDate.of(2000, 12, 12), nr_fix);
        
        listaContacte.add(persoana1);
    }
    
    public Agenda() throws Exception{
        getContacte();
        populateLambdaFiltrareMap();
    }
    
    private void populateLambdaFiltrareMap(){
        Comparator<Contact> dupa_nume          = (p1, p2) -> p1.getNume().compareTo(p2.getNume());
        Comparator<Contact> dupa_prenume       = (p1, p2) -> p1.getPrenume().compareTo(p2.getPrenume());
        Comparator<Contact> dupa_data_nasterii = (p1, p2) -> p1.getDataNasterii().compareTo(p2.getDataNasterii());
        Comparator<Contact> dupa_nr_tel        = (p1, p2) ->p1.getNrTel().compareTo(p2.getNrTel());
        
        mapLambdaComparatori.put(ord_dupa_nume, dupa_nume);
        mapLambdaComparatori.put(ord_dupa_prenume, dupa_prenume);
        mapLambdaComparatori.put(ord_dupa_data_nasterii, dupa_data_nasterii);
        mapLambdaComparatori.put(ord_dupa_nr_tel, dupa_nr_tel);
    }
    
    public Contact getExistingContact(Contact persoana){
        for(Contact pers : listaContacte){
            if(persoana.equals(pers)){
                return pers;
            }
        }
        return null;
    }
    
    public boolean modifica(Contact persoana){
        Contact existingContact = getExistingContact(persoana);
        if(existingContact != null){
            existingContact.setProperties(persoana);
            return true;
        }
        return false;
    }
    
    public void addContact(Contact persoana){
        listaContacte.add(persoana);
    }
    
    public List<Contact> getListaContacte(){
        return listaContacte;
    }
    //filtrare_dupa_nrFix, filtrare_dupa_nrMobil, filtrare_dupa_dataNastereAzi, filtrare_dupa_dataNastereLuna, filtrare_dupa_sirIntrodus
    private Predicate<Contact> getLambdaFilter(Criteriu_Filtrare filter, String s){
        switch(filter){
            case filtrare_dupa_nrFix:
                return (p) -> p.getNrTel().toString().contains(s);
            case filtrare_dupa_nrMobil:
                return (p) -> p.getNrTel().toString().contains(s);
            case filtrare_dupa_dataNastereAzi:
                return (p) -> p.getDataNasterii().toString().contains(s);
            case filtrare_dupa_dataNastereLuna:
                return (p) -> p.getDataNasterii().toString().contains(s);
            case filtrare_dupa_sirIntrodus:
            default:
                return (p) -> listaContacte.contains(s);
        }
        
    }
        private Comparator<Contact> getLambdaOrdonare(Criteriu_Ordonare crit){
            return mapLambdaComparatori.get(crit);
        }
   
        public List<Contact> getListDeAfisat(Criteriu_Filtrare f, String s, Criteriu_Ordonare o){
            return listaContacte.stream()
                    .filter(getLambdaFilter(f, s))
                    .sorted(getLambdaOrdonare(o))
                    .collect(Collectors.toList());
        }
}
