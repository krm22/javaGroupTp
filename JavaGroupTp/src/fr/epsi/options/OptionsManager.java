package fr.epsi.options;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class OptionsManager {
	
	private String csv;
	private Options options = new Options();
	private String[] arg = null;
	private String etiquette;
	private String fiche;
	private String tvaAmount;
    private String categorie = null;
	
	public boolean validateOptions(String[] args){
		arg = args;

		options.addOption("h", false, "Pour afficher l’aide ");
		options.addOption("i", true, "Suivi du chemin du fichier CSV d'entrée.");
		options.addOption("categorie", true, "suivi du nom de la catégorie pour filtrer les produits");
		options.addOption("etiquette", true, "suivi du chemin du fichier PDF qui contiendra les étiquettes produit");
		options.addOption("fiche", true, "suivi du chemin du fichier PDF contenant les fiches produit");
		options.addOption("tva", true, "montant de la TVA à utiliser pour calculer le prix TTC (par défaut 20%)");
		
		doSomething();
		return true;
	}
	
	public void help(String e)
	{   
		new HelpFormatter().printHelp("java" + this.getClass().getName(),"", options, "\n" + e);

	}
	
	public void doSomething(){
		
		CommandLineParser parser = new DefaultParser();
		
		try {
		CommandLine cmd = parser.parse(options, arg);

        if (cmd.hasOption("h") || cmd.hasOption("help"))
        {
			help("There has been an error");

		}
		if (cmd.hasOption("i"))
		{
			csv = cmd.getOptionValue("i");
		}
        if (cmd.hasOption("etiquette"))
        {
          	etiquette = cmd.getOptionValue("etiquette");
		}
        if (cmd.hasOption("fiche"))
        {
        	fiche = cmd.getOptionValue("fiche");
        }
        if (cmd.hasOption("tva"))
        {
        	tvaAmount =  cmd.getOptionValue("tva");
        {
        	if (cmd.hasOption("categorie"))
        	{
        		categorie = cmd.getOptionValue("categorie");
        	}
      }
     }
     } catch(ParseException e){
			help(e.toString());
		}
	}
	
    public OptionsManager(String[] args){
    		validateOptions(args);    		
    }	
	
	public String getCsv(){
		return csv;
	}
	
	public String getEtiquette(){
		return etiquette;
	}
	
	public String getFiche(){
		return fiche;
	}
	
	public String getTva(){
		return tvaAmount;
	}
	
	public String getCatergorie(){
		return categorie;
	}
}


	
	
	
	
	
