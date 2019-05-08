import freemarker.template.*;


import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        //创建配置
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);//版本
        cfg.setDirectoryForTemplateLoading(new File("templates"));//模板母驴
        cfg.setDefaultEncoding("UTF-8");//模板文件字符集
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);//错误处理方式
        cfg.setLogTemplateExceptions(false);//
        cfg.setWrapUncheckedExceptions(true);

        //创建数据模型root
        Map root = new HashMap();//put左边为键，右边为值

        List orders = new ArrayList();
        orders.add(new Order());
        orders.add(new Order());


        root.put("orders", orders);//放置latestProduct

        //获得模板temp
        Template temp = cfg.getTemplate("allDeals.ftl");

        //合并模板和数据模型data-model+template=output
        File hellohtml = new File("D:\\Github\\LCweb\\lcweb leader\\web\\outputhtml\\alldeals.html");
        hellohtml.createNewFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(hellohtml));
        temp.process(root, out);
        out.flush();//对于webapplication
        out.close();
    }
}
