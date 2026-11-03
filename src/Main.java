package src;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
        Path site = Path.of("site").toAbsolutePath().normalize();

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", exchange -> serve(exchange, site));
        server.start();

        System.out.println("Open http://localhost:" + port);
    }

    private static void serve(HttpExchange exchange, Path site) throws IOException {
        String method = exchange.getRequestMethod();

        if (!method.equals("GET") && !method.equals("HEAD")) {
            exchange.sendResponseHeaders(405, -1);
            exchange.close();
            return;
        }

        String request = exchange.getRequestURI().getPath();

        Path file = site.resolve(
            request.equals("/") ? "index.html" : request.substring(1)
        ).normalize();

        if (!file.startsWith(site) || !Files.isRegularFile(file)) {
            exchange.sendResponseHeaders(404, -1);
            exchange.close();
            return;
        }

        byte[] bytes = Files.readAllBytes(file);

        String contentType = request.endsWith(".css") ? "text/css; charset=utf-8"
                : request.endsWith(".js") ? "text/javascript; charset=utf-8"
                : request.endsWith(".png") ? "image/png"
                : request.endsWith(".jpg") || request.endsWith(".jpeg") ? "image/jpeg"
                : request.endsWith(".webp") ? "image/webp"
                : "text/html; charset=utf-8";

        exchange.getResponseHeaders().set("Content-Type", contentType);
        exchange.sendResponseHeaders(200, method.equals("HEAD") ? -1 : bytes.length);

        if (!method.equals("HEAD")) {
            exchange.getResponseBody().write(bytes);
        }

        exchange.close();
    }
}
