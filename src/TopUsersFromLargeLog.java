import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TopUsersFromLargeLog {
    private static final int TOP_K = 10;

    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("arquivos/logs.txt");
        Map<String, Long> userCount = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;

            while ((line = reader.readLine()) != null){
                // 2023-06-01 12:34:56 user123 action1
                int lastSpace = line.lastIndexOf(' ');
                if (lastSpace < 0 || lastSpace == line.length() - 1) {
                    continue;
                }

                String userId = line.substring(lastSpace + 1);
                userCount.merge(userId, 1L, Long::sum);
            }
        }

        PriorityQueue<Map.Entry<String, Long>> heap = new PriorityQueue<>(
                Comparator.comparingLong(Map.Entry::getValue)
        );

        for (Map.Entry<String, Long> entry : userCount.entrySet()) {
            heap.offer(entry);
            if (heap.size() > TOP_K) {
                heap.poll();
            }
        }
        // Etapa 4: Ordenar por maior frequência
        List<Map.Entry<String, Long>> topUsers = new ArrayList<>(heap);
        topUsers.sort(
                Map.Entry.<String, Long>comparingByValue().reversed()
        );

        // Etapa 5: Exibir os resultados
        System.out.println("TOP 10 USUARIOS");

        int position = 1;

        for (Map.Entry<String, Long> entry : topUsers) {
            System.out.printf(
                    "%d. %s - %d ocorrências%n",
                    position++,
                    entry.getKey(),
                    entry.getValue()
            );
        }
    }
}
