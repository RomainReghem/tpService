/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

import java.util.Date;

/**
 *
 * @author romai
 */
public class Intervention {
    private Date debut = new Date();
    private int duree;
    private boolean annulee = false;
    private TypeIntervention typeIntervention;
    private Enseignant enseignant;
    private Salle salle;
    private UE ue;
    
    public Intervention(Salle s, UE u, Enseignant e, Date deb, int dur, TypeIntervention t){
            this.debut = deb;
            this.duree = dur;
            this.typeIntervention = t;
            this.enseignant = e;
            this.salle = s;
            this.ue = u;
           }
    
    public TypeIntervention getType(){
        return typeIntervention;
    }
    
    public int getDuree(){
        return duree;
    }
    
}
