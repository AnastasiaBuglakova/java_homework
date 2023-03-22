import java.util.ArrayList;
import java.util.Objects;

/**
 * Notebook
 */
public class Notebook {
    String partNumber;
    String color;
    Double ozuGb;
    Double pzuGb;
    String oS;
    Double size;
    Double  weight;
    String used;
    
    public Notebook(){
        partNumber = "zw000000";
        color = "black";
        ozuGb = 256D;
        pzuGb = 512D;
        oS = "Windows";
        size = 15.6;
        weight = 1.6;
        used = "new";
    }
    public Notebook(String partNumber, String color, Double ozuGb, Double pzuGb, 
                    String oS, Double size, Double  weight, String used){
        this.partNumber = partNumber;
        this.color = color;
        this.ozuGb = ozuGb;
        this.pzuGb = pzuGb;
        this.oS = oS;
        this.size = size;
        this.weight = weight;
        this.used = used;
    }
    @Override
    public String toString() {
        return String.format("\ncolor: %s ozuGb: %.1f pzuGb: %.1f OS: %s size: %.1f weight: %.1f used: %s", color, ozuGb, pzuGb, 
                            oS, size, weight, used);
    }
    @Override
    public boolean equals(Object object) {
        Notebook obj = (Notebook) object;
        return this.partNumber .equals(obj.partNumber) && this.color.equals(obj.color) && this.ozuGb==obj.ozuGb 
                                        && this.pzuGb==obj.pzuGb && this.oS.equals(obj.oS) 
                                        && this.size==obj.size && this.weight==obj.weight && this.used==obj.used;
    }
    @Override
    public int hashCode() {
        return Objects.hash();
    }
    
    public String[] toArray() {
        // Notebook obj = (Notebook) object;
        String[] arrayOfNotebooks = new String[10];
        arrayOfNotebooks[0] = partNumber;
        arrayOfNotebooks[1] = color;
        arrayOfNotebooks[2] = ozuGb.toString();
        arrayOfNotebooks[3] = pzuGb.toString();
        arrayOfNotebooks[4] = oS;
        arrayOfNotebooks[5] = size.toString();
        arrayOfNotebooks[6] = weight.toString();
        if (used) {arrayOfNotebooks[7] = "true";}
        else {arrayOfNotebooks[7] = "false";}
        return arrayOfNotebooks;
    }

    // public Boolean contains(){
    //     return used;
    // }
    
    }
