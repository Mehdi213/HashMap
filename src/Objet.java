public class Objet {
    private int val;
    private String o;


    public Objet(){


    }
    public Objet(int val,String o){
        this.val=val;
        this.o=o;
    }


    public int getVal(){
        return val;
    }


    public String getO(){
        return o;
    }

    public void setVal(int val){
        this.val=val;
    }

    public void setO(String o){
        this.o=o;
    }

    @Override
    public String toString() {
        return "Objet{" +
                "val=" + val +
                ", o='" + o + '\'' +
                '}';
    }
}
