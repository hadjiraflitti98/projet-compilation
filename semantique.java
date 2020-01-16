package compil;

public class semantique extends syntax {
	
	public String semant(String chaine){
		if(chaine.equals("Start_Program")) return "public static void main(String[] args) {";
		else if(chaine.equals("Else ")) return "else";
		else if(chaine.equals("Start ")) return "{";
		else if(chaine.equals("Finish ")) return "}";
		else if(chaine.startsWith("//.")) return "/*ceci est un commentaire*/";
		else if(chaine.equals("End_Program")) return "}";
		else if(chaine.startsWith("ShowMes : \" ") && chaine.endsWith(" \" ;; ")) return "System.out.println(\"Affichage d'un message à l'ecran\");";
		else if(chaine.contains(" ")) {
			mot = chaine.split(" ");
			int i=0;

				if(mot[i].equals("Int_Number")){
					i++;
					if(mot[i].equals(":"))
						i++;
						if(id(mot[i]) != null){
							i++;
							while(mot[i].equals(",")){
								i++;
								if(id(mot[i]) != null) i++;
							}
							if(mot[i].equals(";;"))return "int"+mot[i-5]+","+mot[i-3]+","+mot[i-1]+";";
						}
					

				}
				
				else if(mot[i].equals("Give")){
					i++;
					if(id(mot[i]) != null){
						i++;
					if(mot[i].equals(":"))i++;
						if(num(mot[i]) == "Nombre entier") {
							i++;
							if(mot[i].equals(";;")) return mot[i-3]+"="+mot[i-1]+";";
						}
						else if(num(mot[i]) == "Nombre reel"){
							i++;
							if(mot[i].equals(";;")) return mot[i-3]+"="+mot[i-1]+";";
						}

					
				}

				}
				
				else if(mot[i].equals("Real_Number")){
					i++;
					if(mot[i].equals(" "))i++;
						if(id(mot[i]) != null)i++;
							if(mot[i].equals(";;")) return "float "+mot[i-1]+";";
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
						if(mot[i].equals("--")) return "if"+"("+mot[i-3]+mot[i-2]+mot[i-1]+")"; 
							}}}}
					else i++;
				}
				
				
				
				else if(mot[i].equals("Affect")){
					i++;
					if(id(mot[i]) != null){
						i++;
					if(mot[i].equals("to")){
						i++;
						if(id(mot[i]) != null) {
							i++;
							if(mot[i].equals(";;")) return  mot[i-3]+"="+mot[i-1]+";";
						}

					}

				}

				}
				
				
				else if(mot[i].equals("ShowVal")){
					i++;
					if(mot[i].equals(":"))i++;
						if(id(mot[i]) != null)i++;
							if(mot[i].equals(";;")) return "System.out.println("+mot[i-1]+");";
						}

				

				
								}
		return "erreur symantique";
		
	}


}
