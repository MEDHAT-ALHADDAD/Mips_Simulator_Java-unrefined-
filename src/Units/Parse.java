package Units;

import java.util.Arrays;

public interface Parse {
    //ether make signed and unsigned or remove int[] and use string and decimal only
    public static int parseBtoD(int [] binarya){
         int[] saz=new int[binarya.length];
         int tempx=0;
        if(binarya[0]==1){
            for(int i=0;i<binarya.length;i++){
                if(binarya[i]==1)
                    saz[i]=0;
                else
                    saz[i]=1;
            }
            String jo = Arrays.toString(saz);
            String  replace = jo.replace(",", ""); //remove the commas
            String  replace1 = replace.replace("[", ""); //remove the right bracket
            String replace2 = replace1.replace("]", ""); //remove the left bracket
            String trim = replace2.replace(" ", ""); //remove trailing spaces from partially initialized arrays
            String temp=trim;
             tempx=-1*((Integer.parseInt(temp, 2))+1);
        }
        else if(binarya[0]==0){
            String jo = Arrays.toString(binarya);
            String  replace = jo.replace(",", ""); //remove the commas
            String  replace1 = replace.replace("[", ""); //remove the right bracket
            String replace2 = replace1.replace("]", ""); //remove the left bracket
            String trim = replace2.replace(" ", ""); //remove trailing spaces from partially initialized arrays
            String temp=trim;
             tempx=Integer.parseInt(temp, 2);
        }
        return tempx;
    }
 
    public static int parseBtoD_unsigned(int [] binarya){
         String jo = Arrays.toString(binarya);
        String  replace = jo.replace(",", ""); //remove the commas
        String  replace1 = replace.replace("[", ""); //remove the right bracket
        String replace2 = replace1.replace("]", ""); //remove the left bracket
        String trim = replace2.replace(" ", ""); //remove trailing spaces from partially initialized arrays
        String temp=trim;
        int tempx=Integer.parseUnsignedInt(temp, 2);
        return tempx;
    }
    
     public static int[] parseDtoB(int d,int size){
        String temp=Integer.toBinaryString(d);
        int[] res=new int[size];
        if(res.length<=temp.length()){
            for(int i=res.length-1,j=temp.length()-1;i>=0;i--,j--){
                res[i]=Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }
        else{
             for(int i=res.length-1,j=temp.length()-1;j>=0;i--,j--){
                res[i]=Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }
        
        return res;
    }
    
    public static String BtoS(int[] binary){
        String jo = Arrays.toString(binary);
        String  replace = jo.replace(",", ""); //remove the commas
        String  replace1 = replace.replace("[", ""); //remove the right bracket
        String replace2 = replace1.replace("]", ""); //remove the left bracket
        String trim = replace2.replace(" ", ""); //remove trailing spaces from partially initialized arrays
        String rd=trim;
        return rd;
    }
    
    public static int[] parseStoB(String s,int size){
        int [] res=new int[size];
        for(int i = 0; i < size; i++) {
           res[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
            return res;
    }
    
    public static int[] StoB(String s){
        int [] res=new int[32];
        int d=Integer.parseInt(s);
        /*for(int i = 0; i < size; i++) {
           res[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }*/
        res=parseDtoB(d,32);
            return res;
    }
    
}
    /*public static int[] parseDtoB_unsigned(int d,int size){
        int [] res=new int[size];
        if(d<0){
            d*=-1;
        }
        int k;
        int i=size-1;
        while(d!=0&&i!=-1){
            k=d%2;
            d/=2;
            res[i]=k;
            i--;
        }
        return res;
    }*/