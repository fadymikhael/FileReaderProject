import java.nio.file.Paths;
import java.util.List;

public class FileReaderMain {
    public static void main(String[] args) {
        // Créer une instance de TextFileReaderBase
        FileReaderInterface textReader = new TextFileReaderBase();

        // Liste des chemins de fichiers à lire
        List<String> filePaths = List.of(
                "C:\\Users\\max-_\\OneDrive\\Desktop\\Sorbonne\\Java\\FileReader\\test.txt",
                "C:\\Users\\max-_\\OneDrive\\Desktop\\Sorbonne\\Java\\FileReader\\test2.xml"
        );

        // Parcourir les fichiers à lire
        for (String filePath : filePaths) {
            System.out.println("\nLecture du fichier : " + filePath);

            try {
                textReader.readFile(filePath);

                // Afficher le contenu du fichier
                System.out.println("Contenu du fichier :");
                textReader.displayContent();

                // Afficher le contenu à l'envers
                System.out.println("\nContenu à l'envers :");
                textReader.displayReversedContent();

                // Afficher le contenu palindromique
                System.out.println("\nContenu palindromique :");
                textReader.displayPalindromicContent();

                // Réinitialiser après chaque fichier
                ((TextFileReaderBase) textReader).clearLines();

            } catch (Exception e) {
                System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            }
        }
    }
}
