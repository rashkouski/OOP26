import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class PlantUMLRunner {
    private static String jarPath = "plantuml.jar"; // Domyślna ścieżka

    /**
     * Ustawia ścieżkę do pliku wykonywalnego plantuml.jar.
     * @param path Pełna ścieżka do pliku jar.
     */
    public static void setJarPath(String path) {
        jarPath = path;
    }

    /**
     * Generuje schemat na podstawie przekazanych danych tekstowych.
     * @param data Treść schematu w formacie PlantUML (np. zaczynająca się od @startuml).
     * @param outputDir Ścieżka do katalogu wynikowego.
     * @param fileName Nazwa pliku wynikowego (bez rozszerzenia, PlantUML doda .png).
     */
    public static void generateDiagram(String data, String outputDir, String fileName) throws IOException, InterruptedException {
        // 1. Utworzenie katalogu, jeśli nie istnieje
        File dir = new File(outputDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 2. Utworzenie tymczasowego pliku tekstowego z danymi
        // PlantUML najłatwiej przetwarza pliki z dysku
        File tempFile = new File(outputDir, fileName + ".puml");
        try (OutputStream os = new FileOutputStream(tempFile)) {
            os.write(data.getBytes(StandardCharsets.UTF_8));
        }

        // 3. Budowanie komendy: java -jar path/to/plantuml.jar path/to/tempFile.puml
        ProcessBuilder pb = new ProcessBuilder(
                "java",
                "-jar",
                jarPath,
                tempFile.getAbsolutePath()
        );

        // Przekierowanie błędów do strumienia wyjściowego Javy (opcjonalne, ułatwia debugowanie)
        pb.inheritIO();

        // 4. Uruchomienie procesu
        Process process = pb.start();
        int exitCode = process.waitFor();

        if (exitCode == 0) {
            System.out.println("Schemat wygenerowany pomyślnie: " + outputDir + "/" + fileName + ".png");
        } else {
            System.err.println("Błąd PlantUML. Kod wyjścia: " + exitCode);
        }

        // 5. Opcjonalne usunięcie pliku tymczasowego .puml
        // tempFile.delete();
    }
}