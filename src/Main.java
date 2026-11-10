import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String procurado = "Dave";
        System.out.println("Procurando: " + procurado);

        long inicio = System.currentTimeMillis();

        String[] arquivos = {
                "arquivos/signatarios-fev-2002.txt",
                "arquivos/signatarios-fev-2016.txt",
                "arquivos/signatarios-out-2014.txt"
        };

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for(String arquivo : arquivos){
                BuscaNomeRunnable busca = new BuscaNomeRunnable(arquivo, procurado);
                executor.submit(busca);
            }
        }

        long fim = System.currentTimeMillis();
        System.out.println("Todas as buscas foram finalizadas.");
        System.out.println("Tempo Total: " + (fim - inicio) + " ms");
    }
}