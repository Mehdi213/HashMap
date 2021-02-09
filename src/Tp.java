

import java.io.ObjectOutput;
import java.util.*;


public class Tp {
   TreeMap<String,Integer> treeMap = new TreeMap<>();
    TreeMap<String,Integer> treeMap1= new TreeMap<>();
    TreeMap<String,Integer> treeMap2= new TreeMap<>();
    ArrayList<Objet> list =new ArrayList<>();
    ArrayList<Objet>list1=new ArrayList<>();
    ArrayList<Objet> list2=new ArrayList<>();
    ArrayList<Objet> V =new ArrayList<>();
    ArrayList<Objet> F =new ArrayList<>();


    public  Tp(){

    }
    /*public void remplir(TreeMap<String,Integer> treeMap) {
        ArrayList<String> temp = new ArrayList<>();
        while (temp.size()<10){
            String randomO ="o"+(int) (Math.random()* 10);
            if (!(temp.contains(randomO))) {
                temp.add(randomO);
                int randomV=(int) (Math.random() * 10);
                treeMap.put(randomO,randomV);}}
                // TreeMap<Integer,String>sortedMap= Collections.synchronizedSortedMap(<Integer,String> treeMap);
                System.out.println(temp.size());
                System.out.println(treeMap);
                }*/

    public  void  remplir2(TreeMap<String, Integer> H, ArrayList<Objet> temp){
        ArrayList<String> deja =new ArrayList<>();
        while (H.size()<10) {
            int randomval = (int) ((Math.random()* 10)+1);
           // System.out.print(randomval+"     ");
            String randomO = "o" + (int) ((Math.random() * 10)+1);
           // System.out.println(randomO);
            if (!(deja.contains(randomO))){
                deja.add(randomO);
                temp.add(new Objet(randomval,randomO));
                H.putIfAbsent(randomO, randomval);
                }
                temp.sort((objet, t1) -> t1.getVal()-objet.getVal());



        }
        System.out.print("treeMap :    ");
        System.out.println(H);
        System.out.print("liste trié est  :        ");
        System.out.println(temp);
        //System.out.println(temp.size());


    }
    public  void  TopK(int K){
        int T = 0,P =0;
        int T1,i =0;
        ArrayList<String> deja = new ArrayList<>();
       do {
           T1= list.get(i).getVal()+list1.get(i).getVal()+list2.get(i).getVal();
        Objet objet = new Objet(list.get(i).getVal()+treeMap1.get(list.get(i).getO())+treeMap2.get(list.get(i).getO()),list.get(i).getO());
        Objet objet1 = new Objet(list1.get(i).getVal()+treeMap.get(list1.get(i).getO())+treeMap2.get(list1.get(i).getO()),list1.get(i).getO());
        Objet objet2 = new Objet(list2.get(i).getVal()+treeMap.get(list2.get(i).getO())+treeMap1.get(list2.get(i).getO()),list2.get(i).getO());
        if (!(deja.contains(objet.getO()))){
            deja.add(objet.getO());
            V.add(objet);
            V.sort((objet3, t1) -> t1.getVal()-objet3.getVal());
        }
        if (!(deja.contains(objet1.getO()))){
            deja.add(objet1.getO());
            V.add(objet1);
            V.sort((objet3, t1) -> t1.getVal()-objet3.getVal());
        }
        if (!(deja.contains(objet2.getO()))){
            deja.add(objet2.getO());
            V.add(objet2);
            V.sort((objet3, t1) -> t1.getVal()-objet3.getVal());
        }
           System.out.println("T "+i+"="+T1);
        i++;

       }while (T1>V.get(i).getVal());

        System.out.println(V);
        System.out.println(V.size());
        for (i=0;i<K;i++){
            F.add(V.get(i));

        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println( "Le top "+K+ "  est :"+F);
    }
    public boolean vrai (ArrayList <Objet>arrayList , int V,int K){

         for (int i=0; i<K; i++){
             if (arrayList.get(i).getVal()>=V){
                 return  true;
             }
         }
         return false;

    }


    public Objet Max (Objet a ,Objet b , Objet c)
     { Objet X = new Objet();
      if ( a.getVal()>=b.getVal()){
          X=a; }
      else
      {X=b;}
      if (X.getVal()>=c.getVal()){
          return X;
         }
      else{
          return c;
      }
     }
     @Override
    public String toString() {
        return "Tp{" +
                "list=" + list +
                ", list2=" + list1 +
                ", list3=" + list2+
                '}';
    }

    public static void main(String[] args) {
        Tp tp= new Tp();
        tp.remplir2(tp.treeMap,tp.list);
        tp.remplir2(tp.treeMap1,tp.list1);
        tp.remplir2(tp.treeMap2,tp.list2);
        tp.TopK(5);
    }
}
