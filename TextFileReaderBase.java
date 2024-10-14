import java.io.*;

public class TextFileReaderBase implements FileReaderInterface {

    // Tableau pour stocker les lignes (ici on suppose un maximum de 100 lignes)
    protected String[] lines = new String[100];
    protected int lineCount = 0; // Compteur pour suivre le nombre de lignes lues

    // Lire un fichier (texte ou XML) sans ArrayList
    @Override
    public void readFile(String filePath) {
        lineCount = 0;  // Réinitialiser le compteur de lignes pour chaque fichier
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (lineCount < lines.length) {
                    lines[lineCount++] = line;  // Ajouter chaque ligne du fichier dans le tableau
                } else {
                    System.out.println("Le fichier contient plus de lignes que la capacité du tableau.");
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    // Afficher le contenu du fichier
    @Override
    public void displayContent() {
        for (int i = 0; i < lineCount; i++) {
            System.out.println(lines[i]);
        }
    }

    // Afficher le contenu à l'envers (par lignes)
    @Override
    public void displayReversedContent() {
        for (int i = lineCount - 1; i >= 0; i--) {
            System.out.println(lines[i]);
        }
    }

    // Afficher le contenu palindromique (par caractères)
    @Override
    public void displayPalindromicContent() {
        for (int i = 0; i < lineCount; i++) {
            System.out.println(new StringBuilder(lines[i]).reverse().toString());
        }
    }

    // Réinitialiser le tableau et le compteur après chaque lecture
    public void clearLines() {
        lines = new String[100];  // Réinitialiser le tableau
        lineCount = 0;            // Réinitialiser le compteur
    }
}
