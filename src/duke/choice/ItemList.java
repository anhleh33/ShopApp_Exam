package duke.choice;
import io.helidon.common.http.Http;
import io.helidon.webserver.Handler;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.ServerRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ItemList implements Handler {
    private ArrayList<Clothing> items;

    public ItemList(ArrayList<Clothing> items) {
        this.items = items;
    }

    @Override
    public void accept(ServerRequest req, ServerResponse res) {
        res.status(Http.Status.OK_200);
        res.headers().put("Content-Type", "application/json; charset=utf-8");

        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(items); // ✅ auto converts List<Clothing> to JSON
            res.send(json);
        } catch (Exception e) {
            res.status(Http.Status.INTERNAL_SERVER_ERROR_500).send("Error converting to JSON");
        }
    }

//    @Override
//    public void accept(ServerRequest req, ServerResponse res) {
//        // Set response status + headers
//        res.status(io.helidon.common.http.Http.Status.OK_200)
//                .headers()
//                .put("Content-Type", "text/plain; charset=UTF-8");
//
//        // Build response body
//        StringBuilder result = new StringBuilder();
//        for (Clothing item : items) {
//            result.append(item.toString()).append("\n");
//        }
//
//        // Always send a non-null string
//        res.send(result.toString());
//    }


}
