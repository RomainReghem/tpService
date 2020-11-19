package champollion;

import java.util.HashMap;
import java.util.Map;

public class ServicePrevu {
	// TODO : implémenter cette classe
    Map<UE, int[]> volumes = new HashMap<UE, int[]>();
    private int volumeCM;
    private int volumeTD;
    private int volumeTP;
    
    public void setHeures(UE ue, int[] volumeE){
        // Si on a déjà des heures pour un certain UE, je le sors de la map, additionne et remet
        if (volumes.containsKey(ue)){
            int[] tab = volumes.get(ue);
            volumes.remove(ue);
            tab[0] += volumeE[0];
            tab[1] += volumeE[1];
            tab[2] += volumeE[2];
            volumes.put(ue, tab);
        }
        else {
            volumes.put(ue, volumeE);
        }
        //Quand on demande pas les UE ce sera plus simple
        volumeCM += volumeE[0];
        volumeTD += volumeE[1];
        volumeTP += volumeE[2];
    }
    
    public int getVolumeCM(){
        return volumeCM;
    }
    public int getVolumeTD(){
        return volumeTD;
    }
    public int getVolumeTP(){
        return volumeTP;
    }
    public Map<UE, int[]> getVolumes(){
        return volumes;
    }

}
