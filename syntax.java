package compil;

public class syntax extends lexical {
	
	public String syntaxique(String chaine){
		if(chaine.equals("Start_Program")) return "Début du programme";
		else if(chaine.equals("Else ")) return "SINON";
		else if(chaine.equals("Start ")) return "Début d'un bloc";
		else if(chaine.equals("Finish ")) return "Fin d'un bloc";
		else if(chaine.startsWith("//.")) return "un commentaire";
		else if(chaine.equals("End_Program")) return "Fin du programme";
		else if(chaine.startsWith("ShowMes : \" ") && chaine.endsWith(" \" ;; ")) return "Affichage d'un message à l'ecran";
		else if(chaine.contains(" ")) {
			mot = chaine.split(" ");
			int i=0, k=1;
			
				if(mot[i].equals("Int_Number")){ 
					i++;
					if(mot[i].equals(":")){
						i++;
						if(id(mot[i]) != null){
							i++;
							while(mot[i].equals(",")){
								i++;
								k++;
								if(id(mot[i]) != null) i++;
							}
							if(mot[i].equals(";;")) return "Déclaration de "+k+" variables entiers";
						}
					}
					
				}
				else if(mot[i].equals("Give")){
					i++;
					if(id(mot[i]) != null){
						i++;
					if(mot[i].equals(":")){
						i++;
						if(num(mot[i]) == "Nombre entier") {
							i++;
							if(mot[i].equals(";;")) return "affectation dune valeur entiere à "+mot[i-3];
						}
						else if(num(mot[i]) == "Nombre reel"){
							i++;
							if(mot[i].equals(";;")) return "affectation dune valeur reel à "+mot[i-3];
						}
						
					}
				}
				
				}
				else if(mot[i].equals("Real_Number")){
					i++;
					if(mot[i].equals(" ")) i++;
						if(id(mot[i]) != null) i++;
							if(mot[i].equals(";;")) return "Déclaration de  variable reel";
						}
					
				
				else if(mot[i].equals("If")){
					i++;
					if(mot[i].equals("--")){
						i++;
					if(id(mot[i]) != null){
						i++;
						if(mot[i].equals("<") || mot[i].equals(">") || mot[i].equals("==")){
						i++;
						if(id(mot[i]) != null){
							i++;
						if(mot[i].equals("--")) return "condition"; 
							}}}}
				}
				
				
				
				else if(mot[i].equals("Affect")){
					i++;
					if(id(mot[i]) != null){
						i++;
					if(mot[i].equals("to")){
						i++;
						if(id(mot[i]) != null) {
							i++;
							if(mot[i].equals(";;")) return "affectation de "+mot[i-3]+" a "+mot[i-1];
						}

					}

				}
				}
				
				/* VRAI  */
				else if(mot[i].equals("ShowVal")){
					i++;
					if(mot[i].equals(":")){
						i++;
						if(id(mot[i]) != null){
							i++;
							if(mot[i].equals(";;")) return "affichage de la valeur de "+mot[i-1];
						}
						

				}}
				
				}
		return "erreur de syntaxe";
	}


}
