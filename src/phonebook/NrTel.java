package phonebook;

public abstract class NrTel implements Comparable{
    private String nr_tel;
    
    public NrTel(String nr_tel) {
        if(nr_tel.length()!=10)
            System.out.println("Numar de telefon invalid.");
        else{
        this.nr_tel = nr_tel;
        validareNumar();
        }
    }
    
    public abstract void validareNumar();
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass()!= obj.getClass()){
            return false;
        }
        final NrTel other = (NrTel) obj;
        return (other.nr_tel == this.nr_tel);
    }
    
    public int compareTo(NrTel otherNrTel){
        return this.nr_tel.compareTo(otherNrTel.nr_tel);
    }
    
    @Override
    public String toString(){
        return "Nr de telefon: " + nr_tel;
    }
}
