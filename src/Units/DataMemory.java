
package Units;

import static Units.Parse.parseDtoB;
import java.util.Scanner;
import javax.swing.JLabel;
import mipsproject10.APP;

public class DataMemory implements Parse{
    private final DataPath [] locations;
    private  int SP=400;
    private String read;
    private String write;
    private int address,location;

    public DataMemory() {
        this.locations = new DataPath[1024];
        this.read = "000";
        this.write = "00";
        this.address=0;
        SP=0;
    }

    public void setWrite(String write) {
        this.write = write;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public void setRead(String read) {
        this.read = read;
    }
    
    
    
    public DataPath load(){
        if("001".equals(read) && locations[this.address/4]!=null){//lw
          return locations[this.address/4];
        }
        else if("010".equals(read)&&locations[this.address/4]!=null){//lh
                SignExtend se=new SignExtend();
                DataPath d=new DataPath(16);
                if(address%4==0){
                 for(int i=0,j=0;j<16;i++,j++)
                        d.setbyte(i, locations[this.address/4].getbyte(j));
                }
                if(address%4==2){
                 for(int i=0,j=16;j<32;i++,j++)
                        d.setbyte(i, locations[this.address/4].getbyte(j));
                }
                se.setInput(d);
                return se.getOutput();
        }
        else if("100".equals(read)&&locations[this.address/4]!=null){//lb
                SignExtend se=new SignExtend();
                DataPath d=new DataPath(8);
            switch (address%4) {
                case 0:
                    for(int i=0,j=0;j<8;i++,j++)
                        d.setbyte(i, locations[this.address/4].getbyte(j));
                    break;
                case 1:
                    for(int i=0,j=8;j<16;i++,j++)
                        d.setbyte(i, locations[this.address/4].getbyte(j));
                    break;
                case 2:
                    for(int i=0,j=16;j<24;i++,j++)
                        d.setbyte(i, locations[this.address/4].getbyte(j));
                    break;
                case 3:
                    for(int i=0,j=24;j<32;i++,j++)
                        d.setbyte(i, locations[this.address/4].getbyte(j));
                    break;
                default:
                    break;
            }
                se.setInput8(d);
                return se.getOutput8();
            }
        else if("011".equals(read)&&locations[this.address/4]!=null){//lbu
                SignExtend se=new SignExtend();
                DataPath d=new DataPath(8);
                switch (address%4) {
                case 0:
                    for(int i=0,j=0;j<8;i++,j++)
                        d.setbyte(i, locations[this.address/4].getbyte(j));
                    break;
                case 1:
                    for(int i=0,j=8;j<16;i++,j++)
                        d.setbyte(i, locations[this.address/4].getbyte(j));
                    break;
                case 2:
                    for(int i=0,j=16;j<24;i++,j++)
                        d.setbyte(i, locations[this.address/4].getbyte(j));
                    break;
                case 3:
                    for(int i=0,j=24;i<32;i++,j++)
                        d.setbyte(i, locations[this.address/4].getbyte(j));
                    break;
                default:
                    break;
            }
                se.setInput8(d);
                return se.getOutput8u();
        }
        else if("101".equals(read)&&locations[this.address/4]!=null){//lhu
                SignExtend se=new SignExtend();
                DataPath d=new DataPath(16);
                 if(address%4==0){
                 for(int i=0,j=0;j<16;i++,j++)
                        d.setbyte(i, locations[this.address/4].getbyte(j));
                }
                if(address%4==2){
                 for(int i=0,j=16;j<32;i++,j++)
                        d.setbyte(i, locations[this.address/4].getbyte(j));
                }
                se.setInput(d);
                return se.getOutputu();
            }
        return new DataPath(32);
    }
    
    public void store(int[]value){
        if(null != write){
            switch (write) {
                case "10"://sw
                    if(locations[address/4]==null){
                        locations[address/4]=new DataPath(32);
                 
                    }
                    locations[address/4].setBits(value);
                    break;
                case "11":{//sh
                    if(locations[address/4]==null){
                        locations[address/4]=new DataPath(32);
                    }
                    DataPath d=new DataPath(16);
                  //  SignExtend se=new SignExtend();
                    for(int i=16,j=0;i<32;i++,j++)
                        d.setbyte(j, value[i]);
                  //  se.setInput(d);
                    if(address%4==0){
                     for(int i=0;i<16;i++)
                        locations[address/4].setbyte(i, d.getbyte(i));
                    }
                    else if(address%4==2){
                      for(int i=16,j=0;i<32;i++,j++)
                        locations[address/4].setbyte(i, d.getbyte(j));
                    }
                        break;
                    }
                case "01":{//sb
                    if(locations[address/4]==null){
                        locations[address/4]=new DataPath(32);
                    }
                    DataPath d=new DataPath(8);
                  //  SignExtend se=new SignExtend();
                    for(int i=24,j=0;i<32;i++,j++)
                        d.setbyte(j, value[i]);
                //  se.setInput(d);
                switch (address%4) {
                    case 0:
                        for(int i=0;i<8;i++)
                            locations[address/4].setbyte(i, d.getbyte(i));
                        break;
                    case 1:
                        for(int i=8,j=0;i<16;i++,j++)
                            locations[address/4].setbyte(i, d.getbyte(j));
                        break;
                    case 2:
                        for(int i=16,j=0;i<24;i++,j++)
                            locations[address/4].setbyte(i, d.getbyte(j));
                        break;
                    case 3:
                        for(int i=24,j=0;i<32;i++,j++)
                            locations[address/4].setbyte(i, d.getbyte(j));
                        break;
                    default:
                        break;
                }
                break;
                }
                default:
                    break;
            }
        }
    }
    
    
    
    public void loadData(){
        //2l user hyda5al 3adad 2l arrays 
        //ba3den hyda5al 7agm 2l array
        //ba3d keda hyd5al 2l location 2le 3yzo yt3mlo save feh
        //ba3d keda yd5al 2l elements bta3t 2l array
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int ad;
        int number;
        int size;
        for(int i=0;i<num;i++){
            size=sc.nextInt();
            ad=sc.nextInt();
            for(int j=0;j<size;j++){
                number=sc.nextInt();
                locations[ad+i].setBits(parseDtoB(number,32));
            }
        }
    }
    
   /* public void store(int ad,int da){////////////////////////
        if(locations[ad/4]==null){
                        locations[ad/4]=new DataPath(32);
                 
                    }
                    locations[ad/4].setBits(parseDtoB(da,32));
        SP=ad;
    }*/

    public  int getSP() {
        return SP;
    }

    public void setSP(int SP) {
        this.SP = SP;
    }

    public int getAddress() {
        return address;
    }

    public int getLocation() {
        location=Parse.parseBtoD(this.locations[address/4].getBits());
        return location;
    }
    
    
    
}

  /*public void storeSp(int[] value){
        if(null != write){
                switch (write) {
                case "10":
                    locations[SP].setBits(value);
                    SP++;
                    break;
                case "11":{
                    DataPath d=new DataPath(16);
                    SignExtend se=new SignExtend();
                    for(int i=16,j=0;i<32;i++,j++)
                        d.setbyte(j, value[i]);
                    se.setInput(d);
                    locations[SP]=se.getOutput();
                    SP++;
                        break;
                    }
                case "01":{
                    DataPath d=new DataPath(8);
                    SignExtend se=new SignExtend();
                    for(int i=8,j=0;i<32;i++,j++)
                        d.setbyte(j, value[i]);
                    se.setInput8(d);
                    locations[SP]=se.getOutput();
                    SP++;
                        break;
                    }
                default:
                    break;
            }
        }
    }*/
    /*public static void setSP(int SP) {
        DataMemory.SP = SP;
    }*/

  /* public void delete(int loc){
        if("10".equals(write) && locations[loc]!=null)
            locations[loc]=null;
    }*/

/* public void deleteSp(){
        if("10".equals(write) && locations[SP]!=null){
            locations[SP]=null;
                SP--;
        }
    }*/
/*
public DataPath load(int n){
        if("001".equals(read) && locations[n]!=null){
          return locations[n];
        }
        else if("010".equals(read)&&locations[n]!=null){
                SignExtend se=new SignExtend();
                DataPath d=new DataPath(16);
                for(int i=16;i<32;i++)
                    d.setbyte(i, locations[n].getbyte(i));
                se.setInput(d);
                return se.getOutput();
            }
        else if("100".equals(read)&&locations[n]!=null){
                SignExtend se=new SignExtend();
                DataPath d=new DataPath(8);
                for(int i=24;i<32;i++)
                    d.setbyte(i, locations[n].getbyte(i));
                se.setInput8(d);
                return se.getOutput();
            }
        else if("011".equals(read)&&locations[n]!=null){
                SignExtend se=new SignExtend();
                DataPath d=new DataPath(8);
                for(int i=24;i<32;i++)
                    d.setbyte(i, locations[n].getbyte(i));
                se.setInput8(d);
                return se.getOutputu();
            }
        else if("101".equals(read)&&locations[n]!=null){
                SignExtend se=new SignExtend();
                DataPath d=new DataPath(16);
                for(int i=16;i<32;i++)
                    d.setbyte(i, locations[n].getbyte(i));
                se.setInput(d);
                return se.getOutputu();
            }
        else
            return null;
    }*/