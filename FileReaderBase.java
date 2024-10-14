import java.io.*;

public abstract class FileReaderBase implements FileReaderInterface {
    protected String[] lines = new String[100];
    protected int lineCount = 0;

    // Lire le fichier et stocker les lignes
    public void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null && lineCount < lines.length) {
                lines[lineCount++] = line; // Stocker chaque ligne dans le tableau
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    // Afficher le contenu à l'endroit
    public void displayContent() {
        for (int i = 0; i < lineCount; i++) {
            System.out.println(lines[i]);
        }
    }

    // Méthodes abstraites pour les sous-classes
    public abstract void displayReversedContent();
    public abstract void displayPalindromicContent();
}
