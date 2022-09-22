import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class demo1 {
        public static void main(String[] args) {

            JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
            String sql1 = "select * from message1";
            List<Map<String, Object>> list = template.queryForList(sql1);
            String text = "";
            for (Map<String, Object> stringObjectMap : list) {
                String text_first = "";
                for (Object v : stringObjectMap.values()) {
                    text_first += v + "  ";
                }
                text += text_first + "\n";
            }
            System.out.println(text);
        }
}

