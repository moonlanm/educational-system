package edu.hubu.edusysgen;

import edu.hubu.commons.model.BaseModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import io.swagger.annotations.ApiModel;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.JarURLConnection;
import java.net.URLDecoder;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


/**
 * @author moonlan
 * date 2021/1/25 下午2:07
 */
@SuppressWarnings(value = "unused")
public class CMXSGen {
    public static void main(String[] args) {
        //serviceGen();
        serviceImplGen();
        //controllerGen();
    }

    private static void controllerGen() {
        String path = "/home/moonlan/code/java/educational-system/educational-system-gen/src/main/resources/ftls";
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);
        try {
            configuration.setDirectoryForTemplateLoading(new File(path));
            String[] packageName = {"teacher", "admin", "student"};
            for (String s : packageName) {
                List<Class<?>> classes = getClasses("edu.hubu.commons.model." + s);
                for (Class<?> clazz : classes) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("modelName", clazz.getSimpleName().replace(clazz.getSimpleName().charAt(0),
                            (char) (clazz.getSimpleName().charAt(0) + 32)));
                    map.put("modelClassName", clazz.getSimpleName());
                    map.put("packageName", s);
                    map.put("modelDesc", clazz.getAnnotation(ApiModel.class).value());
                    Field[] clazzFields = clazz.getDeclaredFields();
                    boolean hasDeleted = false;
                    for (Field f : clazzFields) {
                        if (BaseModel.class.isAssignableFrom(f.getType())) {
                            continue;
                        }

                        if (Collection.class.isAssignableFrom(f.getType())) {
                            continue;
                        }
                        if (Modifier.isStatic(f.getModifiers()) || Modifier.isFinal(f.getModifiers())) {
                            continue;
                        }
                        if (f.getName().endsWith("IsDeleted")) {
                            hasDeleted = true;
                        }
                    }
                    map.put("isDeleted", hasDeleted);
                    Template template = configuration.getTemplate("controller.flt");
                    //FileWriter writer = new FileWriter("/home/moonlan/code/java/educational-system/src/main/java
                    // /edu/hubu/provider" + s + "/controller" + "/" + clazz.getSimpleName() + "Controller.java");
                    FileWriter writer =
                            new FileWriter("/home/moonlan/code/java/src/controller" + "/" + clazz.getSimpleName() +
                                    "Controller.java");
                    template.process(map, writer);
                    //template.process(map, new PrintWriter(System.out));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void serviceImplGen() {
        String path = "/home/moonlan/code/java/educational-system/educational-system-gen/src/main/resources/ftls";
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);
        try {
            configuration.setDirectoryForTemplateLoading(new File(path));
            String[] packageName = {"teacher", "admin", "student"};
            for (String s : packageName) {
                List<Class<?>> classes = getClasses("edu.hubu.commons.model." + s);
                for (Class<?> clazz : classes) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("modelName", clazz.getSimpleName().replace(clazz.getSimpleName().charAt(0),
                            (char) (clazz.getSimpleName().charAt(0) + 32)));
                    map.put("modelClassName", clazz.getSimpleName());
                    map.put("packageName", s);
                    Field[] clazzFields = clazz.getDeclaredFields();
                    ArrayList<String> fields = new ArrayList<>();
                    ArrayList<ArrayList<String>> joinFields = new ArrayList<>();
                    boolean hasDeleted = false;
                    boolean isString = false;
                    for (Field f : clazzFields) {
                        f.setAccessible(true);
                        if (BaseModel.class.isAssignableFrom(f.getType())) {
                            Field[] declaredFields = f.getType().getDeclaredFields();
                            ArrayList<String> strings = new ArrayList<>();
                            for (Field f1 : declaredFields) {
                                if (f1.getName().endsWith("IsDeleted") || f1.getName().endsWith("IsForbidden")) {
                                    continue;
                                }
                                if (Modifier.isStatic(f1.getModifiers()) || Modifier.isFinal(f1.getModifiers())) {
                                    continue;
                                }
                                if (BaseModel.class.isAssignableFrom(f1.getType())) {
                                    continue;
                                }
                                if (Collection.class.isAssignableFrom(f1.getType())) {
                                    continue;
                                }


                                strings.add(f1.getName());
                            }
                            map.put("joinModelClassName", f.getType().getSimpleName());
                            map.put("joinModelName",
                                    f.getType().getSimpleName().replace(clazz.getSimpleName().charAt(0),
                                            (char) (clazz.getSimpleName().charAt(0) + 32)));
                            joinFields.add(strings);
                            continue;
                        }

                        if (String.class.isAssignableFrom(f.getType())) {
                            isString = true;
                        }

                        if (Collection.class.isAssignableFrom(f.getType())) {
                            continue;
                        }
                        if (Modifier.isStatic(f.getModifiers()) || Modifier.isFinal(f.getModifiers())) {
                            continue;
                        }
                        if (f.getName().endsWith("IsDeleted")) {
                            hasDeleted = true;
                        }

                        fields.add(f.getName());
                    }
                    map.put("props", fields);
                    map.put("joinProps", joinFields);
                    map.put("isDeleted", hasDeleted);
                    map.put("isString", isString);
                    Template template = configuration.getTemplate("serviceimpl.flt");
                    //FileWriter writer = new FileWriter("/home/moonlan/code/java/educational-system/educational
                    // -system-commons/src/main/java/edu/hubu/commons/service/" + s + "/impl/" + clazz.getSimpleName
                    // () + "ServiceImpl.kt");
                    FileWriter writer = new FileWriter("/home/moonlan/code/java/src/service/impl/" + clazz.getSimpleName
                            () + "ServiceImpl.kt");
                    //template.process(map, new PrintWriter(System.out));
                    template.process(map, writer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void serviceGen() {
        String path = "/home/moonlan/code/java/educational-system/educational-system-gen/src/main/resources/ftls";
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);
        try {
            configuration.setDirectoryForTemplateLoading(new File(path));
            String[] packageName = {"teacher", "admin", "student"};
            for (String s : packageName) {
                List<Class<?>> classes = getClasses("edu.hubu.commons.model." + s);
                for (Class<?> clazz : classes) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("modelName", clazz.getSimpleName().replace(clazz.getSimpleName().charAt(0),
                            (char) (clazz.getSimpleName().charAt(0) + 32)));
                    map.put("modelClassName", clazz.getSimpleName());
                    map.put("packageName", s);
                    Field[] clazzFields = clazz.getDeclaredFields();
                    boolean hasDeleted = false;
                    for (Field f : clazzFields) {
                        f.setAccessible(true);
                        Object o = f.get(clazz.getConstructor().newInstance());
                        if (o instanceof BaseModel) {
                            continue;
                        }

                        if (o instanceof Collection<?>) {
                            continue;
                        }
                        if (Modifier.isStatic(f.getModifiers()) || Modifier.isFinal(f.getModifiers())) {
                            continue;
                        }
                        if (f.getName().endsWith("IsDeleted")) {
                            hasDeleted = true;
                        }
                    }
                    map.put("isDeleted", hasDeleted);
                    Template template = configuration.getTemplate("serviceinterface.flt");
                    //FileWriter writer = new FileWriter("/home/moonlan/code/java/educational-system/educational
                    // -system" +
                    //        "-commons/src/main/java/edu/hubu/commons/service/" + s + "/I" + clazz.getSimpleName() +
                    //        "Service.kt");
                    FileWriter writer =
                            new FileWriter("/home/moonlan/code/java/src/service/" + "I" + clazz.getSimpleName() +
                                    "Service.kt");
                    template.process(map, writer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findAndAddClassesInPackageByFile(String packageName, String packagePath,
                                                        final boolean recursive, List<Class<?>> classes) {
        //获取此包的目录 建立一个File
        File dir = new File(packagePath);
        //如果不存在或者 也不是目录就直接返回
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        //如果存在 就获取包下的所有文件 包括目录
        File[] dirfiles = dir.listFiles(new FileFilter() {
            //自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
            public boolean accept(File file) {
                return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
            }
        });
        //循环所有文件
        for (File file : dirfiles) {
            //如果是目录 则继续扫描
            if (file.isDirectory()) {
                findAndAddClassesInPackageByFile(packageName + "." + file.getName(),
                        file.getAbsolutePath(),
                        recursive,
                        classes);
            } else {
                //如果是java类文件 去掉后面的.class 只留下类名
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                    //添加到集合中去
                    classes.add(Class.forName(packageName + '.' + className));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static List<Class<?>> getClasses(String packageName) {

        //第一个class类的集合
        List<Class<?>> classes = new ArrayList<Class<?>>();
        //是否循环迭代
        boolean recursive = true;
        //获取包的名字 并进行替换
        String packageDirName = packageName.replace('.', '/');
        //定义一个枚举的集合 并进行循环来处理这个目录下的things
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            //循环迭代下去
            while (dirs.hasMoreElements()) {
                //获取下一个元素
                URL url = dirs.nextElement();
                //得到协议的名称
                String protocol = url.getProtocol();
                //如果是以文件的形式保存在服务器上
                if ("file".equals(protocol)) {
                    //获取包的物理路径
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    //以文件的方式扫描整个包下的文件 并添加到集合中
                    findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
                } else if ("jar".equals(protocol)) {
                    //如果是jar包文件
                    //定义一个JarFile
                    JarFile jar;
                    try {
                        //获取jar
                        jar = ((JarURLConnection) url.openConnection()).getJarFile();
                        //从此jar包 得到一个枚举类
                        Enumeration<JarEntry> entries = jar.entries();
                        //同样的进行循环迭代
                        while (entries.hasMoreElements()) {
                            //获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
                            JarEntry entry = entries.nextElement();
                            String name = entry.getName();
                            //如果是以/开头的
                            if (name.charAt(0) == '/') {
                                //获取后面的字符串
                                name = name.substring(1);
                            }
                            //如果前半部分和定义的包名相同
                            if (name.startsWith(packageDirName)) {
                                int idx = name.lastIndexOf('/');
                                //如果以"/"结尾 是一个包
                                if (idx != -1) {
                                    //获取包名 把"/"替换成"."
                                    packageName = name.substring(0, idx).replace('/', '.');
                                }
                                //如果可以迭代下去 并且是一个包
                                if ((idx != -1) || recursive) {
                                    //如果是一个.class文件 而且不是目录
                                    if (name.endsWith(".class") && !entry.isDirectory()) {
                                        //去掉后面的".class" 获取真正的类名
                                        String className = name.substring(packageName.length() + 1, name.length() - 6);
                                        try {
                                            //添加到classes
                                            classes.add(Class.forName(packageName + '.' + className));
                                        } catch (ClassNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }

}
