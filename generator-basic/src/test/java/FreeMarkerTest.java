import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeMarkerTest {
    @Test
    public void test() throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);

        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("UTF-8");

        // 创建模板对象，加载指定模板
        Template template = configuration.getTemplate("myweb.html.ftl");

        //数据模型
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear", 2024);
        List<Map<String,Object>> menuItems = new ArrayList<>();
        Map<String,Object> itemItem1 = new HashMap<>();
        itemItem1.put("url", "https://www.baidu.com");
        itemItem1.put("label","编程星球");
        Map<String,Object> itemItem2 = new HashMap<>();
        itemItem2.put("url", "https://www.aliyun.com");
        itemItem2.put("label","阿里云");
        menuItems.add(itemItem1);
        menuItems.add(itemItem2);
        dataModel.put("menuItems", menuItems);
        Writer out = new FileWriter(new File("myweb.html"));
        template.process(dataModel,out);
        out.close();
    }
}
