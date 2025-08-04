package com.xmzoda.systemmanage.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.mozilla.universalchardet.UniversalDetector;

/**
 * 文件读取工具类
 * 提供静态方法读取文本文件内容，并支持多种编码格式
 */
public class FileReaderUtil {
    /**
     * 读取指定路径的文本文件内容（支持多种编码格式）
     * @param filePath 文件绝对路径
     * @param charset 指定文件的编码格式（例如 UTF-8、GBK、UTF-16）
     * @return 文件内容字符串
     * @throws IOException 当文件不存在、读取失败或路径无效时抛出
     */
    public static String readFile(String filePath, String charset) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            throw new IOException("文件不存在: " + filePath);
        }
        if (!Files.isRegularFile(path)) {
            throw new IOException("路径不是文件: " + filePath);
        }
        try {
            return new String(Files.readAllBytes(path), Charset.forName(charset));
        } catch (Exception e) {
            throw new IOException("无法解析编码格式: " + charset, e);
        }
    }

    /**
     * 安全读取文件内容（支持多种编码格式）
     * @param filePath 文件绝对路径
     * @param charset 指定文件的编码格式（例如 UTF-8、GBK、UTF-16）
     * @param defaultValue 读取失败时返回的默认值
     * @return 文件内容或默认值
     */
    public static String readFileSafely(String filePath, String charset, String defaultValue) {
        try {
            return readFile(filePath, charset);
        } catch (IOException e) {
            System.err.println("文件读取错误: " + e.getMessage());
            return defaultValue;
        }
    }

    /**
     * 自动检测文件编码并读取内容
     * @param filePath 文件绝对路径
     * @return 文件内容字符串
     * @throws IOException 当文件不存在、读取失败或路径无效时抛出
     */
    public static String readFileWithAutoCharset(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            throw new IOException("文件不存在: " + filePath);
        }
        if (!Files.isRegularFile(path)) {
            throw new IOException("路径不是文件: " + filePath);
        }

        byte[] bytes = Files.readAllBytes(path);
        String detectedCharset = detectEncoding(bytes);
        return new String(bytes, Charset.forName(detectedCharset));
    }

    /**
     * 安全地自动检测文件编码并读取内容
     * @param filePath 文件绝对路径
     * @param defaultValue 读取失败时返回的默认值
     * @return 文件内容或默认值
     */
    public static String readFileWithAutoCharsetSafely(String filePath, String defaultValue) {
        try {
            return readFileWithAutoCharset(filePath);
        } catch (IOException e) {
            System.err.println("文件读取错误: " + e.getMessage());
            return defaultValue;
        }
    }

    /**
     * 使用 juniversalchardet 检测字节数组的编码
     * @param bytes 字节数据
     * @return 检测到的编码名称
     */
    private static String detectEncoding(byte[] bytes) {
        UniversalDetector detector = new UniversalDetector(null);
        detector.handleData(bytes, 0, bytes.length);
        detector.dataEnd();
        String detectedCharset = detector.getDetectedCharset();
        detector.reset();
        return detectedCharset != null ? detectedCharset : "UTF-8"; // 默认回退到 UTF-8
    }
}