package org.letokba.g2048.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.letokba.g2048.core.GameHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yong
 * @date 2020/12/29
 */
@WebServlet(name = "game2048", urlPatterns = "/api/move")
public class GameServlet extends HttpServlet {
    private final GameHandler handler = new GameHandler();
    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GameEntity entity = mapper.readValue(request.getInputStream(), GameEntity.class);
        int[] array = handler.move(entity.getMatrix(), entity.getDirection());
        entity.setGameOver(handler.isGameOver(entity.getMatrix()));
        entity.setMatrix(array);
        mapper.writeValue(response.getOutputStream(), entity);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

}
