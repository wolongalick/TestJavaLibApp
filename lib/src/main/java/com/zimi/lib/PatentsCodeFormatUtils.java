package com.zimi.lib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * 功能: 软著代码格式化工具
 * 作者: 崔兴旺
 * 日期: 2020/3/16
 * 详情: 用来去除代码中的空行和注释,运行后生成的文件在当前目录,文件名为"整理后-XXX.txt"
 */
class PatentsCodeFormatUtils {

    public static void main(String[] args) {
        formatCode("D:/desktop/后30.txt");
    }

    /**
     * 格式化代码
     * @param filePath  源文件路径
     */
    private static void formatCode(String filePath) {
        File inputFile = new File(filePath);
        if (!inputFile.exists()) {
            System.err.println("文件不存在");
            return;
        }

        if (!inputFile.isFile()) {
            System.err.println("不是文件");
            return;
        }

        File           outputFile = new File(inputFile.getParentFile(), "整理后-" + inputFile.getName());
        BufferedReader br         = null;
        BufferedWriter bw         = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_8));

            String content;
            while ((content = br.readLine()) != null) {
                if (isValid(content)) {
                    bw.write(content);
                    bw.flush();
                    bw.newLine();
                }
            }
            System.out.println("成功");
        } catch (IOException e) {
            System.err.println("失败");
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 改行代码是否有效
     * @param lineContent   该行内容
     * @return
     */
    private static boolean isValid(String lineContent) {
        if (lineContent == null) {
            return false;
        }
        String trimStr = lineContent.trim();
        if ("".equals(trimStr)) {
            return false;
        }
        if (trimStr.startsWith("/") || trimStr.startsWith("*")) {
            return false;
        }
        return true;
    }

}