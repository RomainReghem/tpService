package champollion;

import java.util.LinkedList;
import java.util.List;

public class Enseignant extends Personne {

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML
    ServicePrevu servicePrevu;
    private final List<Intervention> mesInterventions = new LinkedList<>();

    public Enseignant(String nom, String email) {
        super(nom, email);
        servicePrevu = new ServicePrevu();
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        double cm = 1.5*servicePrevu.getVolumeCM();
        double td = servicePrevu.getVolumeTD();
        double tp = 0.75*servicePrevu.getVolumeTP();
        return (int)Math.round(cm + td + tp);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        // TODO: Implémenter cette méthode
        double cm = 1.5*servicePrevu.getVolumes().get(ue)[0];
        double td = servicePrevu.getVolumes().get(ue)[1];
        double tp = servicePrevu.getVolumes().get(ue)[2];
        return (int)Math.round(cm + td + tp);
       
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        // TODO: Implémenter cette méthode
        int[] valeurs = {volumeCM, volumeTD, volumeTP};
        servicePrevu.setHeures(ue, valeurs);
    }
    
    public void ajouteIntervention(Intervention e){
        mesInterventions.add(e);
    }
    
    public int heuresPlanifiees(){
      int compteHeures = 0;
      for (int i=0; i<mesInterventions.size();i++){
          if(null != mesInterventions.get(i).getType())switch (mesInterventions.get(i).getType()) {
              case CM:
                  compteHeures += 1.5*mesInterventions.get(i).getDuree();
                  break;
              case TD:
                  compteHeures += 1*mesInterventions.get(i).getDuree();
                  break;
              case TP:
                  compteHeures += 0.75*mesInterventions.get(i).getDuree();
                  break;
              default:
                  break;
          }          
      }
      return (int)Math.round(compteHeures);
    }
    
    public boolean enSousService(){
        return (heuresPlanifiees() <= heuresPrevues());
    }

}
