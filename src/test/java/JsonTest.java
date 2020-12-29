import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.letokba.g2048.api.GameEntity;

/**
 * @author Yong
 * @date 2020/12/29
 */
public class JsonTest {
    private String text = "{\n" +
            "  \"direction\": \"left\",\n" +
            "  \"array\": [\n" +
            "    2, 0, 4, 4,\n" +
            "    0, 2, 4, 0,\n" +
            "    0, 0, 4, 0,\n" +
            "    0, 2, 2, 0\n" +
            "  ]\n" +
            "}";

    @Test
    public void  test1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        GameEntity gameEntity = mapper.readValue(text, GameEntity.class);
        System.out.println(gameEntity);
    }
}
