package fr.epsi.options;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class OptionsManager {
	
	private CommandLine cmd;

	protected boolean validateOptions(String[] args){
		Options options = new Options();
		OptionGroup actionGroup = new OptionGroup();
		
		options.addOption("h", "help", false, "Pour afficher l’aide ");
		
		actionGroup.addOption(
				 Option.builder("i")
				.longOpt("")
			.hasArg()
			.desc("Suivi du chemin du fichier CSV d'entrée ")
			.build()
		   );
		actionGroup.addOption(
				 Option.builder("c")
				.longOpt("categorie")
			.hasArg()
			.desc("suivi du nom de la catégorie pour filtrer les produits ")
			.build()
		   );
		actionGroup.addOption(
				 Option.builder("e")
				.longOpt("etiquette")
			.hasArg()
			.desc("suivi du chemin du fichier PDF qui contiendra les étiquettes produit ")
			.build()
		   );
		actionGroup.addOption(
				 Option.builder("f")
				.longOpt("fiche")
			.hasArg()
			.desc("suivi du chemin du fichier PDF contenant les fiches produit ")
			.build()
		   );
		actionGroup.addOption(
				 Option.builder("t")
				.longOpt("tva")
			.hasArg()
			.desc("montant de la TVA à utiliser pour calculer le prix TTC (par défaut 20%) ")
			.build()
		   );

		
		actionGroup.setRequired(true);
		
		options.addOptionGroup(actionGroup);
		
		CommandLineParser parser = new DefaultParser();
		
		try {
			cmd = parser.parse(options, args);
			
		} catch(ParseException e){
			new HelpFormatter().printHelp("java" + this.getClass().getName(),"", options, "\n" + e.getMessage());
			return false;
		} 
		return true;
	}
	
	protected void doSomething(){
        if (cmd.hasOption("h") || cmd.hasOption("help"))
        {
			System.out.println("help");
		}
		if (cmd.hasOption("i"))
		{
			System.out.println("i");
		}
        if (cmd.hasOption("etiquette") || cmd.hasOption("e"))
        {
          	System.out.println("etiquete");
		}
        if (cmd.hasOption("fiche")  || cmd.hasOption("f"))
        {
        	    System.out.println("fiche");
        }
        if (cmd.hasOption("tva") || cmd.hasOption("t"))
        {
        	    System.out.println("tva");
        {
        	if (cmd.hasOption("categorie") || cmd.hasOption("c"))
        	{
        		System.out.println("catagorie");  
        }
      }
     }
	}
	
    public OptionsManager(String[] args){
    		cmd = null;
    		if(validateOptions(args)){
    			doSomething();
    		}
    }
	
	public static void main(String[] args){
		new OptionsManager(args);
	}
	
	
	
/*
	private void addOptions(){
		
		options.addOption("i", true, "Suivi du chemin du fichier CSV d'entrée.");
		options.addOption("categorie", true, "suivi du nom de la catégorie pour filtrer les produits");
		options.addOption("etiquette", true, "suivi du chemin du fichier PDF qui contiendra les étiquettes produit");
		options.addOption("fiche", true, "suivi du chemin du fichier PDF contenant les fiches produit");
		options.addOption("tva", true, "montant de la TVA à utiliser pour calculer le prix TTC (par défaut 20%)");
	}
*/
	
	
	
}
