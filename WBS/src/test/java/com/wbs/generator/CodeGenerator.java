package com.wbs.generator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.IFileCreate;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.wbs.base.BaseController;
import com.wbs.base.BaseEntity;


public class CodeGenerator {

	private static String packageName="com.wbs";
    private static String authorName="YF";    
    private static String dbDriver = "org.postgresql.Driver";
    private static String dbPath = "jdbc:postgresql://localhost:5432/mybatisdb";
    private static String dbUser = "postgres";
    private static String dbPassword = "dl123";

    public static void main(String[] args) {
        // 代码生成
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("src/main/java");//输出目录
        gc.setFileOverride(true);// 是否覆盖文件
        gc.setActiveRecord(false);// activeRecord 模式
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setOpen(false);//生成后打开文件夹
        gc.setAuthor(authorName);
        // 自定义文件命名，注意 %s 会自动填充表实体属性
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sDto");
        gc.setControllerName("%sController");
//        gc.setIdType(IdType.ASSIGN_UUID);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setSchemaName("public"); // TODO 配置 schema
        dsc.setUrl(dbPath);
        dsc.setDriverName(dbDriver);
        dsc.setUsername(dbUser);
        dsc.setPassword(dbPassword);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("模块名"));
        pc.setParent(packageName);
        pc.setController("controller");// 这里是控制器包名，默认 web
        pc.setEntity("entity");
        pc.setMapper("dao");
        pc.setService("service");
        pc.setServiceImpl("dto");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("schema", "public"); // TODO 自定义实体类对应表的schema
                this.setMap(map);
            }
        }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig("/templates/mapper.xml.vm") {
        	// 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        })).setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                return true;// 覆盖已经生成的文件
            }
        });
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setSuperEntityClass(BaseEntity.class);
        strategy.setSuperEntityColumns("id","create_date","modify_date","version","active");
        strategy.setSuperControllerClass(BaseController.class);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        mpg.setStrategy(strategy);
        mpg.execute();
    }
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    @SuppressWarnings("resource")
	public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "!");
    }
	
}
